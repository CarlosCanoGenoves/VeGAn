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
		
		double[][] otuput = Propagation.propagate(myGoalModel, true);
		
		assertArrayEquals(expectedOutput, otuput);
	}
}
