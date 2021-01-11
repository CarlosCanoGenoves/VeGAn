package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import VEGAN.FuzzyNumber;

import java.util.concurrent.ThreadLocalRandom;	//Random Numbers


class FuzzyNumberTest {

	@Test
	void testAsignarTodosLosValores() {
		double n1,n2,n3;
		FuzzyNumber fn;		
		
		for(int i = 0;i<100;i++)
		{
			n1 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n2 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n3 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			
			fn = new FuzzyNumber(n1,n2,n3);
			
			assertEquals(fn.n1, n1);
			assertEquals(fn.n2, n2);
			assertEquals(fn.n3, n3);
		}
	}

	@Test
	void testFuzzificarNumero() {
		//					MIN				-VH		-VH	-H	 -M	  -L   -VL  ?  VL  L   M   H   VH   VH   MAX
		double[] input = {Double.MIN_VALUE, -125, -100, -75, -50, -25, -15, 0, 15, 25, 50, 75, 100, 125, Double.MAX_VALUE};
		//										MIN								-VH								-VH								-H	 						-M	  						 -L   							-VL  						0  						VL  						L   					M   						H   						VH   						VH   						MAX
		FuzzyNumber[] expectedOutput = {new FuzzyNumber(-11, -11, -10), new FuzzyNumber(-11, -10, -8), new FuzzyNumber(-11, -10, -8), new FuzzyNumber(-10, -8, -6), new FuzzyNumber(-8, -6, -4), new FuzzyNumber(-6, -4, -2), new FuzzyNumber(-4, -2, -1), new FuzzyNumber(0, 0, 0), new FuzzyNumber(1, 2, 4), new FuzzyNumber(2, 4, 6), new FuzzyNumber(4, 6, 8), new FuzzyNumber(6, 8, 10), new FuzzyNumber(8, 10, 11), new FuzzyNumber(8, 10, 11), new FuzzyNumber(10, 11, 11)};
		
		if(input.length !=  expectedOutput.length)
			fail("Test NOT WELL DESIGNED");
		
		for(int i=0;i<input.length;i++)
		{
			FuzzyNumber fn = new FuzzyNumber(input[i]);
						
			assertEquals(fn.n1, expectedOutput[i].n1);
			assertEquals(fn.n2, expectedOutput[i].n2);
			assertEquals(fn.n3, expectedOutput[i].n3);
		}
	}

	@Test
	void testSaturacion() {
		double[] intputNumber = {-150,  -110,  -101,  -105,  150,  110,  101,  105};
		double[] intputMinMax = {-150,  -110,  -110,  -110,  150,  110,  110,  110};
		//												-150 & -150					-110 & -110						-101 & -110					-105 & -110 								150 & 150  					110 & 110  						101 & 110 						105 & 110
		FuzzyNumber[] expectedOutput = {new FuzzyNumber(-11, -11, -10),new FuzzyNumber(-11, -11, -10),new FuzzyNumber(-11, -10.1, -10),new FuzzyNumber(-11, -10.5, -10), new FuzzyNumber(10, 11, 11),new FuzzyNumber(10, 11, 11),new FuzzyNumber(10, 10.1, 11),new FuzzyNumber(10, 10.5, 11)};
		
		if(intputNumber.length !=  intputMinMax.length || intputNumber.length != expectedOutput.length)
			fail("Test NOT WELL DESIGNED");
		
		for(int i=0;i<intputNumber.length;i++)
		{
			FuzzyNumber fn = new FuzzyNumber(intputNumber[i], intputMinMax[i]);
						
			assertEquals(fn.n1, expectedOutput[i].n1);
			assertEquals(fn.n2, expectedOutput[i].n2);
			assertEquals(fn.n3, expectedOutput[i].n3);
		}
	}
	
	@Test
	void testPriorizacion() {
		fail("Not yet implemented");
	}
	
	@Test
	void testEquals() {
		double n1,n2,n3;
		FuzzyNumber fn1, fn2;		
		
		for(int i = 0;i<100;i++)
		{
			n1 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n2 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n3 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			
			fn1 = new FuzzyNumber(n1,n2,n3);
			fn2 = new FuzzyNumber(n1,n2,n3);
			
			assertEquals(fn1.n1, fn2.n1);
			assertEquals(fn1.n2, fn2.n2);
			assertEquals(fn1.n3, fn2.n3);
		}
		
		double n4,n5,n6;
		for(int i = 0;i<100;i++)
		{
			n1 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n2 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n3 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n4 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n5 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			n6 = ThreadLocalRandom.current().nextDouble(-100, 100 + 1);
			
			fn1 = new FuzzyNumber(n1,n2,n3);
			fn2 = new FuzzyNumber(n4,n5,n6);
			
			if(n1!=n4)
				assertNotEquals(fn1.n1, fn2.n1);
			if(n2!=n5)
				assertNotEquals(fn1.n2, fn2.n2);
			if(n3!=n6)
				assertNotEquals(fn1.n3, fn2.n3);
		}
	}

}
