/**
 */
package goalModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.GoalElement#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.GoalElement#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.GoalElement#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.GoalElement#getLocalValue <em>Local Value</em>}</li>
 *   <li>{@link goalModel.GoalElement#getIterations <em>Iterations</em>}</li>
 *   <li>{@link goalModel.GoalElement#getGlobalValue <em>Global Value</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getGoalElement()
 * @model abstract="true"
 * @generated
 */
public interface GoalElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see goalModel.GoalModelPackage#getGoalElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link goalModel.GoalElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Importance</b></em>' attribute.
	 * The literals are from the enumeration {@link goalModel.EImportance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Importance</em>' attribute.
	 * @see goalModel.EImportance
	 * @see #setImportance(EImportance)
	 * @see goalModel.GoalModelPackage#getGoalElement_Importance()
	 * @model
	 * @generated
	 */
	EImportance getImportance();

	/**
	 * Sets the value of the '{@link goalModel.GoalElement#getImportance <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Importance</em>' attribute.
	 * @see goalModel.EImportance
	 * @see #getImportance()
	 * @generated
	 */
	void setImportance(EImportance value);

	/**
	 * Returns the value of the '<em><b>Confidence</b></em>' attribute.
	 * The default value is <code>"Confident"</code>.
	 * The literals are from the enumeration {@link goalModel.EConfidence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence</em>' attribute.
	 * @see goalModel.EConfidence
	 * @see #setConfidence(EConfidence)
	 * @see goalModel.GoalModelPackage#getGoalElement_Confidence()
	 * @model default="Confident"
	 * @generated
	 */
	EConfidence getConfidence();

	/**
	 * Sets the value of the '{@link goalModel.GoalElement#getConfidence <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence</em>' attribute.
	 * @see goalModel.EConfidence
	 * @see #getConfidence()
	 * @generated
	 */
	void setConfidence(EConfidence value);

	/**
	 * Returns the value of the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Value</em>' attribute.
	 * @see #setLocalValue(double)
	 * @see goalModel.GoalModelPackage#getGoalElement_LocalValue()
	 * @model required="true"
	 * @generated
	 */
	double getLocalValue();

	/**
	 * Sets the value of the '{@link goalModel.GoalElement#getLocalValue <em>Local Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Value</em>' attribute.
	 * @see #getLocalValue()
	 * @generated
	 */
	void setLocalValue(double value);

	/**
	 * Returns the value of the '<em><b>Iterations</b></em>' containment reference list.
	 * The list contents are of type {@link goalModel.Iteration}.
	 * It is bidirectional and its opposite is '{@link goalModel.Iteration#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations</em>' containment reference list.
	 * @see goalModel.GoalModelPackage#getGoalElement_Iterations()
	 * @see goalModel.Iteration#getElement
	 * @model opposite="element" containment="true"
	 * @generated
	 */
	EList<Iteration> getIterations();

	/**
	 * Returns the value of the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Value</em>' attribute.
	 * @see #setGlobalValue(double)
	 * @see goalModel.GoalModelPackage#getGoalElement_GlobalValue()
	 * @model required="true"
	 * @generated
	 */
	double getGlobalValue();

	/**
	 * Sets the value of the '{@link goalModel.GoalElement#getGlobalValue <em>Global Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Value</em>' attribute.
	 * @see #getGlobalValue()
	 * @generated
	 */
	void setGlobalValue(double value);

} // GoalElement
