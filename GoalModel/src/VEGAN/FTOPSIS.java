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

	
	/**
	 * Hierarchizes the decomposition links
	 * 
	 * All the link TO an IE that is decomposed is traspassed to its children
	 * 
	 * Example:
	 * A	B	C
	 * 100	0	0
	 * 0	100	0
	 * 0	0	100
	 * 
	 * GOES TO
	 * 
	 * A	B	C
	 * 0	100	100
	 * 0	100	0
	 * 0	0	100 
	 * */
	public static double[][] hierarchizePerformanceMatrix(GoalModel goalModel, double[][] performanceMatrix, Map<IntentionalElement, Integer> ieToPosition) {
		double[][] hierarchicaPerformancelMatrix = performanceMatrix.clone();
		
		List<IntentionalElement> toVisitIE = new ArrayList<IntentionalElement>();
		
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Decomposition))
					toVisitIE.add(ie);
			}
		}
		
		while (!toVisitIE.isEmpty()) {
		
			IntentionalElement ie = toVisitIE.remove(0);
			
			//
			if(ie.getTrgLinks().stream().anyMatch(link -> link instanceof Decomposition && toVisitIE.contains(link.getSrc())))
			{
				toVisitIE.add(ie);
				continue;
			}
			
			int iePos = ieToPosition.get(ie);
			
			for (int i = 0; i < hierarchicaPerformancelMatrix.length; i++)
			{
				if(hierarchicaPerformancelMatrix[i][iePos] != 0)
				{
					Decomposition dec = (Decomposition) ie.getSrcLinks().stream().filter(link -> link instanceof Decomposition).findAny().get();
					
					for (Iterator<IntentionalElement> ieIterator = dec.getTrgs().iterator(); ieIterator.hasNext();)
					{
						IntentionalElement child = (IntentionalElement) ieIterator.next();
						
						int childPos = ieToPosition.get(child);
						
						if(hierarchicaPerformancelMatrix[i][iePos] == Double.MAX_VALUE || hierarchicaPerformancelMatrix[i][childPos] == Double.MAX_VALUE)
						{
							hierarchicaPerformancelMatrix[i][childPos] = Double.MAX_VALUE;
						}
						else
						{
							hierarchicaPerformancelMatrix[i][childPos] = hierarchicaPerformancelMatrix[i][childPos] + hierarchicaPerformancelMatrix[i][iePos];
						}
					}
					hierarchicaPerformancelMatrix[i][iePos] = 0;
				}
			}
		}
		
		
		return hierarchicaPerformancelMatrix;
	}
	
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
			
			actorWeight[i] = new FuzzyNumber(actor.getImportance(), actor.getConfidence());
			actorToPosition.put(actor, i++);
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
				
				for (int i = 0; i < NFPM.length; i++) {
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
		
		double[][] hierarchizePerformanceMatrix = hierarchizePerformanceMatrix(goalModel, performanceMatrix, ieToPosition);
		
		//Fuzzy Performance Matrix
		FuzzyNumber[][] fuzzyPerformanceMatrix = FuzzyNumber.fuzzyfy(hierarchizePerformanceMatrix);
		
		//Normalized Fuzzy Performance Matrix
		FuzzyNumber[][] normalizedFuzzyPerformanceMatrix = normalizeMatrix(fuzzyPerformanceMatrix);
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tupleActorWeight = calculateActorWeight(goalModel);
		
		FuzzyNumber[] actorWeight = tupleActorWeight.Item1;
		Map<Actor, Integer> actorToPosition = tupleActorWeight.Item2;
		
		FuzzyNumber[] ieWeight = calculateIEWeight(goalModel, ieToPosition);
		
		return calculateWFNM(goalModel, normalizedFuzzyPerformanceMatrix, actorWeight, ieWeight, ieToPosition, actorToPosition);
	}

	/**
	 * The RIGHT code of the FPIS & FNIS calculation
	 * @return Matrix [2][?] where [0][X] = FPIS and [1][X] = FNIS
	 */
	public static FuzzyNumber[][] ORIGINALcalculateFPIS_FNIS(FuzzyNumber[][] WFNM)
	{
		FuzzyNumber[][] FPIS_FNIS = new FuzzyNumber[2][WFNM.length];
		
		
		for (int j = 0; j < WFNM.length; j++)
		{
			FPIS_FNIS[0][j] = new FuzzyNumber(0);
			FPIS_FNIS[1][j] = new FuzzyNumber(0);
			
			for (int i = 0; i < WFNM.length; i++)
			{
				//Only needs to compare one element of the fuzzy number
				if (WFNM[i][j].n1 > FPIS_FNIS[0][j].n1)
					FPIS_FNIS[0][j] = WFNM[i][j];
				else if (WFNM[i][j].n1 < FPIS_FNIS[1][j].n1)
					FPIS_FNIS[1][j] = WFNM[i][j];
			}
		}
		
		return FPIS_FNIS;
	}
	
	/**
	 * Modified version of the FPIS & FNIS calculation for VEGAN
	 * The difference is that FNIS is ALWAYS 0
	 * This change has been made to identify NEGATIVE values
	 * 
	 * @return Matrix [2][?] where [0][X] = FPIS and [1][X] = FNIS
	 */
	public static FuzzyNumber[][] calculateFPIS_FNIS(FuzzyNumber[][] WFNM)
	{
		FuzzyNumber[][] FPIS_FNIS = new FuzzyNumber[2][WFNM.length];
		
		
		for (int i = 0; i < WFNM.length; i++)
		{
			FPIS_FNIS[0][i] = WFNM[i][i];	//A criteria ALWAYS have the max value with himself
			FPIS_FNIS[1][i] = new FuzzyNumber(0);//ALWAYS 0
		}
		
		return FPIS_FNIS;
	}
	
	
	/**
	 * 
	 * @param WFNM Matrix[ALTERIATIVE][CRITERIA]
	 * @param FPIS_FNIS FPIS_FNIS  Matrix [2][?] where [0][X] = FPIS and [1][X] = FNIS
	 * @return double[ALTERNATIVE][CRITERIA] distance FPIS & distance FNIS
	 */
	public static Tuple<double[][], double[][]> calculateDistanceToFPIS_FNIS(FuzzyNumber[][] WFNM, FuzzyNumber[][] FPIS_FNIS)
	{
		double[][] distanceFPIS = new double[WFNM.length][WFNM.length];
		double[][] distanceFNIS = new double[WFNM.length][WFNM.length];
		
		for (int i = 0; i < WFNM.length; i++) {
			for (int j = 0; j < WFNM.length; j++) {
				distanceFPIS[i][j] = FuzzyNumber.euclideanDistance(WFNM[i][j], FPIS_FNIS[0][j]);
				distanceFNIS[i][j] = FuzzyNumber.euclideanDistance(WFNM[i][j], FPIS_FNIS[1][j]);
				
				if(WFNM[i][j].n1<0)
				{
					distanceFPIS[i][j] = distanceFPIS[i][j]*-1;
					distanceFNIS[i][j] = distanceFNIS[i][j]*-1;
				}
			}
		}
		
		return new Tuple<double[][], double[][]>(distanceFPIS, distanceFNIS);
	}
	
	/**
	 * 
	 * @param FPIS_FNIS  Matrix [2][?] where [0][X] = FPIS and [1][X] = FNIS
	 * @return
	 */
	public static double totalDistance(FuzzyNumber[][] FPIS_FNIS)
	{
		double total = 0;

		for (int i = 0; i < FPIS_FNIS[0].length; i++) {
			double distance = FuzzyNumber.euclideanDistance(FPIS_FNIS[0][i], FPIS_FNIS[1][i]);
			total = total + distance;
		}
		
		return total;
	}
	
	public static double[][] calculateValueToCriteria(double[][] distanceFNIS, double totalDistance)
	{
		double[][] valueToCriteria = new double[distanceFNIS.length][distanceFNIS.length];
		
		for (int i = 0; i < distanceFNIS.length; i++) {
			for (int j = 0; j < distanceFNIS.length; j++) {
				valueToCriteria[i][j] = (distanceFNIS[i][j] / totalDistance) * 100;
			}
		}
		
		return valueToCriteria;
	}
	
	public static double[][] calculateValueToCriteria(GoalModel goalmodel) {
		FuzzyNumber[][] WFNM = calculateWFNM(goalmodel);
		FuzzyNumber[][] FPIS_FNIS = calculateFPIS_FNIS(WFNM);
		double totalDistance = totalDistance(FPIS_FNIS);
		Tuple<double[][], double[][]> distances = calculateDistanceToFPIS_FNIS(WFNM, FPIS_FNIS);
		
		return calculateValueToCriteria(distances.Item2, totalDistance);
	}
}
