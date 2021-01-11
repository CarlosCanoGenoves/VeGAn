/**
 */
package goalModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.Iteration#getIteration <em>Iteration</em>}</li>
 *   <li>{@link goalModel.Iteration#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.Iteration#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.Iteration#getValue <em>Value</em>}</li>
 *   <li>{@link goalModel.Iteration#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getIteration()
 * @model annotation="http://www.obeo.fr/dsl/dnc/archetype archetype='Thing'"
 * @generated
 */
public interface Iteration extends EObject {
	/**
	 * Returns the value of the '<em><b>Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration</em>' attribute.
	 * @see #setIteration(int)
	 * @see goalModel.GoalModelPackage#getIteration_Iteration()
	 * @model required="true"
	 * @generated
	 */
	int getIteration();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getIteration <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration</em>' attribute.
	 * @see #getIteration()
	 * @generated
	 */
	void setIteration(int value);

	/**
	 * Returns the value of the '<em><b>Importance</b></em>' attribute.
	 * The literals are from the enumeration {@link goalModel.EImportance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Importance</em>' attribute.
	 * @see goalModel.EImportance
	 * @see #setImportance(EImportance)
	 * @see goalModel.GoalModelPackage#getIteration_Importance()
	 * @model
	 * @generated
	 */
	EImportance getImportance();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getImportance <em>Importance</em>}' attribute.
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
	 * @see goalModel.GoalModelPackage#getIteration_Confidence()
	 * @model default="Confident"
	 * @generated
	 */
	EConfidence getConfidence();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getConfidence <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence</em>' attribute.
	 * @see goalModel.EConfidence
	 * @see #getConfidence()
	 * @generated
	 */
	void setConfidence(EConfidence value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see goalModel.GoalModelPackage#getIteration_Value()
	 * @model required="true"
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link goalModel.GoalElement#getIterations <em>Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' container reference.
	 * @see #setElement(GoalElement)
	 * @see goalModel.GoalModelPackage#getIteration_Element()
	 * @see goalModel.GoalElement#getIterations
	 * @model opposite="iterations" transient="false"
	 * @generated
	 */
	GoalElement getElement();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getElement <em>Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' container reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(GoalElement value);

} // Iteration
