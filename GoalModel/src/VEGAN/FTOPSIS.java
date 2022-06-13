package VEGAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import goalModel.Actor;
import goalModel.Decomposition;
import goalModel.EDecomposition;
import goalModel.EValueFrom;
import goalModel.GoalModel;
import goalModel.GoalModelFactory;
import goalModel.IntentionalElement;
import goalModel.Iteration;
import goalModel.ValueFrom;

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

	public static Tuple<GoalModel, Map<Integer, IntentionalElement>> calculateValue(GoalModel goalModel) {
		GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		Map<Integer, IntentionalElement> positionToIE = new HashMap<Integer, IntentionalElement>();
		
		//Identify the position -> Intentional element of the returned array
		int ieP = 0;
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				positionToIE.put(ieP++, ie);
			}
		}
		
		double[][] value2Criteria = de_hierarchize(goalModel, calculateValueToCriteria(goalModel), positionToIE);
		
		value2Criteria = MaxOrDecomposition(goalModel, value2Criteria, Propagation.propagate(goalModel).Item2);
		
		goalModel.setIteration(goalModel.getIteration() + 1);
		int iterationNumber = goalModel.getIteration();
		
		for(int i=0; i<ieP;i++) {
			
			IntentionalElement ie = positionToIE.get(i);
			double localValue = 0;
			double globalValue = 0;
			
			Iteration iteration = factory.createIteration();
			ie.getIterations().add(iteration);
			
			iteration.setIteration(iterationNumber);
			iteration.setImportance(ie.getImportance());
			iteration.setConfidence(ie.getConfidence());
			
			for(int j=0;j<ieP;j++) {
				if(value2Criteria[i][j] == 0)
					continue;
				
				globalValue+=value2Criteria[i][j];
				
				IntentionalElement criteria = positionToIE.get(j);
				
				if(ie.getActor().equals(criteria.getActor()))
					localValue+=value2Criteria[i][j];
				
				ValueFrom valueFrom = factory.createValueFrom();
				valueFrom.setIteration(iteration);
				valueFrom.setValue(value2Criteria[i][j]);
				valueFrom.setIntentionalelement(criteria);
				
				if(ie.getActor().equals(criteria.getActor()))
					valueFrom.setValueFrom(EValueFrom.LOCAL);
				else
					valueFrom.setValueFrom(EValueFrom.EXTERNAL);
			}
			
			ie.setLocalValue(localValue);
			ie.setGlobalValue(globalValue);
			
			iteration.setLocalValue(localValue);
			iteration.setGlobalValue(globalValue);
		}
				
		return new Tuple<GoalModel, Map<Integer, IntentionalElement>>(goalModel, positionToIE);
	}
	
	private static double[][] de_hierarchize(GoalModel goalModel, double[][] value2Criteria, Map<Integer, IntentionalElement> positionToIE) {
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(goalModel);
		
		//NON hierarchized
		double[][] performance = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		double[][] value2CriteriaDeHierarchize = value2Criteria.clone();
		
		List<IntentionalElement> toVisitIE = new ArrayList<IntentionalElement>();
		
		//Detect CRITERIA to dehierarchize
		for(int i = 0; i < value2Criteria.length; i++)
			for(int j = 0; j < value2Criteria.length; j++) {
				if(performance[i][j] != 0 && value2Criteria[i][j] == 0)
					if(!toVisitIE.contains(positionToIE.get(j)))
						toVisitIE.add(positionToIE.get(j));
			}

		while (!toVisitIE.isEmpty()) {
			IntentionalElement ie = toVisitIE.remove(0);
			
			Decomposition decomposition = (Decomposition) ie.getSrcLinks().stream().filter(link -> link instanceof Decomposition).findAny().get();
			
			//Anidation of decomposition
			if(decomposition.getTrgs().stream().anyMatch(child -> toVisitIE.contains(child)))
				toVisitIE.add(ie);
			
			int fatherPosition = ieToPosition.get(ie);
			
			//This is inefficient
			for(int i = 0; i < value2Criteria.length; i++)
			{
				for (Iterator<IntentionalElement> decompositionIterator = decomposition.getTrgs().iterator(); decompositionIterator.hasNext();)
				{
					IntentionalElement child = decompositionIterator.next();
					int childposition = ieToPosition.get(child);
					
					//Exception: Not to dehierarchize child
					if(i == childposition)
						break;
					
					value2CriteriaDeHierarchize[i][fatherPosition] += value2CriteriaDeHierarchize[i][childposition];
					value2CriteriaDeHierarchize[i][childposition] = 0;
				}
			}
		}
		
		return value2CriteriaDeHierarchize;
	}
	
	/**
	 * A parent of a decomposition ONLY takes the VALUE from the MAX child
	 * 
	 * PROBLEM:
	 * 	1- It doesn't consider decomposition of a decomposition
	 *  2- It is advisable to implement several strategies and allow to choose which one to use. Ex: Choose the child instead of Max, OR mean
	 *  
	 * PS: It takes into account the parent's links because they propagate to the child
	 */
	public static double[][] MaxOrDecomposition(GoalModel goalModel, double[][] value2Criteria, Map<IntentionalElement, Integer> ieToPosition)
	{
		double[][] value2CriteriaMaxOR = value2Criteria.clone();
		
		
		//Look for decompositions
		for(IntentionalElement ie : ieToPosition.keySet())
		{
			if(!ie.getSrcLinks().stream().anyMatch(link -> link instanceof Decomposition))
				continue;
			
			Decomposition decomposition = (Decomposition) ie.getSrcLinks().stream().filter(link -> link instanceof Decomposition).findAny().get();
			
			//Look for NOT AND decompositions
			if(decomposition == null || decomposition.getDecompositionType() == EDecomposition.AND)
				continue;
			
			//Identify MAX child
			int i = ieToPosition.get(ie);
			double maxValue = Double.MIN_VALUE;
			IntentionalElement maxChild = null;
			
			for (Iterator<IntentionalElement> decompositionIterator = decomposition.getTrgs().iterator(); decompositionIterator.hasNext();)
			{
				IntentionalElement child = decompositionIterator.next();
				
				int childPosition = ieToPosition.get(child);
				double currentValue = 0;
				
				for(int j=0;j<ieToPosition.size();j++)
				{
					currentValue += value2Criteria[childPosition][j];
				}
					
				if(currentValue > maxValue)
				{
					maxValue = currentValue;
					maxChild = child;
				}
			}
			
			if(maxChild == null)
				continue;
			
			int childPosition = ieToPosition.get(maxChild);
			
			//Parent Value comes from MAXCHILD
			for(int j=0;j<ieToPosition.size();j++)
			{
				if(j != childPosition && j != i)
					value2CriteriaMaxOR[i][j] = value2Criteria[childPosition][j];
			}
		}
		
		
		return value2CriteriaMaxOR;
	}
}
