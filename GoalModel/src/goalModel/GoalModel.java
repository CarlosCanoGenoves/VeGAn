/**
 */
package goalModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.GoalModel#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.GoalModel#getActors <em>Actors</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getGoalModel()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='uniqueActorName'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot uniqueActorName='self.actors-&gt;isUnique(name)'"
 * @generated
 */
public interface GoalModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see goalModel.GoalModelPackage#getGoalModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link goalModel.GoalModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
	 * The list contents are of type {@link goalModel.Actor}.
	 * It is bidirectional and its opposite is '{@link goalModel.Actor#getGoalmodel <em>Goalmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' containment reference list.
	 * @see goalModel.GoalModelPackage#getGoalModel_Actors()
	 * @see goalModel.Actor#getGoalmodel
	 * @model opposite="goalmodel" containment="true"
	 * @generated
	 */
	EList<Actor> getActors();

} // GoalModel
