/**
 */
package goalModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.Link#getSrc <em>Src</em>}</li>
 *   <li>{@link goalModel.Link#getTrgs <em>Trgs</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getLink()
 * @model abstract="true"
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>Src</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link goalModel.IntentionalElement#getSrcLinks <em>Src Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' container reference.
	 * @see #setSrc(IntentionalElement)
	 * @see goalModel.GoalModelPackage#getLink_Src()
	 * @see goalModel.IntentionalElement#getSrcLinks
	 * @model opposite="srcLinks" required="true" transient="false"
	 * @generated
	 */
	IntentionalElement getSrc();

	/**
	 * Sets the value of the '{@link goalModel.Link#getSrc <em>Src</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' container reference.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(IntentionalElement value);

	/**
	 * Returns the value of the '<em><b>Trgs</b></em>' reference list.
	 * The list contents are of type {@link goalModel.IntentionalElement}.
	 * It is bidirectional and its opposite is '{@link goalModel.IntentionalElement#getTrgLinks <em>Trg Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trgs</em>' reference list.
	 * @see goalModel.GoalModelPackage#getLink_Trgs()
	 * @see goalModel.IntentionalElement#getTrgLinks
	 * @model opposite="trgLinks" required="true"
	 * @generated
	 */
	EList<IntentionalElement> getTrgs();

} // Link
