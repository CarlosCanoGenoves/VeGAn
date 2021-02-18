/**
 */
package goalModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intentional Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.IntentionalElement#getActor <em>Actor</em>}</li>
 *   <li>{@link goalModel.IntentionalElement#getSrcLinks <em>Src Links</em>}</li>
 *   <li>{@link goalModel.IntentionalElement#getTrgLinks <em>Trg Links</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getIntentionalElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='An_intentional_element_can_only_have_one_decomposition An_intentional_element_can_only_decompose_one_element'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot An_intentional_element_can_only_have_one_decomposition='self.srcLinks-&gt;select(oclIsTypeOf(Decomposition))-&gt;size() &lt; 2' An_intentional_element_can_only_decompose_one_element='self.trgLinks-&gt;select(oclIsTypeOf(Decomposition))-&gt;size() &lt; 2'"
 * @generated
 */
public interface IntentionalElement extends GoalElement {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link goalModel.Actor#getIntentionalelements <em>Intentionalelements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' container reference.
	 * @see #setActor(Actor)
	 * @see goalModel.GoalModelPackage#getIntentionalElement_Actor()
	 * @see goalModel.Actor#getIntentionalelements
	 * @model opposite="intentionalelements" required="true" transient="false"
	 * @generated
	 */
	Actor getActor();

	/**
	 * Sets the value of the '{@link goalModel.IntentionalElement#getActor <em>Actor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' container reference.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(Actor value);

	/**
	 * Returns the value of the '<em><b>Src Links</b></em>' containment reference list.
	 * The list contents are of type {@link goalModel.Link}.
	 * It is bidirectional and its opposite is '{@link goalModel.Link#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Links</em>' containment reference list.
	 * @see goalModel.GoalModelPackage#getIntentionalElement_SrcLinks()
	 * @see goalModel.Link#getSrc
	 * @model opposite="src" containment="true"
	 * @generated
	 */
	EList<Link> getSrcLinks();

	/**
	 * Returns the value of the '<em><b>Trg Links</b></em>' reference list.
	 * The list contents are of type {@link goalModel.Link}.
	 * It is bidirectional and its opposite is '{@link goalModel.Link#getTrgs <em>Trgs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trg Links</em>' reference list.
	 * @see goalModel.GoalModelPackage#getIntentionalElement_TrgLinks()
	 * @see goalModel.Link#getTrgs
	 * @model opposite="trgs"
	 * @generated
	 */
	EList<Link> getTrgLinks();

} // IntentionalElement
