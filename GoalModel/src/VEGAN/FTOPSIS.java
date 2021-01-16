package VEGAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import goalModel.Actor;
import goalModel.Decomposition;
import goalModel.Goal;
import goalModel.GoalModel;
import goalModel.IntentionalElement;

public class FTOPSIS {

	
	public static FuzzyNumber[][] normalizeMatrix(FuzzyNumber[][] matrix)
	{
		//Fuzzy numbers go from -11 to 11 so the Max value is 11
		return normalizeMatrix(matrix, 11);
	}
	
	public static FuzzyNumber[][] normalizeMatrix(FuzzyNumber[][] matrix, double maxValue)
	{
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix.length;j++)
			{
				matrix[i][j].n1 = matrix[i][j].n1 / maxValue;
				matrix[i][j].n2 = matrix[i][j].n2 / maxValue;
				matrix[i][j].n3 = matrix[i][j].n3 / maxValue;
			}
				
		return matrix;
	}
	
	
	public static Tuple<FuzzyNumber[], Map<Actor, Integer>> calculateActorWeight(GoalModel goalModel)
	{
		List<FuzzyNumber> actorWeight = new ArrayList<FuzzyNumber>();
		Map<Actor, Integer> actorToPosition = new HashMap<Actor, Integer>();
		
		int i = 0;
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
			
			actorWeight.add(new FuzzyNumber(actor.getImportance(), actor.getConfidence()));
			actorToPosition.put(actor, i++);
		}
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tuple = new Tuple<FuzzyNumber[], Map<Actor,Integer>>((FuzzyNumber[])actorWeight.toArray(), actorToPosition);
		
		return tuple;
	}
	
	public static FuzzyNumber[] calculateIEWeight(GoalModel goalModel, Map<IntentionalElement, Integer> ieToPosition)
	{
		FuzzyNumber[] ieWeight = new FuzzyNumber[ieToPosition.size()];
		List<IntentionalElement> toVisitIE = new ArrayList<IntentionalElement>();
		
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				ieWeight[ieToPosition.get(ie)] = new FuzzyNumber(ie.getImportance(), ie.getConfidence());
				
				if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Decomposition))
					toVisitIE.add(ie);
			}
		}
		
		// Criteria hierarchy using decomposition links
		while (!toVisitIE.isEmpty())
		{
			IntentionalElement ie = toVisitIE.remove(0);
			
			if(ie.getTrgLinks().stream().anyMatch(link -> link instanceof Decomposition && toVisitIE.contains(link.getSrc())))
			{
				toVisitIE.add(ie);
				continue;
			}
			
			Decomposition dec = (Decomposition)ie.getSrcLinks().stream().filter(link -> link instanceof Decomposition).findFirst().get();
			
			FuzzyNumber total = new FuzzyNumber(0,0,0);
			
			// Calculate the total importance of children
			for (Iterator<IntentionalElement> ieIterator = dec.getTrgs().iterator(); ieIterator.hasNext();) {
				IntentionalElement child = (IntentionalElement) ieIterator.next();

				total.n1 += ieWeight[ieToPosition.get(child)].n1;
				total.n2 += ieWeight[ieToPosition.get(child)].n2;
				total.n3 += ieWeight[ieToPosition.get(child)].n3;
			}
 
			for (Iterator<IntentionalElement> ieIterator = dec.getTrgs().iterator(); ieIterator.hasNext();) {
				IntentionalElement child = (IntentionalElement) ieIterator.next();

				ieWeight[ieToPosition.get(child)].n1 = ieWeight[ieToPosition.get(child)].n1 / total.n1;
				ieWeight[ieToPosition.get(child)].n2 = ieWeight[ieToPosition.get(child)].n2 / total.n2;
				ieWeight[ieToPosition.get(child)].n3 = ieWeight[ieToPosition.get(child)].n3 / total.n3;
			}
		}
		
		return ieWeight;
	}
}
