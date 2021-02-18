/**
 */
package goalModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EConfidence</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see goalModel.GoalModelPackage#getEConfidence()
 * @model
 * @generated
 */
public enum EConfidence implements Enumerator {
	/**
	 * The '<em><b>Possibly More</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSSIBLY_MORE_VALUE
	 * @generated
	 * @ordered
	 */
	POSSIBLY_MORE(0, "Possibly_More", "Possibly_More"),

	/**
	 * The '<em><b>Confident</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONFIDENT_VALUE
	 * @generated
	 * @ordered
	 */
	CONFIDENT(1, "Confident", "Confident"),

	/**
	 * The '<em><b>Possibly Less</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSSIBLY_LESS_VALUE
	 * @generated
	 * @ordered
	 */
	POSSIBLY_LESS(2, "Possibly_Less", "Possibly_Less"), /**
	 * The '<em><b>Not Defined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_DEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_DEFINED(3, "Not_Defined", "Not_Defined");

	/**
	 * The '<em><b>Possibly More</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSSIBLY_MORE
	 * @model name="Possibly_More"
	 * @generated
	 * @ordered
	 */
	public static final int POSSIBLY_MORE_VALUE = 0;

	/**
	 * The '<em><b>Confident</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONFIDENT
	 * @model name="Confident"
	 * @generated
	 * @ordered
	 */
	public static final int CONFIDENT_VALUE = 1;

	/**
	 * The '<em><b>Possibly Less</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSSIBLY_LESS
	 * @model name="Possibly_Less"
	 * @generated
	 * @ordered
	 */
	public static final int POSSIBLY_LESS_VALUE = 2;

	/**
	 * The '<em><b>Not Defined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_DEFINED
	 * @model name="Not_Defined"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_DEFINED_VALUE = 3;

	/**
	 * An array of all the '<em><b>EConfidence</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EConfidence[] VALUES_ARRAY =
		new EConfidence[] {
			POSSIBLY_MORE,
			CONFIDENT,
			POSSIBLY_LESS,
			NOT_DEFINED,
		};

	/**
	 * A public read-only list of all the '<em><b>EConfidence</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EConfidence> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EConfidence</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EConfidence get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EConfidence result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EConfidence</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EConfidence getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EConfidence result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EConfidence</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EConfidence get(int value) {
		switch (value) {
			case POSSIBLY_MORE_VALUE: return POSSIBLY_MORE;
			case CONFIDENT_VALUE: return CONFIDENT;
			case POSSIBLY_LESS_VALUE: return POSSIBLY_LESS;
			case NOT_DEFINED_VALUE: return NOT_DEFINED;
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
	private EConfidence(int value, String name, String literal) {
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
	
} //EConfidence
