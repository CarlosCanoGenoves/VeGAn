/**
 */
package goalModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EContribution</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see goalModel.GoalModelPackage#getEContribution()
 * @model
 * @generated
 */
public enum EContribution implements Enumerator {
	/**
	 * The '<em><b>P100</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P100_VALUE
	 * @generated
	 * @ordered
	 */
	P100(0, "p100", "p100"),

	/**
	 * The '<em><b>P75</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P75_VALUE
	 * @generated
	 * @ordered
	 */
	P75(1, "p75", "p75"),

	/**
	 * The '<em><b>P50</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P50_VALUE
	 * @generated
	 * @ordered
	 */
	P50(2, "p50", "p50"),

	/**
	 * The '<em><b>P25</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P25_VALUE
	 * @generated
	 * @ordered
	 */
	P25(3, "p25", "p25"),

	/**
	 * The '<em><b>P0</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P0_VALUE
	 * @generated
	 * @ordered
	 */
	P0(4, "p0", "p0"),

	/**
	 * The '<em><b>N25</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N25_VALUE
	 * @generated
	 * @ordered
	 */
	N25(5, "n25", "n25"),

	/**
	 * The '<em><b>N50</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N50_VALUE
	 * @generated
	 * @ordered
	 */
	N50(6, "n50", "n50"),

	/**
	 * The '<em><b>N75</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N75_VALUE
	 * @generated
	 * @ordered
	 */
	N75(7, "n75", "n75"),

	/**
	 * The '<em><b>N100</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N100_VALUE
	 * @generated
	 * @ordered
	 */
	N100(8, "n100", "n100");

	/**
	 * The '<em><b>P100</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P100
	 * @model name="p100"
	 * @generated
	 * @ordered
	 */
	public static final int P100_VALUE = 0;

	/**
	 * The '<em><b>P75</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P75
	 * @model name="p75"
	 * @generated
	 * @ordered
	 */
	public static final int P75_VALUE = 1;

	/**
	 * The '<em><b>P50</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P50
	 * @model name="p50"
	 * @generated
	 * @ordered
	 */
	public static final int P50_VALUE = 2;

	/**
	 * The '<em><b>P25</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P25
	 * @model name="p25"
	 * @generated
	 * @ordered
	 */
	public static final int P25_VALUE = 3;

	/**
	 * The '<em><b>P0</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #P0
	 * @model name="p0"
	 * @generated
	 * @ordered
	 */
	public static final int P0_VALUE = 4;

	/**
	 * The '<em><b>N25</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N25
	 * @model name="n25"
	 * @generated
	 * @ordered
	 */
	public static final int N25_VALUE = 5;

	/**
	 * The '<em><b>N50</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N50
	 * @model name="n50"
	 * @generated
	 * @ordered
	 */
	public static final int N50_VALUE = 6;

	/**
	 * The '<em><b>N75</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N75
	 * @model name="n75"
	 * @generated
	 * @ordered
	 */
	public static final int N75_VALUE = 7;

	/**
	 * The '<em><b>N100</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N100
	 * @model name="n100"
	 * @generated
	 * @ordered
	 */
	public static final int N100_VALUE = 8;

	/**
	 * An array of all the '<em><b>EContribution</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EContribution[] VALUES_ARRAY =
		new EContribution[] {
			P100,
			P75,
			P50,
			P25,
			P0,
			N25,
			N50,
			N75,
			N100,
		};

	/**
	 * A public read-only list of all the '<em><b>EContribution</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EContribution> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EContribution</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EContribution get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EContribution result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EContribution</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EContribution getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EContribution result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EContribution</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EContribution get(int value) {
		switch (value) {
			case P100_VALUE: return P100;
			case P75_VALUE: return P75;
			case P50_VALUE: return P50;
			case P25_VALUE: return P25;
			case P0_VALUE: return P0;
			case N25_VALUE: return N25;
			case N50_VALUE: return N50;
			case N75_VALUE: return N75;
			case N100_VALUE: return N100;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EContribution(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EContribution
