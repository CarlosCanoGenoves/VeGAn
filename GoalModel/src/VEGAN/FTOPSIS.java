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
		//Fuzzy numbers go from -11 to 11 therefore the Max value is 11
		return normalizeMatrix(matrix, 11);
	}
	
	private static FuzzyNumber[][] normalizeMatrix(FuzzyNumber[][] matrix, double maxValue)
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
		FuzzyNumber[] actorWeight = new FuzzyNumber[goalModel.getActors().size()];
		Map<Actor, Integer> actorToPosition = new HashMap<Actor, Integer>();
		
		int i = 0;
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
			
			actorWeight[i++] = new FuzzyNumber(actor.getImportance(), actor.getConfidence());
			actorToPosition.put(actor, i);
		}
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tuple = new Tuple<FuzzyNumber[], Map<Actor,Integer>>(actorWeight, actorToPosition);
		
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

				ieWeight[ieToPosition.get(child)].n1 = (ieWeight[ieToPosition.get(child)].n1 / total.n1) * ieWeight[ieToPosition.get(ie)].n1;
				ieWeight[ieToPosition.get(child)].n2 = (ieWeight[ieToPosition.get(child)].n2 / total.n2) * ieWeight[ieToPosition.get(ie)].n2;
				ieWeight[ieToPosition.get(child)].n3 = (ieWeight[ieToPosition.get(child)].n3 / total.n3) * ieWeight[ieToPosition.get(ie)].n3;
			}
		}
		
		return ieWeight;
	}
	
	// Weighted Normalized Fuzzy Performance Matrix
	public static FuzzyNumber[][] calculateWFNM(GoalModel goalModel, FuzzyNumber[][] NFPM, FuzzyNumber[] actorWeight,
			FuzzyNumber[] ieWeight, Map<IntentionalElement, Integer> ieToPosition,
			Map<Actor, Integer> actorToPosition) {

		FuzzyNumber[][] WFNPM = new FuzzyNumber[NFPM.length][NFPM.length];
		
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
			
			int actorP = actorToPosition.get(actor);
			
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				
				int ieP = ieToPosition.get(ie);
				
				for(int i=0;i<NFPM.length;i++)
				{
					double n1 = NFPM[i][ieP].n1 * actorWeight[actorP].n1 * ieWeight[ieP].n1;
					double n2 = NFPM[i][ieP].n2 * actorWeight[actorP].n2 * ieWeight[ieP].n2;
					double n3 = NFPM[i][ieP].n3 * actorWeight[actorP].n3 * ieWeight[ieP].n3;
					
					WFNPM[i][ieP] = new FuzzyNumber(n1, n2, n3);
				}
				
			}
		}
		
		return WFNPM;
	}
	
	
	public static FuzzyNumber[][] calculateWFNM(GoalModel goalModel) {
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(goalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		//Fuzzy Performance Matrix
		FuzzyNumber[][] fuzzyPerformanceMatrix = FuzzyNumber.fuzzyfy(performanceMatrix);
		
		//Normalized Fuzzy Performance Matrix
		FuzzyNumber[][] normalizedFuzzyPerformanceMatrix = normalizeMatrix(fuzzyPerformanceMatrix);
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tupleActorWeight = calculateActorWeight(goalModel);
		
		FuzzyNumber[] actorWeight = tupleActorWeight.Item1;
		Map<Actor, Integer> actorToPosition = tupleActorWeight.Item2;
		
		FuzzyNumber[] ieWeight = calculateIEWeight(goalModel, ieToPosition);
		
		return calculateWFNM(goalModel, normalizedFuzzyPerformanceMatrix, actorWeight, ieWeight, ieToPosition, actorToPosition);
	}
}
