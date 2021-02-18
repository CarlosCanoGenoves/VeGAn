/**
 */
package goalModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.Dependency#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getDependency()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='Only_one_target'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot Only_one_target='self.trgs-&gt;size() &lt;2'"
 * @generated
 */
public interface Dependency extends Link {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see goalModel.GoalModelPackage#getDependency_Name()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if trgs-&gt;size() &lt;&gt; 0 then src.name+\' to \'+trgs-&gt;first().name else \'\' endif'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link goalModel.Dependency#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Dependency
