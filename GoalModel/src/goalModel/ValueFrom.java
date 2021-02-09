/**
 */
package goalModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value From</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.ValueFrom#getValue <em>Value</em>}</li>
 *   <li>{@link goalModel.ValueFrom#getValueFrom <em>Value From</em>}</li>
 *   <li>{@link goalModel.ValueFrom#getIteration <em>Iteration</em>}</li>
 *   <li>{@link goalModel.ValueFrom#getIntentionalelement <em>Intentionalelement</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getValueFrom()
 * @model
 * @generated
 */
public interface ValueFrom extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see goalModel.GoalModelPackage#getValueFrom_Value()
	 * @model
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link goalModel.ValueFrom#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * Returns the value of the '<em><b>Value From</b></em>' attribute.
	 * The literals are from the enumeration {@link goalModel.EValueFrom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value From</em>' attribute.
	 * @see goalModel.EValueFrom
	 * @see #setValueFrom(EValueFrom)
	 * @see goalModel.GoalModelPackage#getValueFrom_ValueFrom()
	 * @model
	 * @generated
	 */
	EValueFrom getValueFrom();

	/**
	 * Sets the value of the '{@link goalModel.ValueFrom#getValueFrom <em>Value From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value From</em>' attribute.
	 * @see goalModel.EValueFrom
	 * @see #getValueFrom()
	 * @generated
	 */
	void setValueFrom(EValueFrom value);

	/**
	 * Returns the value of the '<em><b>Iteration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link goalModel.Iteration#getValuefrom <em>Valuefrom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration</em>' container reference.
	 * @see #setIteration(Iteration)
	 * @see goalModel.GoalModelPackage#getValueFrom_Iteration()
	 * @see goalModel.Iteration#getValuefrom
	 * @model opposite="valuefrom" required="true" transient="false"
	 * @generated
	 */
	Iteration getIteration();

	/**
	 * Sets the value of the '{@link goalModel.ValueFrom#getIteration <em>Iteration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration</em>' container reference.
	 * @see #getIteration()
	 * @generated
	 */
	void setIteration(Iteration value);

	/**
	 * Returns the value of the '<em><b>Intentionalelement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intentionalelement</em>' reference.
	 * @see #setIntentionalelement(IntentionalElement)
	 * @see goalModel.GoalModelPackage#getValueFrom_Intentionalelement()
	 * @model required="true"
	 * @generated
	 */
	IntentionalElement getIntentionalelement();

	/**
	 * Sets the value of the '{@link goalModel.ValueFrom#getIntentionalelement <em>Intentionalelement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intentionalelement</em>' reference.
	 * @see #getIntentionalelement()
	 * @generated
	 */
	void setIntentionalelement(IntentionalElement value);

} // ValueFrom
