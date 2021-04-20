/**
 */
package goalModel;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link goalModel.Iteration#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.Iteration#getIteration <em>Iteration</em>}</li>
 *   <li>{@link goalModel.Iteration#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.Iteration#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.Iteration#getElement <em>Element</em>}</li>
 *   <li>{@link goalModel.Iteration#getGlobalValue <em>Global Value</em>}</li>
 *   <li>{@link goalModel.Iteration#getLocalValue <em>Local Value</em>}</li>
 *   <li>{@link goalModel.Iteration#getValuefrom <em>Valuefrom</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getIteration()
 * @model annotation="http://www.obeo.fr/dsl/dnc/archetype archetype='Thing'"
 * @generated
 */
public interface Iteration extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see goalModel.GoalModelPackage#getIteration_Name()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='let reducedValue : String = if globalValue &lt; 0 then (if globalValue.toString().size() &gt;5 then globalValue.toString().substring(1, 5) else globalValue.toString() endif) else (if globalValue.toString().size() &gt; 4 then globalValue.toString().substring(1, 4) else globalValue.toString() endif) endif \n\t\t\t\t\tin iteration.toString() + \'- Value: \' + reducedValue'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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

	/**
	 * Returns the value of the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Value</em>' attribute.
	 * @see #setGlobalValue(double)
	 * @see goalModel.GoalModelPackage#getIteration_GlobalValue()
	 * @model required="true"
	 * @generated
	 */
	double getGlobalValue();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getGlobalValue <em>Global Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Value</em>' attribute.
	 * @see #getGlobalValue()
	 * @generated
	 */
	void setGlobalValue(double value);

	/**
	 * Returns the value of the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Value</em>' attribute.
	 * @see #setLocalValue(double)
	 * @see goalModel.GoalModelPackage#getIteration_LocalValue()
	 * @model required="true"
	 * @generated
	 */
	double getLocalValue();

	/**
	 * Sets the value of the '{@link goalModel.Iteration#getLocalValue <em>Local Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Value</em>' attribute.
	 * @see #getLocalValue()
	 * @generated
	 */
	void setLocalValue(double value);

	/**
	 * Returns the value of the '<em><b>Valuefrom</b></em>' containment reference list.
	 * The list contents are of type {@link goalModel.ValueFrom}.
	 * It is bidirectional and its opposite is '{@link goalModel.ValueFrom#getIteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valuefrom</em>' containment reference list.
	 * @see goalModel.GoalModelPackage#getIteration_Valuefrom()
	 * @see goalModel.ValueFrom#getIteration
	 * @model opposite="iteration" containment="true"
	 * @generated
	 */
	EList<ValueFrom> getValuefrom();

} // Iteration
