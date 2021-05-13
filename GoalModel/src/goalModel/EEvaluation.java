/**
 */
package goalModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EEvaluation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see goalModel.GoalModelPackage#getEEvaluation()
 * @model
 * @generated
 */
public enum EEvaluation implements Enumerator {
	/**
	 * The '<em><b>Strongly Agree</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_AGREE_VALUE
	 * @generated
	 * @ordered
	 */
	STRONGLY_AGREE(0, "Strongly_Agree", "Strongly_Agree"),

	/**
	 * The '<em><b>Agree</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGREE_VALUE
	 * @generated
	 * @ordered
	 */
	AGREE(1, "Agree", "Agree"),

	/**
	 * The '<em><b>Neutral</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEUTRAL_VALUE
	 * @generated
	 * @ordered
	 */
	NEUTRAL(2, "Neutral", "Neutral"),

	/**
	 * The '<em><b>Disagree</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISAGREE_VALUE
	 * @generated
	 * @ordered
	 */
	DISAGREE(3, "Disagree", "Disagree"),

	/**
	 * The '<em><b>Strongly Disagree</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_DISAGREE_VALUE
	 * @generated
	 * @ordered
	 */
	STRONGLY_DISAGREE(4, "Strongly_Disagree", "Strongly_Disagree"),

	/**
	 * The '<em><b>Not Defined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_DEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_DEFINED(5, "Not_Defined", "Not_Defined");

	/**
	 * The '<em><b>Strongly Agree</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_AGREE
	 * @model name="Strongly_Agree"
	 * @generated
	 * @ordered
	 */
	public static final int STRONGLY_AGREE_VALUE = 0;

	/**
	 * The '<em><b>Agree</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGREE
	 * @model name="Agree"
	 * @generated
	 * @ordered
	 */
	public static final int AGREE_VALUE = 1;

	/**
	 * The '<em><b>Neutral</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEUTRAL
	 * @model name="Neutral"
	 * @generated
	 * @ordered
	 */
	public static final int NEUTRAL_VALUE = 2;

	/**
	 * The '<em><b>Disagree</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISAGREE
	 * @model name="Disagree"
	 * @generated
	 * @ordered
	 */
	public static final int DISAGREE_VALUE = 3;

	/**
	 * The '<em><b>Strongly Disagree</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_DISAGREE
	 * @model name="Strongly_Disagree"
	 * @generated
	 * @ordered
	 */
	public static final int STRONGLY_DISAGREE_VALUE = 4;

	/**
	 * The '<em><b>Not Defined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_DEFINED
	 * @model name="Not_Defined"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_DEFINED_VALUE = 5;

	/**
	 * An array of all the '<em><b>EEvaluation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EEvaluation[] VALUES_ARRAY =
		new EEvaluation[] {
			STRONGLY_AGREE,
			AGREE,
			NEUTRAL,
			DISAGREE,
			STRONGLY_DISAGREE,
			NOT_DEFINED,
		};

	/**
	 * A public read-only list of all the '<em><b>EEvaluation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EEvaluation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EEvaluation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EEvaluation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EEvaluation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EEvaluation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EEvaluation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EEvaluation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EEvaluation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EEvaluation get(int value) {
		switch (value) {
			case STRONGLY_AGREE_VALUE: return STRONGLY_AGREE;
			case AGREE_VALUE: return AGREE;
			case NEUTRAL_VALUE: return NEUTRAL;
			case DISAGREE_VALUE: return DISAGREE;
			case STRONGLY_DISAGREE_VALUE: return STRONGLY_DISAGREE;
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
	private EEvaluation(int value, String name, String literal) {
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
	
} //EEvaluation
