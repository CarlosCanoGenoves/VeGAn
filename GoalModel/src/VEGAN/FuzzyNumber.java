package VEGAN;

import goalModel.EImportance;
import goalModel.EConfidence;

public class FuzzyNumber {
	public double n1, n2, n3;

	/**
	 * Generar el numero fuzzy con n1. n2, n3
	 */
	public FuzzyNumber(double n1, double n2, double n3) {
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	/**
	 * Generar numero fuzzy dado un numero
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
	 * Generar el numero fuzzy Saturando
	 * 
	 * @param n      debe ser >100 o <-100
	 * @param minmax debe ser >100 o <-100, tener (+ o -) igual que n y ser MAYOR o
	 *               MENOR
	 */
	public FuzzyNumber(double n, double minmax) {
		boolean positivo = n > 0;

		if (n == minmax) {
			if (positivo) {
				n1 = 10;
				n2 = 11;
				n3 = 11;
			} else {
				n1 = -11;
				n2 = -11;
				n3 = -10;
			}

			return;
		}

		if (positivo) {
			n1 = 10;
			n2 = 10 + (n - 100) / (minmax - 100);
			n3 = 11;
		} else {
			n1 = -11;
			n2 = -10 - ((n + 100) / (minmax + 100));
			n3 = -10;
		}
	}

	/**
	 * Gemerar numero fuzzy a partir de la importancia y la certeza
	 */
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FuzzyNumber)
			return ((FuzzyNumber) obj).n1 == n1 && ((FuzzyNumber) obj).n2 == n2 && ((FuzzyNumber) obj).n3 == n3;

		return false;
	}
}
