package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import VEGAN.Propagation;
import goalModel.*;

class PropagationTest {

	@Test
	void testPropagationOfContributions() {
		GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		GoalModel myGoalModel = factory.createGoalModel();
		myGoalModel.setName("TESTGoalModel1");

		Actor actor = factory.createActor();
		actor.setName("TESTActor1");
		myGoalModel.getActors().add(actor);
		
		IntentionalElement ie1 = factory.createGoal();
		ie1.setName("A");
		actor.getIntentionalelements().add(ie1);
				
		IntentionalElement ie2 = factory.createGoal();
		ie2.setName("B");
		actor.getIntentionalelements().add(ie2);
		
		IntentionalElement ie3 = factory.createGoal();
		ie3.setName("C");
		actor.getIntentionalelements().add(ie3);
		
		IntentionalElement ie4 = factory.createGoal();
		ie4.setName("D");
		actor.getIntentionalelements().add(ie4);
		
		Contribution c1 = factory.createContribution();
		c1.setSrc(ie1);
		c1.getTrgs().add(ie2);
		c1.setContributionType(EContribution.P50);
		
		Contribution c2 = factory.createContribution();
		c2.setSrc(ie2);
		c2.getTrgs().add(ie3);
		c2.setContributionType(EContribution.N50);
		
		Contribution c3 = factory.createContribution();
		c3.setSrc(ie3);
		c3.getTrgs().add(ie4);
		c3.setContributionType(EContribution.P50);
		
		//La estructura es A -> B -> C -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 50, -25, -12.5},	//A
				{0, Double.MAX_VALUE, -50, -25},		//B
				{0, 0, Double.MAX_VALUE, 50},			//C
				{0, 0, 0, Double.MAX_VALUE}	};		//D
		
		double[][] otuput = Propagation.propagate(myGoalModel);
		
		assertArrayEquals(expectedOutput, otuput);
	}
	
	@Test
	void testPropagationOfDependencies() {
		GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		GoalModel myGoalModel = factory.createGoalModel();
		myGoalModel.setName("TESTGoalModel1");

		Actor actor = factory.createActor();
		actor.setName("TESTActor1");
		myGoalModel.getActors().add(actor);
		
		IntentionalElement ie1 = factory.createGoal();
		ie1.setName("A");
		actor.getIntentionalelements().add(ie1);
				
		IntentionalElement ie2 = factory.createGoal();
		ie2.setName("B");
		actor.getIntentionalelements().add(ie2);
		
		IntentionalElement ie3 = factory.createGoal();
		ie3.setName("C");
		actor.getIntentionalelements().add(ie3);
		
		IntentionalElement ie4 = factory.createGoal();
		ie4.setName("D");
		actor.getIntentionalelements().add(ie4);
		
		Dependency d1 = factory.createDependency();
		d1.setSrc(ie1);
		d1.getTrgs().add(ie2);
		
		Dependency d2 = factory.createDependency();
		d2.setSrc(ie2);
		d2.getTrgs().add(ie3);
		
		Dependency d3 = factory.createDependency();
		d3.setSrc(ie3);
		d3.getTrgs().add(ie4);
		
		
		//La estructura es A -D- B -D- C -D- D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 0},			//A
				{100, Double.MAX_VALUE, 0, 0},			//B
				{100, 100,Double.MAX_VALUE, 0},			//C
				{100, 100, 100, Double.MAX_VALUE} };	//D
		
		double[][] otuput = Propagation.propagate(myGoalModel);
		
		assertArrayEquals(expectedOutput, otuput);
	}
	
	@Test
	void testPropagationOfDecompositionPadre_Hijo() 
	{
GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		GoalModel myGoalModel = factory.createGoalModel();
		myGoalModel.setName("TESTGoalModel1");

		Actor actor = factory.createActor();
		actor.setName("TESTActor1");
		myGoalModel.getActors().add(actor);
		
		IntentionalElement ie1 = factory.createGoal();
		ie1.setName("A");
		actor.getIntentionalelements().add(ie1);
		
		IntentionalElement ie2 = factory.createGoal();
		ie2.setName("B");
		actor.getIntentionalelements().add(ie2);
		
		IntentionalElement ie3 = factory.createGoal();
		ie3.setName("C");
		actor.getIntentionalelements().add(ie3);
		
		IntentionalElement ie4 = factory.createGoal();
		ie4.setName("D");
		actor.getIntentionalelements().add(ie4);
		
		Contribution c1 = factory.createContribution();
		c1.setSrc(ie1);
		c1.getTrgs().add(ie4);
		c1.setContributionType(EContribution.P50);
		
		Decomposition d1 = factory.createDecomposition();
		d1.setSrc(ie1);
		d1.getTrgs().add(ie2);
		d1.getTrgs().add(ie3);
		
		//La estructura es A&BC & A -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 50},		//A
				{0, Double.MAX_VALUE, 0, 50},		//B
				{0, 0, Double.MAX_VALUE, 50},		//C
				{0, 0, 0, Double.MAX_VALUE} };		//D
		
		double[][] otuput = Propagation.propagate(myGoalModel);
		
		assertArrayEquals(expectedOutput, otuput);
	}
	
	@Test
	void testPropagationOfDecompositionHijo_Padre() 
	{
		GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		GoalModel myGoalModel = factory.createGoalModel();
		myGoalModel.setName("TESTGoalModel1");

		Actor actor = factory.createActor();
		actor.setName("TESTActor1");
		myGoalModel.getActors().add(actor);
		
		IntentionalElement ie1 = factory.createGoal();
		ie1.setName("A");
		actor.getIntentionalelements().add(ie1);
		
		IntentionalElement ie2 = factory.createGoal();
		ie2.setName("B");
		actor.getIntentionalelements().add(ie2);
		
		IntentionalElement ie3 = factory.createGoal();
		ie3.setName("C");
		actor.getIntentionalelements().add(ie3);
		
		IntentionalElement ie4 = factory.createGoal();
		ie4.setName("D");
		actor.getIntentionalelements().add(ie4);
		
		Contribution c1 = factory.createContribution();
		c1.setSrc(ie2);
		c1.getTrgs().add(ie4);
		c1.setContributionType(EContribution.P50);
		
		Decomposition d1 = factory.createDecomposition();
		d1.setSrc(ie1);
		d1.getTrgs().add(ie2);
		d1.getTrgs().add(ie3);
		
		//La estructura es A&BC & B -> D
		double[][] expectedOutput = {
				{Double.MAX_VALUE, 0, 0, 50},		//A
				{0, Double.MAX_VALUE, 0, 50},		//B
				{0, 0, Double.MAX_VALUE, 0},		//C
				{0, 0, 0, Double.MAX_VALUE} };		//D
		
		double[][] otuput = Propagation.propagate(myGoalModel);
		
		assertArrayEquals(expectedOutput, otuput);
	}
	
	@Test
	void testPropagationLimites() 
	{
GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		GoalModel myGoalModel = factory.createGoalModel();
		myGoalModel.setName("TESTGoalModel1");

		Actor actor = factory.createActor();
		actor.setName("TESTActor1");
		myGoalModel.getActors().add(actor);
		
		IntentionalElement ie1 = factory.createGoal();
		ie1.setName("A");
		actor.getIntentionalelements().add(ie1);
		
		IntentionalElement ie2 = factory.createGoal();
		ie2.setName("B");
		actor.getIntentionalelements().add(ie2);
		
		IntentionalElement ie3 = factory.createGoal();
		ie3.setName("C");
		actor.getIntentionalelements().add(ie3);
		
		IntentionalElement ie4 = factory.createGoal();
		ie4.setName("D");
		actor.getIntentionalelements().add(ie4);
		
		IntentionalElement ie5 = factory.createGoal();
		ie5.setName("E");
		actor.getIntentionalelements().add(ie5);
		
		IntentionalElement ie6 = factory.createGoal();
		ie6.setName("F");
		actor.getIntentionalelements().add(ie6);
		
		IntentionalElement ie7 = factory.createGoal();
		ie7.setName("G");
		actor.getIntentionalelements().add(ie7);
		
		//C is descomposed in E, F
		Decomposition d1 = factory.createDecomposition();
		d1.setSrc(ie3);
		d1.getTrgs().add(ie5);
		d1.getTrgs().add(ie6);
		
		//A contributes to C
		Contribution c1 = factory.createContribution();
		c1.setSrc(ie1);
		c1.getTrgs().add(ie3);
		c1.setContributionType(EContribution.P50);

		//C contributes to B
		Contribution c2 = factory.createContribution();
		c2.setSrc(ie3);
		c2.getTrgs().add(ie2);
		c2.setContributionType(EContribution.P50);
		
		//D contributes to E
		Contribution c3 = factory.createContribution();
		c3.setSrc(ie4);
		c3.getTrgs().add(ie5);
		c3.setContributionType(EContribution.P50);
		
		//F contributes to G
		Contribution c4 = factory.createContribution();
		c4.setSrc(ie6);
		c4.getTrgs().add(ie7);
		c4.setContributionType(EContribution.P50);
		
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
		
		double[][] otuput = Propagation.propagate(myGoalModel);
		
		assertArrayEquals(expectedOutput, otuput);
	}
}
