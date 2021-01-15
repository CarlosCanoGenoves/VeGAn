package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import VEGAN.*;
import goalModel.*;

class FuzzyPropagation {

	@Test
	void test() {
		GoalModel goalModel = UsingEMFModel.load("testModels/contribution.xmi");
		
		double[][] result = Propagation.propagate(goalModel);
		
		
	}

}
