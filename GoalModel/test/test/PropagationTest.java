package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import VEGAN.*;
import goalModel.*;

class PropagationTest {

	@Test
	void testPropagationOfContributions() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/contribution.xmi");
		
		//La estructura es A -> B -> C -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 50, -25, -12.5},	//A
				{0, Double.MAX_VALUE, -50, -25},		//B
				{0, 0, Double.MAX_VALUE, 50},			//C
				{0, 0, 0, Double.MAX_VALUE}	};		//D
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		
		double[][] output = p.Item1;
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testPropagationOfDependencies() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/dependency.xmi");
		
		//La estructura es A -D- B -D- C -D- D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 0},			//A
				{Double.MAX_VALUE, Double.MAX_VALUE, 0, 0},			//B
				{Double.MAX_VALUE, Double.MAX_VALUE,Double.MAX_VALUE, 0},			//C
				{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE} };	//D
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		
		double[][] output = p.Item1;
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testPropagationOfDecompositionPadre_Hijo() 
	{
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/decompositionPH.xmi");
		
		//La estructura es A&BC & A -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 50},		//A
				{0, Double.MAX_VALUE, 0, 50},		//B
				{0, 0, Double.MAX_VALUE, 50},		//C
				{0, 0, 0, Double.MAX_VALUE} };		//D
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		
		double[][] output = p.Item1;
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testPropagationOfDecompositionHijo_Padre() 
	{
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/decompositionHP.xmi");
		
		//La estructura es A&BC & B -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 50},		//A
				{0, Double.MAX_VALUE, 0, 50},		//B
				{0, 0, Double.MAX_VALUE, 0},		//C
				{0, 0, 0, Double.MAX_VALUE} };		//D
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		
		double[][] output = p.Item1;
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testPropagationLimites() 
	{
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/full.xmi");
		
		//La estructura es:
		//A Contribuye a C
		//C Contribuye a B
		//C se descompone en E y F
		//D Contribuye a E
		//F Contribuye a G
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 25, 50, 0, 0, 0, 25},	//A
				{0, Double.MAX_VALUE, 0, 0, 0, 0, 0},		//B
				{0, 50, Double.MAX_VALUE, 0, 0, 0, 50},		//C
				{0, 25, 0, Double.MAX_VALUE, 50, 0, 0},		//D
				{0, 50, 0, 0, Double.MAX_VALUE, 0, 0},		//E
				{0, 50, 0, 0, 0, Double.MAX_VALUE, 50},		//F
				{0, 0, 0, 0, 0, 0, Double.MAX_VALUE}};		//G
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel);
		
		double[][] output = p.Item1;
		
		assertArrayEquals(expectedOutput, output);
	}
	
	//The importance of this test is the console output, it is to check if it is propagated in the right order
	@Test
	void testGoalModel() 
	{
		GoalModel myLoadedGoalModel = UsingEMFModel.load("test.xmi");
		
		Tuple<double[][], Map<IntentionalElement, Integer>> p = Propagation.propagate(myLoadedGoalModel, true);
		
		return;
	}
}
