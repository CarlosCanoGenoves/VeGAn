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
 *   <li>{@link goalModel.GoalElement#getElementName <em>Element Name</em>}</li>
 *   <li>{@link goalModel.GoalElement#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.GoalElement#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.GoalElement#getLocalValue <em>Local Value</em>}</li>
 *   <li>{@link goalModel.GoalElement#getIterations <em>Iterations</em>}</li>
 *   <li>{@link goalModel.GoalElement#getGlobalValue <em>Global Value</em>}</li>
 *   <li>{@link goalModel.GoalElement#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getGoalElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='Importance_not_defined Confidence_not_defined'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot Importance_not_defined='importance &lt;&gt; EImportance::Not_Defined' Confidence_not_defined='confidence &lt;&gt; EConfidence::Not_Defined'"
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
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='let imp : String = if self.importance = EImportance::Very_High then \'Very High\' \n\t\t\telseif self.importance = EImportance::High then \'High\'\n\t\t\telseif self.importance = EImportance::Medium then \'Medium\'\n\t\t\telseif self.importance = EImportance::Low then \'Low\' \n\t\t\telseif self.importance = EImportance::Very_Low then \'Very Low\'\n\t\t\telse \'Not Defined\' endif\n\t\t\tin let conf : String = if self.confidence = EConfidence::Possibly_More then \'Possibly More\' \n\t\t\telseif self.confidence = EConfidence::Confident then \'Confident\' \n\t\t\telseif self.confidence = EConfidence::Possibly_Less then \'Possibly Less\' \n\t\t\telse \'Not Defined\' endif\n\t\t\tin elementName + \' \' + imp + \' \' + conf'"
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
	 * Returns the value of the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Name</em>' attribute.
	 * @see #setElementName(String)
	 * @see goalModel.GoalModelPackage#getGoalElement_ElementName()
	 * @model
	 * @generated
	 */
	String getElementName();

	/**
	 * Sets the value of the '{@link goalModel.GoalElement#getElementName <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Name</em>' attribute.
	 * @see #getElementName()
	 * @generated
	 */
	void setElementName(String value);

	/**
	 * Returns the value of the '<em><b>Importance</b></em>' attribute.
	 * The default value is <code>"Not_Defined"</code>.
	 * The literals are from the enumeration {@link goalModel.EImportance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Importance</em>' attribute.
	 * @see goalModel.EImportance
	 * @see #setImportance(EImportance)
	 * @see goalModel.GoalModelPackage#getGoalElement_Importance()
	 * @model default="Not_Defined"
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
	 * The default value is <code>"Not_Defined"</code>.
	 * The literals are from the enumeration {@link goalModel.EConfidence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence</em>' attribute.
	 * @see goalModel.EConfidence
	 * @see #setConfidence(EConfidence)
	 * @see goalModel.GoalModelPackage#getGoalElement_Confidence()
	 * @model default="Not_Defined"
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

	/**
	 * Returns the value of the '<em><b>Evaluation</b></em>' attribute.
	 * The default value is <code>"Not_Defined"</code>.
	 * The literals are from the enumeration {@link goalModel.EEvaluation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluation</em>' attribute.
	 * @see goalModel.EEvaluation
	 * @see #setEvaluation(EEvaluation)
	 * @see goalModel.GoalModelPackage#getGoalElement_Evaluation()
	 * @model default="Not_Defined"
	 * @generated
	 */
	EEvaluation getEvaluation();

	/**
	 * Sets the value of the '{@link goalModel.GoalElement#getEvaluation <em>Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation</em>' attribute.
	 * @see goalModel.EEvaluation
	 * @see #getEvaluation()
	 * @generated
	 */
	void setEvaluation(EEvaluation value);

} // GoalElement
