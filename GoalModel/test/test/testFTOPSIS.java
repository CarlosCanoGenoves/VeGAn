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
	void testcalculateSimpleIEWeight()
	{
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/simpleCriteriaWeight.xmi");
		FuzzyNumber[] expectedOutput = {new FuzzyNumber(EImportance.VERY_HIGH, EConfidence.POSSIBLY_MORE), new FuzzyNumber(EImportance.MEDIUM, EConfidence.CONFIDENT), new FuzzyNumber(EImportance.VERY_LOW, EConfidence.POSSIBLY_LESS)};
		
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		
		FuzzyNumber[] output = FTOPSIS.calculateIEWeight(myLoadedGoalModel, p.Item2);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testcalculateComplexIEWeight() {
		
		
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/complexCriteriaWeight.xmi");
		
		FuzzyNumber[] expectedOutput = {new FuzzyNumber(EImportance.VERY_HIGH, EConfidence.POSSIBLY_MORE), new FuzzyNumber(8.2, 8.34, 8.15),  new FuzzyNumber(1.47, 1.91, 2.85)};
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		FuzzyNumber[] output = FTOPSIS.calculateIEWeight(myLoadedGoalModel, p.Item2);
		
		
		for(int i=0;i<output.length;i++)
		{
			assertEquals(expectedOutput[i].n1, Math.round(output[i].n1*100.0)/100.0);
			assertEquals(expectedOutput[i].n2, Math.round(output[i].n2*100.0)/100.0);
			assertEquals(expectedOutput[i].n3, Math.round(output[i].n3*100.0)/100.0);
		}
	}
	
	@Test
	void testcalculateMoreComplexIEWeight() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/complexCriteriaWeight2.xmi");
		FuzzyNumber[] expectedOutput = new FuzzyNumber[5];
		
		expectedOutput[0] = new FuzzyNumber(EImportance.VERY_HIGH, EConfidence.POSSIBLY_MORE);
		expectedOutput[1] = new FuzzyNumber(8.2, 8.34, 8.15);
		expectedOutput[2] = new FuzzyNumber(1.47, 1.91, 2.85);
		
		expectedOutput[3] = new FuzzyNumber(5.2, 5.26 ,5.08);
		expectedOutput[4] = new FuzzyNumber(3.01, 3.08, 3.07);
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		FuzzyNumber[] output = FTOPSIS.calculateIEWeight(myLoadedGoalModel, p.Item2);
		
		
		for(int i=0;i<output.length;i++)
		{
			assertEquals(expectedOutput[i].n1, Math.round(output[i].n1*100.0)/100.0);
			assertEquals(expectedOutput[i].n2, Math.round(output[i].n2*100.0)/100.0);
			assertEquals(expectedOutput[i].n3, Math.round(output[i].n3*100.0)/100.0);
		}
	}


	@Test
	void testherarchizeSimplePM() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/simpleCriteriaWeight.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(myLoadedGoalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		double[][] herarchizedPerformanceMatrix = FTOPSIS.hierarchizePerformanceMatrix(myLoadedGoalModel, performanceMatrix, ieToPosition);
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0},
				{0, Double.MAX_VALUE, 0},
				{0, 0, Double.MAX_VALUE}};
		
		assertArrayEquals(expectedOutput, herarchizedPerformanceMatrix);
	}
	
	@Test
	void testherarchizeComplexPM() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/complexCriteriaWeight.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(myLoadedGoalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		double[][] herarchizedPerformanceMatrix = FTOPSIS.hierarchizePerformanceMatrix(myLoadedGoalModel, performanceMatrix, ieToPosition);
		double[][] expectedOutput = {
				{0, Double.MAX_VALUE, Double.MAX_VALUE},
				{0, Double.MAX_VALUE, 0},
				{0, 0, Double.MAX_VALUE}};
		
		assertArrayEquals(expectedOutput, herarchizedPerformanceMatrix);
	}
	
	@Test
	void testherarchizeMoreComplexPM() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/complexCriteriaWeight2.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(myLoadedGoalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		double[][] herarchizedPerformanceMatrix = FTOPSIS.hierarchizePerformanceMatrix(myLoadedGoalModel, performanceMatrix, ieToPosition);
		double[][] expectedOutput = {
				{0, 0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
				{0, 0, 0, Double.MAX_VALUE, Double.MAX_VALUE},
				{0, 0, Double.MAX_VALUE, 0, 0},
				{0, 0, 0, Double.MAX_VALUE, 0},
				{0, 0, 0, 0, Double.MAX_VALUE}};
		
		assertArrayEquals(expectedOutput, herarchizedPerformanceMatrix);
	}
	
	@Test
	void testherarchizePMAddition() {
		//Test what happens when you contribute to parent and child
		
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/hierarchize.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(myLoadedGoalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		double[][] herarchizedPerformanceMatrix = FTOPSIS.hierarchizePerformanceMatrix(myLoadedGoalModel, performanceMatrix, ieToPosition);
		double[][] expectedOutput = {
				{0, Double.MAX_VALUE, Double.MAX_VALUE, 0},
				{0, Double.MAX_VALUE, 0, 0},
				{0, 0, Double.MAX_VALUE, 0},
				{0, 50-75, 50, Double.MAX_VALUE}};
		
		assertArrayEquals(expectedOutput, herarchizedPerformanceMatrix);
	}


	@Test
	//Weighted Normalized Fuzzy Performance Matrix
	void testCalculateSimpleWFNM() {
		GoalModel goalModel = UsingEMFModel.load("testModels/simpleCriteriaWeight.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(goalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		double[][] herarchizedPerformanceMatrix = FTOPSIS.hierarchizePerformanceMatrix(goalModel, performanceMatrix, ieToPosition);
		
		//Fuzzy Performance Matrix
		FuzzyNumber[][] fuzzyPerformanceMatrix = FuzzyNumber.fuzzyfy(herarchizedPerformanceMatrix);
		
		//Normalized Fuzzy Performance Matrix
		FuzzyNumber[][] normalizedFuzzyPerformanceMatrix = FTOPSIS.normalizeMatrix(fuzzyPerformanceMatrix);
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tupleActorWeight = FTOPSIS.calculateActorWeight(goalModel);
		
		FuzzyNumber[] actorWeight = tupleActorWeight.Item1;
		Map<Actor, Integer> actorToPosition = tupleActorWeight.Item2;
		
		FuzzyNumber[] ieWeight = FTOPSIS.calculateIEWeight(goalModel, ieToPosition);
		
		FuzzyNumber[][] weightedNormalizedFuzzyPerformanceMatrix = FTOPSIS.calculateWFNM(goalModel, normalizedFuzzyPerformanceMatrix, actorWeight, ieWeight, ieToPosition, actorToPosition);
		
		FuzzyNumber[][] output = weightedNormalizedFuzzyPerformanceMatrix;
		
		FuzzyNumber[][] expectedOutput = {
				{new FuzzyNumber(85.01, 105.06, 121), new FuzzyNumber(0), new FuzzyNumber(0)},
				{new FuzzyNumber(0), new FuzzyNumber(49.23, 61.5, 73.26), new FuzzyNumber(0)},
				{new FuzzyNumber(0), new FuzzyNumber(0), new FuzzyNumber(8.79, 14.04, 25.63)}
		};
		
		for (int i = 0; i < expectedOutput.length; i++) {
			for (int j = 0; j < expectedOutput.length; j++) {
				assertEquals(expectedOutput[i][j].n1, Math.round(output[i][j].n1 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n2, Math.round(output[i][j].n2 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n3, Math.round(output[i][j].n3 * 100.0) / 100.0);
			}
		}
		
		
	}
	
	@Test
	void testCalculateComplexWFNM() {
		GoalModel goalModel = UsingEMFModel.load("testModels/complexCriteriaWeight.xmi");
		
		FuzzyNumber[][] output = FTOPSIS.calculateWFNM(goalModel);
		FuzzyNumber[][] expectedOutput = new FuzzyNumber[output.length][output.length];
		
		//Calculate WITH ALL THE DECIMALS or there will be a difference
		expectedOutput[0][0] = new FuzzyNumber(0);
		expectedOutput[0][1] = new FuzzyNumber(72.13, 85.53, 89.64);
		expectedOutput[0][2] = new FuzzyNumber(12.88, 19.53, 31.36);
		
		expectedOutput[1][0] = new FuzzyNumber(0);
		expectedOutput[1][1] = new FuzzyNumber(72.13, 85.53, 89.64);
		expectedOutput[1][2] = new FuzzyNumber(0);
		
		expectedOutput[2][0] = new FuzzyNumber(0);
		expectedOutput[2][1] = new FuzzyNumber(0);
		expectedOutput[2][2] = new FuzzyNumber(12.88, 19.53, 31.36);
		
		for (int i = 0; i < expectedOutput.length; i++) {
			for (int j = 0; j < expectedOutput.length; j++) {
				assertEquals(expectedOutput[i][j].n1, Math.round(output[i][j].n1 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n2, Math.round(output[i][j].n2 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n3, Math.round(output[i][j].n3 * 100.0) / 100.0);
			}
		}
	}
	
	@Test
	void testCalculateMoreComplexWFNM() {
		GoalModel goalModel = UsingEMFModel.load("testModels/complexCriteriaWeight2.xmi");
		
		FuzzyNumber[][] output = FTOPSIS.calculateWFNM(goalModel);
		FuzzyNumber[][] expectedOutput = new FuzzyNumber[output.length][output.length];
		
		//Calculate WITH ALL THE DECIMALS or there will be a difference
		expectedOutput[0][0] = new FuzzyNumber(0);
		expectedOutput[0][1] = new FuzzyNumber(0);
		expectedOutput[0][2] = new FuzzyNumber(12.88, 19.53, 31.36);
		expectedOutput[0][3] = new FuzzyNumber(45.68, 53.95, 55.83);
		expectedOutput[0][4] = new FuzzyNumber(26.45, 31.58, 33.81);
		
		expectedOutput[1][0] = new FuzzyNumber(0);
		expectedOutput[1][1] = new FuzzyNumber(0);
		expectedOutput[1][2] = new FuzzyNumber(0);
		expectedOutput[1][3] = new FuzzyNumber(45.68, 53.95, 55.83);
		expectedOutput[1][4] = new FuzzyNumber(26.45, 31.58, 33.81);
		
		expectedOutput[2][0] = new FuzzyNumber(0);
		expectedOutput[2][1] = new FuzzyNumber(0);
		expectedOutput[2][2] = new FuzzyNumber(12.88, 19.53, 31.36);
		expectedOutput[2][3] = new FuzzyNumber(0);
		expectedOutput[2][4] = new FuzzyNumber(0);
		
		expectedOutput[3][0] = new FuzzyNumber(0);
		expectedOutput[3][1] = new FuzzyNumber(0);
		expectedOutput[3][2] = new FuzzyNumber(0);
		expectedOutput[3][3] = new FuzzyNumber(45.68, 53.95, 55.83);
		expectedOutput[3][4] = new FuzzyNumber(0);
		
		expectedOutput[4][0] = new FuzzyNumber(0);
		expectedOutput[4][1] = new FuzzyNumber(0);
		expectedOutput[4][2] = new FuzzyNumber(0);
		expectedOutput[4][3] = new FuzzyNumber(0);
		expectedOutput[4][4] = new FuzzyNumber(26.45, 31.58, 33.81);
		
		for (int i = 0; i < expectedOutput.length; i++) {
			for (int j = 0; j < expectedOutput.length; j++) {
				assertEquals(expectedOutput[i][j].n1, Math.round(output[i][j].n1 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n2, Math.round(output[i][j].n2 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n3, Math.round(output[i][j].n3 * 100.0) / 100.0);
			}
		}
	}

	@Test
	void testFTOPSIS_FNIS() {
		GoalModel goalModel = UsingEMFModel.load("testModels/FPIS_FNIS.xmi");
		FuzzyNumber[][] WFNM = FTOPSIS.calculateWFNM(goalModel);
		
		FuzzyNumber[][] output = FTOPSIS.calculateFPIS_FNIS(WFNM);
		FuzzyNumber[][] expectedOutput = new FuzzyNumber[2][WFNM.length];
		
		expectedOutput[0][0] = new FuzzyNumber(83.69, 99.12, 109.12);
		expectedOutput[0][1] = new FuzzyNumber(67.69, 82, 93.72);
		expectedOutput[0][2] = new FuzzyNumber(49.23, 61.50, 73.26);
		expectedOutput[0][3] = new FuzzyNumber(29.63, 41, 53.46);
		expectedOutput[0][4] = new FuzzyNumber(15.65, 23.88, 34.76);
		
		expectedOutput[1][0] = new FuzzyNumber(0);
		expectedOutput[1][1] = new FuzzyNumber(0);
		expectedOutput[1][2] = new FuzzyNumber(0);
		expectedOutput[1][3] = new FuzzyNumber(0);
		expectedOutput[1][4] = new FuzzyNumber(0);
		
		/* This result is obtained with the ORIGINALcalculateFPIS_FNIS
		expectedOutput[1][0] = new FuzzyNumber(-92.06, -90.11, -79.36);
		expectedOutput[1][1] = new FuzzyNumber(-67.69, -59.64, -51.12);
		expectedOutput[1][2] = new FuzzyNumber(-39.38, -33.55, -26.64);
		expectedOutput[1][3] = new FuzzyNumber(-17.78, -14.91, -9.72);
		expectedOutput[1][4] = new FuzzyNumber(0);
		 */
		
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < WFNM.length; j++) {
				assertEquals(expectedOutput[i][j].n1, Math.round(output[i][j].n1 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n2, Math.round(output[i][j].n2 * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j].n3, Math.round(output[i][j].n3 * 100.0) / 100.0);
			}
		}
	}
	
	@Test
	void testTotalDistance() {
		GoalModel goalModel = UsingEMFModel.load("testModels/FPIS_FNIS.xmi");
		FuzzyNumber[][] WFNM = FTOPSIS.calculateWFNM(goalModel);
		
		FuzzyNumber[][] FPIS_FNIS = FTOPSIS.calculateFPIS_FNIS(WFNM);
		double output = FTOPSIS.totalDistance(FPIS_FNIS);
		double expectedOutput = 310.27;
		
		assertEquals(expectedOutput, Math.round(output*100)/100.0);		
	}
	
	@Test
	void testDistanceToFPIS_FNIS() {
		
		GoalModel goalModel = UsingEMFModel.load("testModels/FPIS_FNIS.xmi");
		FuzzyNumber[][] WFNM = FTOPSIS.calculateWFNM(goalModel);
		
		FuzzyNumber[][] FPIS_FNIS = FTOPSIS.calculateFPIS_FNIS(WFNM);
		Tuple<double[][], double[][]> distances = FTOPSIS.calculateDistanceToFPIS_FNIS(WFNM, FPIS_FNIS);
		
		double[][] distanceFPIS = distances.Item1;
		double[][] distanceFNIS = distances.Item2;
		
		double[][] expectedDistanceFPIS = {
				{0, 81.83, 62.11, 42.49, 25.97},
				{97.87, 0, 62.11, 42.49, 25.97},
				{97.87, 81.83, 0, 42.49, 25.97},
				{97.87, 81.83, 62.11, 0, 25.97},
				{-184.59, -140.67, -94.63, -55.87, 0}};
		
		double[][] expectedDistanceFNIS = {
				{97.87, 0, 0, 0, 0},
				{0, 81.83, 0, 0, 0},
				{0, 0, 62.11, 0, 0},
				{0, 0, 0,  42.49, 0},
				{-87.35, -59.87, -33.60, -14.52, 25.97}};
		
		for (int i = 0; i < distanceFPIS.length; i++) {
			for (int j = 0; j < distanceFPIS.length; j++) {
				assertEquals(expectedDistanceFPIS[i][j], Math.round(distanceFPIS[i][j] * 100.0) / 100.0);
				assertEquals(expectedDistanceFPIS[i][j], Math.round(distanceFPIS[i][j] * 100.0) / 100.0);
				assertEquals(expectedDistanceFPIS[i][j], Math.round(distanceFPIS[i][j] * 100.0) / 100.0);
			}
		}
		
		for (int i = 0; i < distanceFNIS.length; i++) {
			for (int j = 0; j < distanceFPIS.length; j++) {
				assertEquals(expectedDistanceFNIS[i][j], Math.round(distanceFNIS[i][j] * 100.0) / 100.0);
				assertEquals(expectedDistanceFNIS[i][j], Math.round(distanceFNIS[i][j] * 100.0) / 100.0);
				assertEquals(expectedDistanceFNIS[i][j], Math.round(distanceFNIS[i][j] * 100.0) / 100.0);
			}
		}
	}
	
	@Test
	void testCalculateValueToCriteria() {
		GoalModel goalModel = UsingEMFModel.load("testModels/FPIS_FNIS.xmi");
		FuzzyNumber[][] WFNM = FTOPSIS.calculateWFNM(goalModel);
		
		FuzzyNumber[][] FPIS_FNIS = FTOPSIS.calculateFPIS_FNIS(WFNM);
		Tuple<double[][], double[][]> distances = FTOPSIS.calculateDistanceToFPIS_FNIS(WFNM, FPIS_FNIS);
		double totalDistance = FTOPSIS.totalDistance(FPIS_FNIS);
		double[][] output = FTOPSIS.calculateValueToCriteria(distances.Item2, totalDistance);
		double[][] expectedOutput = {
				{31.54, 0, 0, 0, 0},
				{0, 26.37, 0, 0, 0},
				{0, 0, 20.02, 0, 0},
				{0, 0, 0, 13.69, 0},
				{-28.15, -19.29, -10.83, -4.68, 8.37}};
	
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				assertEquals(expectedOutput[i][j], Math.round(output[i][j] * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j], Math.round(output[i][j] * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j], Math.round(output[i][j] * 100.0) / 100.0);
			}
		}
	}
	
	@Test
	void testCalculateValueToCriteria2() {
		GoalModel goalModel = UsingEMFModel.load("testModels/FPIS_FNIS.xmi");
		
		double[][] output = FTOPSIS.calculateValueToCriteria(goalModel);
		double[][] expectedOutput = {
				{31.54, 0, 0, 0, 0},
				{0, 26.37, 0, 0, 0},
				{0, 0, 20.02, 0, 0},
				{0, 0, 0, 13.69, 0},
				{-28.15, -19.29, -10.83, -4.68, 8.37}};
	
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				assertEquals(expectedOutput[i][j], Math.round(output[i][j] * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j], Math.round(output[i][j] * 100.0) / 100.0);
				assertEquals(expectedOutput[i][j], Math.round(output[i][j] * 100.0) / 100.0);
			}
		}
	}
	
	@Test
	void testCalculateValue() {
		GoalModel goalModel = UsingEMFModel.load("test.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(goalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		double[][] temp = FTOPSIS.calculateValueToCriteria(goalModel);
		
		GoalModel output = FTOPSIS.calculateValue(goalModel).Item1;
		
		UsingEMFModel.save(output, "test3.xmi");
				
		return;
	}
	
	//Test designed to check in debug mode
	@Test
	void testHopeModel() {
		GoalModel goalModel = UsingEMFModel.load("hope.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(goalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		
		for(IntentionalElement key : ieToPosition.keySet())
			System.out.println(ieToPosition.get(key) + " - " + key.getElementName());
		
		
		double[][] herarchizedPerformanceMatrix = FTOPSIS.hierarchizePerformanceMatrix(goalModel, performanceMatrix, ieToPosition);
		
		//Fuzzy Performance Matrix
		FuzzyNumber[][] fuzzyPerformanceMatrix = FuzzyNumber.fuzzyfy(herarchizedPerformanceMatrix);
		
		//Normalized Fuzzy Performance Matrix
		FuzzyNumber[][] normalizedFuzzyPerformanceMatrix = FTOPSIS.normalizeMatrix(fuzzyPerformanceMatrix);
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tupleActorWeight = FTOPSIS.calculateActorWeight(goalModel);
		
		FuzzyNumber[] actorWeight = tupleActorWeight.Item1;
		Map<Actor, Integer> actorToPosition = tupleActorWeight.Item2;
		
		FuzzyNumber[] ieWeight = FTOPSIS.calculateIEWeight(goalModel, ieToPosition);
		
		FuzzyNumber[][] WFNM = FTOPSIS.calculateWFNM(goalModel, normalizedFuzzyPerformanceMatrix, actorWeight, ieWeight, ieToPosition, actorToPosition);
		
		FuzzyNumber[][] FPIS_FNIS = FTOPSIS.calculateFPIS_FNIS(WFNM);
		
		Tuple<double[][], double[][]> distances = FTOPSIS.calculateDistanceToFPIS_FNIS(WFNM, FPIS_FNIS);
		double totalDistance = FTOPSIS.totalDistance(FPIS_FNIS);
		double[][] valueToCriteria = FTOPSIS.calculateValueToCriteria(distances.Item2, totalDistance);
		
		GoalModel output = FTOPSIS.calculateValue(goalModel).Item1;
		
		return;
	}
	
	@Test
	void testKindleModel() {
		GoalModel goalModel = UsingEMFModel.load("testModels/Kindle_Solucion.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> tuplePropagation = Propagation.propagate(goalModel);
		
		double[][] performanceMatrix = tuplePropagation.Item1;
		Map<IntentionalElement, Integer> ieToPosition = tuplePropagation.Item2;
		
		
		for(IntentionalElement key : ieToPosition.keySet())
			System.out.println(ieToPosition.get(key) + " - " + key.getElementName());
		
		
		double[][] herarchizedPerformanceMatrix = FTOPSIS.hierarchizePerformanceMatrix(goalModel, performanceMatrix, ieToPosition);
		
		//Fuzzy Performance Matrix
		FuzzyNumber[][] fuzzyPerformanceMatrix = FuzzyNumber.fuzzyfy(herarchizedPerformanceMatrix);
		
		//Normalized Fuzzy Performance Matrix
		FuzzyNumber[][] normalizedFuzzyPerformanceMatrix = FTOPSIS.normalizeMatrix(fuzzyPerformanceMatrix);
		
		Tuple<FuzzyNumber[], Map<Actor, Integer>> tupleActorWeight = FTOPSIS.calculateActorWeight(goalModel);
		
		FuzzyNumber[] actorWeight = tupleActorWeight.Item1;
		Map<Actor, Integer> actorToPosition = tupleActorWeight.Item2;
		
		FuzzyNumber[] ieWeight = FTOPSIS.calculateIEWeight(goalModel, ieToPosition);
		
		FuzzyNumber[][] WFNM = FTOPSIS.calculateWFNM(goalModel, normalizedFuzzyPerformanceMatrix, actorWeight, ieWeight, ieToPosition, actorToPosition);
		
		FuzzyNumber[][] FPIS_FNIS = FTOPSIS.calculateFPIS_FNIS(WFNM);
		
		Tuple<double[][], double[][]> distances = FTOPSIS.calculateDistanceToFPIS_FNIS(WFNM, FPIS_FNIS);
		double totalDistance = FTOPSIS.totalDistance(FPIS_FNIS);
		double[][] valueToCriteria = FTOPSIS.calculateValueToCriteria(distances.Item2, totalDistance);
		
		valueToCriteria = FTOPSIS.MaxOrDecomposition(goalModel, valueToCriteria, Propagation.propagate(goalModel).Item2);
		
		GoalModel output = FTOPSIS.calculateValue(goalModel).Item1;
		
		return;
	}
}
