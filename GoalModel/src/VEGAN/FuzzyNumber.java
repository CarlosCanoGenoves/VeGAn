package VEGAN;

import goalModel.EImportance;
import goalModel.EConfidence;

public class FuzzyNumber {
	public double n1, n2, n3;

	/**
	 * Fuzzy Number (n1, n2, n3)
	 */
	public FuzzyNumber(double n1, double n2, double n3) {
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	/**
	 * Fuzzifies n -> (n1, n2, n3)
	 */
	public FuzzyNumber(double n) {
		if (n == 0) {
			n1 = 0;
			n2 = 0;
			n3 = 0;
			return;
		}
		
		if (n == Double.MAX_VALUE) {
			n1 = 10;
			n2 = 11;
			n3 = 11;
			return;
		} else if (n == Double.MIN_VALUE) {
			n1 = -11;
			n2 = -11;
			n3 = -10;
			return;
		}

		if (n > 0) {
			if (n < 20) // +VERY LOW
			{
				n1 = 1;
				n2 = 2;
				n3 = 4;
			} else if (n < 40) // +LOW
			{
				n1 = 2;
				n2 = 4;
				n3 = 6;
			} else if (n < 60) // +MEDIUM
			{
				n1 = 4;
				n2 = 6;
				n3 = 8;
			} else if (n < 80) // +HIGH
			{
				n1 = 6;
				n2 = 8;
				n3 = 10;
			} else // >=80 //+VERY HIGH
			{
				n1 = 8;
				n2 = 10;
				n3 = 11;
			}
		} else {
			if (n > -20) // -VERY LOW
			{
				n1 = -4;
				n2 = -2;
				n3 = -1;
			} else if (n > -40) // -LOW
			{
				n1 = -6;
				n2 = -4;
				n3 = -2;
			} else if (n > -60) // -MEDIUM
			{
				n1 = -8;
				n2 = -6;
				n3 = -4;
			} else if (n > -80) // -HIGH
			{
				n1 = -10;
				n2 = -8;
				n3 = -6;
			} else // <=80 //-VERY HIGH
			{
				n1 = -11;
				n2 = -10;
				n3 = -8;
			}
		}
	}


	/**
	 * Fuzzifies and saturates n
	 * 
	 */
	public static FuzzyNumber fuzzyfy(double n, double min, double max) {

		if(n == Double.MAX_VALUE || n == Double.MIN_VALUE)
			return new FuzzyNumber(n);

		if(n>=-100 & n<=100)
			return new FuzzyNumber(n);
		
		if (n == max) 
			return new FuzzyNumber(10, 11, 11);
		if(n==min)
			return new FuzzyNumber(-11, -11, -10);
			
		if (n > 0) {
			double n2 = 10 + (n - 100) / (max - 100);

			return new FuzzyNumber(10, n2, 11);
		} else {
			double n2 = -10 - ((n + 100) / (min + 100));
			
			return new FuzzyNumber(-11, n2, -10);
		}
	}

	/**
	 * Fuzzifies & saturates a matrix
	 */
	public static FuzzyNumber[][] fuzzyfy(double[][] impactMatrix)
	{
		FuzzyNumber[][] fuzzifiedImpactMatrix = new FuzzyNumber[impactMatrix.length][impactMatrix.length];
		
		for(int i=0;i<impactMatrix.length;i++)
		{
			double max = 100;
			double min = -100;
			
			//Indentify the min and max of each column (criterion)
			for(int j=0;j<impactMatrix.length;j++)
			{
				if(impactMatrix[j][i] < min && impactMatrix[j][i] != Double.MIN_VALUE)
					min = impactMatrix[j][i];
				
				if(impactMatrix[j][i] > max && impactMatrix[j][i] != Double.MAX_VALUE)
					max = impactMatrix[j][i];
			}
			
			for(int j=0;j<impactMatrix.length;j++)
			{
				fuzzifiedImpactMatrix[j][i] = fuzzyfy(impactMatrix[j][i], min, max);
			}
		}
		
		return fuzzifiedImpactMatrix;
	}
	
	public FuzzyNumber(EImportance importance, EConfidence confidence) {
		if (importance == EImportance.VERY_HIGH) {
			if (confidence == EConfidence.POSSIBLY_MORE) {
				n1 = 9.67;
				n2 = 10.25;
				n3 = 11;
			} else if (confidence == EConfidence.CONFIDENT) {
				n1 = 9.52;
				n2 = 9.67;
				n3 = 9.92;
			} else if (confidence == EConfidence.POSSIBLY_LESS) {
				n1 = 8;
				n2 = 9.31;
				n3 = 9.67;
			}
		} else if (importance == EImportance.HIGH) {
			if (confidence == EConfidence.POSSIBLY_MORE) {
				n1 = 8;
				n2 = 9.13;
				n3 = 10;
			} else if (confidence == EConfidence.CONFIDENT) {
				n1 = 7.7;
				n2 = 8;
				n3 = 8.52;
			} else if (confidence == EConfidence.POSSIBLY_LESS) {
				n1 = 6;
				n2 = 7.32;
				n3 = 8;
			}
		} else if (importance == EImportance.MEDIUM) {
			if (confidence == EConfidence.POSSIBLY_MORE) {
				n1 = 6;
				n2 = 7.27;
				n3 = 8;
			} else if (confidence == EConfidence.CONFIDENT) {
				n1 = 5.6;
				n2 = 6;
				n3 = 6.66;
			} else if (confidence == EConfidence.POSSIBLY_LESS) {
				n1 = 4;
				n2 = 5.11;
				n3 = 6;
			}
		} else if (importance == EImportance.LOW) {
			if (confidence == EConfidence.POSSIBLY_MORE) {
				n1 = 4;
				n2 = 5.44;
				n3 = 6;
			} else if (confidence == EConfidence.CONFIDENT) {
				n1 = 3.37;
				n2 = 4;
				n3 = 4.86;
			} else if (confidence == EConfidence.POSSIBLY_LESS) {
				n1 = 2;
				n2 = 2.72;
				n3 = 4;
			}
		} else if (importance == EImportance.VERY_LOW) {
			if (confidence == EConfidence.POSSIBLY_MORE) {
				n1 = 2.33;
				n2 = 3.62;
				n3 = 4;
			} else if (confidence == EConfidence.CONFIDENT) {
				n1 = 1.78;
				n2 = 2.33;
				n3 = 3.16;
			} else if (confidence == EConfidence.POSSIBLY_LESS) {
				n1 = 1;
				n2 = 1.37;
				n3 = 2.33;
			}
		}

	}
	
	public static double euclideanDistance(FuzzyNumber fn1, FuzzyNumber fn2)
	{
		//Vector distance: sqrt( ((a1-a2)^2 + (b1-b2)^2 (c1-c2)^2)/3 )
		return Math.sqrt(((Math.pow((fn1.n1-fn2.n1), 2) + Math.pow((fn1.n2-fn2.n2), 2) + Math.pow((fn1.n3-fn2.n3), 2))/3.0));
	}

	public double euclideanDistance(FuzzyNumber fn2)
	{
		return euclideanDistance(this, fn2);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FuzzyNumber)
			return ((FuzzyNumber) obj).n1 == n1 && ((FuzzyNumber) obj).n2 == n2 && ((FuzzyNumber) obj).n3 == n3;

		return false;
	}
}
