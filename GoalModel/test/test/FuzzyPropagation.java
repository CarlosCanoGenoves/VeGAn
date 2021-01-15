package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import VEGAN.*;
import goalModel.*;

class FuzzyPropagation {

	@Test
	void testFuzzyPropagationOfContributions() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/contribution.xmi");
		
		//La estructura es A -> B -> C -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 50, -25, -12.5},	//A
				{0, Double.MAX_VALUE, -50, -25},		//B
				{0, 0, Double.MAX_VALUE, 50},			//C
				{0, 0, 0, Double.MAX_VALUE}	};		//D
		
		double[][] output = Propagation.propagate(myLoadedGoalModel);
		
		assertArrayEquals(expectedOutput, output);
		
		FuzzyNumber[][] output2 = FuzzyNumber.fuzzyfy(output);
		FuzzyNumber[][] expectedOutput2 = {
				{new FuzzyNumber(Double.MAX_VALUE), new FuzzyNumber(50), new FuzzyNumber(-25), new FuzzyNumber(-12.5)},
				{new FuzzyNumber(0), new FuzzyNumber(Double.MAX_VALUE), new FuzzyNumber(-50), new FuzzyNumber(-25)},
				{new FuzzyNumber(0), new FuzzyNumber(0), new FuzzyNumber(Double.MAX_VALUE), new FuzzyNumber(50)},
				{new FuzzyNumber(0), new FuzzyNumber(0), new FuzzyNumber(0), new FuzzyNumber(Double.MAX_VALUE)}};
		
		if(output.length != output2.length || output2.length != expectedOutput2.length)
			fail("Incorrect output size");
		
		for(int i=0;i<expectedOutput2.length;i++)
			for(int j=0;j<expectedOutput2.length;j++)
			{
				assertEquals(expectedOutput2[i][j].n1, output2[i][j].n1);
				assertEquals(expectedOutput2[i][j].n2, output2[i][j].n2);
				assertEquals(expectedOutput2[i][j].n3, output2[i][j].n3);
			}
	}
	
	@Test
	void testFuzzyPropagationOfDependencies() {
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/dependency.xmi");
		
		//La estructura es A -D- B -D- C -D- D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 0},			//A
				{100, Double.MAX_VALUE, 0, 0},			//B
				{100, 100,Double.MAX_VALUE, 0},			//C
				{100, 100, 100, Double.MAX_VALUE} };	//D
		
		double[][] output = Propagation.propagate(myLoadedGoalModel);
		FuzzyNumber[][] expectedOutput2 = {{}};
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void tesFuzzytPropagationOfDecompositionPadre_Hijo() 
	{		
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/decompositionPH.xmi");
		
		//La estructura es A&BC & A -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 50},		//A
				{0, Double.MAX_VALUE, 0, 50},		//B
				{0, 0, Double.MAX_VALUE, 50},		//C
				{0, 0, 0, Double.MAX_VALUE} };		//D
		
		double[][] output = Propagation.propagate(myLoadedGoalModel);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testFuzzyPropagationOfDecompositionHijo_Padre() 
	{
		GoalModel myLoadedGoalModel = UsingEMFModel.load("testModels/decompositionHP.xmi");
		
		//La estructura es A&BC & B -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 50},		//A
				{0, Double.MAX_VALUE, 0, 50},		//B
				{0, 0, Double.MAX_VALUE, 0},		//C
				{0, 0, 0, Double.MAX_VALUE} };		//D
		
		double[][] output = Propagation.propagate(myLoadedGoalModel);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void testFuzzyPropagationLimites() 
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
		
		double[][] output = Propagation.propagate(myLoadedGoalModel);
		
		assertArrayEquals(expectedOutput, output);
	}

}
