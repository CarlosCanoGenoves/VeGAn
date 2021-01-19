package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import VEGAN.FuzzyNumber;
import goalModel.EConfidence;
import goalModel.EImportance;

import java.util.concurrent.ThreadLocalRandom; //Random Numbers

class FuzzyNumberTest {

	@Test
	void testAsignarTodosLosValores() {
		double n1, n2, n3;
		FuzzyNumber fn;

		for (int i = 0; i < 100; i++) {
			n1 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n2 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n3 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);

			fn = new FuzzyNumber(n1, n2, n3);

			assertEquals(n1, fn.n1);
			assertEquals(n2, fn.n2);
			assertEquals(n3, fn.n3);
		}
	}

	@Test
	void testFuzzificarNumero() {
		// MIN -VH -VH -H -M -L -VL 0 VL L M H VH VH MAX
		double[] input = { Double.MIN_VALUE, -125, -100, -75, -50, -25, -15, 0, 15, 25, 50, 75, 100, 125, Double.MAX_VALUE };
		
		FuzzyNumber[] expectedOutput = { new FuzzyNumber(-11, -11, -10), new FuzzyNumber(-11, -10, -8),
				new FuzzyNumber(-11, -10, -8), new FuzzyNumber(-10, -8, -6), new FuzzyNumber(-8, -6, -4),
				new FuzzyNumber(-6, -4, -2), new FuzzyNumber(-4, -2, -1),
				new FuzzyNumber(0, 0, 0),
				new FuzzyNumber(1, 2, 4), new FuzzyNumber(2, 4, 6), new FuzzyNumber(4, 6, 8), new FuzzyNumber(6, 8, 10),
				new FuzzyNumber(8, 10, 11), new FuzzyNumber(8, 10, 11), new FuzzyNumber(10, 11, 11) };

		if (input.length != expectedOutput.length)
			fail("Test NOT WELL DESIGNED");

		for (int i = 0; i < input.length; i++) {
			FuzzyNumber fn = new FuzzyNumber(input[i]);

			assertEquals(expectedOutput[i].n1, fn.n1);
			assertEquals(expectedOutput[i].n2, fn.n2);
			assertEquals(expectedOutput[i].n3, fn.n3);
		}
	}

	@Test
	void testFuzzification() {
		double[] intputNumber = { -150, -110, -101, -105, 150, 110, 101, 105 };
		double[] intputMin = { 	  -150, -110, -110, -110,    0,  0,   0,   0 };
		double[] intputMax = {       0,    0,    0,    0,  150, 110, 110, 110 };

		FuzzyNumber[] expectedOutput = { new FuzzyNumber(-11, -11, -10), new FuzzyNumber(-11, -11, -10),
				new FuzzyNumber(-11, -10.1, -10), new FuzzyNumber(-11, -10.5, -10), new FuzzyNumber(10, 11, 11),
				new FuzzyNumber(10, 11, 11), new FuzzyNumber(10, 10.1, 11), new FuzzyNumber(10, 10.5, 11) };

		if (intputNumber.length != intputMin.length || intputNumber.length != intputMax.length || intputNumber.length != expectedOutput.length)
			fail("Test NOT WELL DESIGNED");

		for (int i = 0; i < intputNumber.length; i++) {
			FuzzyNumber fn = FuzzyNumber.fuzzyfy(intputNumber[i], intputMin[i], intputMax[i]);

			assertEquals(expectedOutput[i].n1, fn.n1);
			assertEquals(expectedOutput[i].n2, fn.n2);
			assertEquals(expectedOutput[i].n3, fn.n3);
		}
		
		double[] input2 = { Double.MIN_VALUE, -125, -100, -75, -50, -25, -15, 0, 15, 25, 50, 75, 100, 125, Double.MAX_VALUE };
				
		FuzzyNumber[] expectedOutput2 = { new FuzzyNumber(-11, -11, -10), new FuzzyNumber(-11, -11, -10),
				new FuzzyNumber(-11, -10, -8), new FuzzyNumber(-10, -8, -6), new FuzzyNumber(-8, -6, -4),
				new FuzzyNumber(-6, -4, -2), new FuzzyNumber(-4, -2, -1),
				new FuzzyNumber(0, 0, 0),
				new FuzzyNumber(1, 2, 4), new FuzzyNumber(2, 4, 6), new FuzzyNumber(4, 6, 8), new FuzzyNumber(6, 8, 10),
				new FuzzyNumber(8, 10, 11), new FuzzyNumber(10, 11, 11), new FuzzyNumber(10, 11, 11) };

		if (input2.length != expectedOutput2.length)
			fail("Test NOT WELL DESIGNED");

		for (int i = 0; i < input2.length; i++) {
			FuzzyNumber fn = FuzzyNumber.fuzzyfy(input2[i], -125, 125);

			assertEquals(expectedOutput2[i].n1, fn.n1);
			assertEquals(expectedOutput2[i].n2, fn.n2);
			assertEquals(expectedOutput2[i].n3, fn.n3);
		}
	}

	@Test
	void testPriorizacion() {
		EImportance[] inputImportance = { EImportance.VERY_HIGH, EImportance.VERY_HIGH, EImportance.VERY_HIGH,
				EImportance.HIGH, EImportance.HIGH, EImportance.HIGH,
				EImportance.MEDIUM, EImportance.MEDIUM, EImportance.MEDIUM,
				EImportance.LOW, EImportance.LOW, EImportance.LOW,
				EImportance.VERY_LOW, EImportance.VERY_LOW, EImportance.VERY_LOW };
		
		EConfidence[] inputConfidence = { EConfidence.POSSIBLY_MORE, EConfidence.CONFIDENT, EConfidence.POSSIBLY_LESS,
				EConfidence.POSSIBLY_MORE, EConfidence.CONFIDENT, EConfidence.POSSIBLY_LESS,
				EConfidence.POSSIBLY_MORE, EConfidence.CONFIDENT, EConfidence.POSSIBLY_LESS, 
				EConfidence.POSSIBLY_MORE, EConfidence.CONFIDENT, EConfidence.POSSIBLY_LESS, 
				EConfidence.POSSIBLY_MORE, EConfidence.CONFIDENT, EConfidence.POSSIBLY_LESS };

		FuzzyNumber[] expectedOutput = { new FuzzyNumber(9.67, 10.25, 11), new FuzzyNumber(9.52, 9.67, 9.92),
				new FuzzyNumber(8, 9.31, 9.67), new FuzzyNumber(8, 9.13, 10), new FuzzyNumber(7.7, 8, 8.52),
				new FuzzyNumber(6, 7.32, 8), new FuzzyNumber(6, 7.27, 8), new FuzzyNumber(5.6, 6, 6.66),
				new FuzzyNumber(4, 5.11, 6), new FuzzyNumber(4, 5.44, 6), new FuzzyNumber(3.37, 4, 4.86),
				new FuzzyNumber(2, 2.72, 4), new FuzzyNumber(2.33, 3.62, 4), new FuzzyNumber(1.78, 2.33, 3.16),
				new FuzzyNumber(1, 1.37, 2.33) };

		if (inputImportance.length != inputConfidence.length || inputImportance.length != expectedOutput.length)
			fail("Test NOT WELL DESIGNED");

		for (int i = 0; i < inputImportance.length; i++) {
			FuzzyNumber fn = new FuzzyNumber(inputImportance[i], inputConfidence[i]);

			assertEquals(expectedOutput[i].n1, fn.n1);
			assertEquals(expectedOutput[i].n2, fn.n2);
			assertEquals(expectedOutput[i].n3, fn.n3);
		}
	}

	@Test
	void testEquals() {
		double n1, n2, n3;
		FuzzyNumber fn1, fn2;

		for (int i = 0; i < 100; i++) {
			n1 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n2 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n3 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);

			fn1 = new FuzzyNumber(n1, n2, n3);
			fn2 = new FuzzyNumber(n1, n2, n3);

			assertEquals(fn1.n1, fn2.n1);
			assertEquals(fn1.n2, fn2.n2);
			assertEquals(fn1.n3, fn2.n3);
		}

		double n4, n5, n6;
		for (int i = 0; i < 100; i++) {
			n1 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n2 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n3 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n4 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n5 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n6 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);

			fn1 = new FuzzyNumber(n1, n2, n3);
			fn2 = new FuzzyNumber(n4, n5, n6);

			if (n1 != n4)
				assertNotEquals(fn1.n1, fn2.n1);
			if (n2 != n5)
				assertNotEquals(fn1.n2, fn2.n2);
			if (n3 != n6)
				assertNotEquals(fn1.n3, fn2.n3);
		}
	}
	
	@Test
	void testEuclideanDistance()
	{
		assertEquals(0, FuzzyNumber.euclideanDistance(new FuzzyNumber(0), new FuzzyNumber(0)));
		assertEquals(0, FuzzyNumber.euclideanDistance(new FuzzyNumber(2, 4, 6), new FuzzyNumber(2, 4, 6)));
		assertEquals(FuzzyNumber.euclideanDistance(new FuzzyNumber(9.67, 10.25, 11), new FuzzyNumber(1, 1.37, 2.33)), FuzzyNumber.euclideanDistance(new FuzzyNumber(1, 1.37, 2.33), new FuzzyNumber(9.67, 10.25, 11)));
		
		//VH & PM + M & C
		assertEquals(4.22, Math.round(FuzzyNumber.euclideanDistance(new FuzzyNumber(9.67, 10.25, 11), new FuzzyNumber(5.6, 6, 6.66))*100)/100.0);
		
		//VL & PL + M & C
		assertEquals(4.52, Math.round(FuzzyNumber.euclideanDistance(new FuzzyNumber(1, 1.37, 2.33), new FuzzyNumber(5.6, 6, 6.66))*100)/100.0);
		
		//VL & PL + VH & PM
		assertEquals(8.74, Math.round(FuzzyNumber.euclideanDistance(new FuzzyNumber(1, 1.37, 2.33), new FuzzyNumber(9.67, 10.25, 11))*100)/100.0);
		
		//VL & PL + VL & C
		assertEquals(0.86, Math.round(FuzzyNumber.euclideanDistance(new FuzzyNumber(1, 1.37, 2.33), new FuzzyNumber(1.78, 2.33, 3.16))*100)/100.0);
		
		//VH & P; + VH & C
		assertEquals(0.71, Math.round(FuzzyNumber.euclideanDistance(new FuzzyNumber(9.67, 10.25, 11), new FuzzyNumber(9.52, 9.67, 9.92))*100)/100.0);
	}

}
