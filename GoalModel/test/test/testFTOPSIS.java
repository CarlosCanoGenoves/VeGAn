package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import VEGAN.*;
import goalModel.Actor;
import goalModel.EConfidence;
import goalModel.EImportance;
import goalModel.GoalModel;
import goalModel.IntentionalElement;

class testFTOPSIS {

	
	@Test
	void testcalculateActorWeight() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/actorWeight.xmi");
		FuzzyNumber[] expectedOutput = {new FuzzyNumber(EImportance.VERY_HIGH, EConfidence.POSSIBLY_MORE), new FuzzyNumber(EImportance.MEDIUM, EConfidence.CONFIDENT), new FuzzyNumber(EImportance.VERY_LOW, EConfidence.POSSIBLY_LESS)};
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> o = FTOPSIS.calculateActorWeight(myLoadedGoalModel);
		
		FuzzyNumber[] output = o.Item1;
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testcalculateIEWeight() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/simpleCriteriaWeight.xmi");
		FuzzyNumber[] expectedOutput = {new FuzzyNumber(EImportance.VERY_HIGH, EConfidence.POSSIBLY_MORE), new FuzzyNumber(EImportance.MEDIUM, EConfidence.CONFIDENT), new FuzzyNumber(EImportance.VERY_LOW, EConfidence.POSSIBLY_LESS)};
		
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		
		FuzzyNumber[] output = FTOPSIS.calculateIEWeight(myLoadedGoalModel, p.Item2);
		
		assertArrayEquals(expectedOutput, output);
		
		myLoadedGoalModel = UsingEMFModel.load("testModels/complexCriteriaWeight.xmi");
		expectedOutput[0] = new FuzzyNumber(EImportance.VERY_HIGH, EConfidence.POSSIBLY_MORE);
		
		expectedOutput[1] = new FuzzyNumber(8.2, 8.34, 8.15);
		
		expectedOutput[2] = new FuzzyNumber(1.47, 1.91, 2.85);
		
		
		p = Propagation.propagate(myLoadedGoalModel);
		output = FTOPSIS.calculateIEWeight(myLoadedGoalModel, p.Item2);
		
		
		for(int i=0;i<output.length;i++)
		{
			assertEquals(expectedOutput[i].n1, Math.round(output[i].n1*100.0)/100.0);
			assertEquals(expectedOutput[i].n2, Math.round(output[i].n2*100.0)/100.0);
			assertEquals(expectedOutput[i].n3, Math.round(output[i].n3*100.0)/100.0);
		}
		
		myLoadedGoalModel = UsingEMFModel.load("testModels/complexCriteriaWeight2.xmi");
		expectedOutput = new FuzzyNumber[5];
		
		expectedOutput[0] = new FuzzyNumber(EImportance.VERY_HIGH, EConfidence.POSSIBLY_MORE);
		expectedOutput[1] = new FuzzyNumber(8.2, 8.34, 8.15);
		expectedOutput[2] = new FuzzyNumber(1.47, 1.91, 2.85);
		
		expectedOutput[3] = new FuzzyNumber(5.2, 5.26 ,5.08);
		expectedOutput[4] = new FuzzyNumber(3.01, 3.08, 3.07);
		
		p = Propagation.propagate(myLoadedGoalModel);
		output = FTOPSIS.calculateIEWeight(myLoadedGoalModel, p.Item2);
		
		
		for(int i=0;i<output.length;i++)
		{
			assertEquals(expectedOutput[i].n1, Math.round(output[i].n1*100.0)/100.0);
			assertEquals(expectedOutput[i].n2, Math.round(output[i].n2*100.0)/100.0);
			assertEquals(expectedOutput[i].n3, Math.round(output[i].n3*100.0)/100.0);
		}
	}
	
	//Weighted Normalized Fuzzy Performance Matrix
	void testCalculateWFNM() {
		GoalModel goalModel = UsingEMFModel.load("testModels/simpleCriteriaWeight.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(goalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		//Fuzzy Performance Matrix
		FuzzyNumber[][] fuzzyPerformanceMatrix = FuzzyNumber.fuzzyfy(performanceMatrix);
		
		//Normalized Fuzzy Performance Matrix
		FuzzyNumber[][] normalizedFuzzyPerformanceMatrix = FTOPSIS.normalizeMatrix(fuzzyPerformanceMatrix);
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tupleActorWeight = FTOPSIS.calculateActorWeight(goalModel);
		
		FuzzyNumber[] actorWeight = tupleActorWeight.Item1;
		Map<Actor, Integer> actorToPosition = tupleActorWeight.Item2;
		
		FuzzyNumber[] ieWeight = FTOPSIS.calculateIEWeight(goalModel, ieToPosition);
		
		FuzzyNumber[][] weightedNormalizedFuzzyPerformanceMatrix = FTOPSIS.calculateWFNM(goalModel, normalizedFuzzyPerformanceMatrix, actorWeight, ieWeight, ieToPosition, actorToPosition);
		
		//FuzzyNumber[][] expectedOutput = {};
	}

}
