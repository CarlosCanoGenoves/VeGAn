/**
 */
package goalModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.Actor#getGoalmodel <em>Goalmodel</em>}</li>
 *   <li>{@link goalModel.Actor#getIntentionalelements <em>Intentionalelements</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getActor()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='The_name_of_the_intentional_element_must_be_unique'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot The_name_of_the_intentional_element_must_be_unique='self.intentionalelements-&gt;isUnique(name)'"
 * @generated
 */
public interface Actor extends GoalElement {
	/**
	 * Returns the value of the '<em><b>Goalmodel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link goalModel.GoalModel#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goalmodel</em>' container reference.
	 * @see #setGoalmodel(GoalModel)
	 * @see goalModel.GoalModelPackage#getActor_Goalmodel()
	 * @see goalModel.GoalModel#getActors
	 * @model opposite="actors" required="true" transient="false"
	 * @generated
	 */
	GoalModel getGoalmodel();

	/**
	 * Sets the value of the '{@link goalModel.Actor#getGoalmodel <em>Goalmodel</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goalmodel</em>' container reference.
	 * @see #getGoalmodel()
	 * @generated
	 */
	void setGoalmodel(GoalModel value);

	/**
	 * Returns the value of the '<em><b>Intentionalelements</b></em>' containment reference list.
	 * The list contents are of type {@link goalModel.IntentionalElement}.
	 * It is bidirectional and its opposite is '{@link goalModel.IntentionalElement#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intentionalelements</em>' containment reference list.
	 * @see goalModel.GoalModelPackage#getActor_Intentionalelements()
	 * @see goalModel.IntentionalElement#getActor
	 * @model opposite="actor" containment="true"
	 * @generated
	 */
	EList<IntentionalElement> getIntentionalelements();

} // Actor
