/**
 */
package goalModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decomposition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.Decomposition#getDecompositionType <em>Decomposition Type</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getDecomposition()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sameActor'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot sameActor='self.trgs-&gt;forAll(actor = self.src.actor)'"
 * @generated
 */
public interface Decomposition extends Link {
	/**
	 * Returns the value of the '<em><b>Decomposition Type</b></em>' attribute.
	 * The default value is <code>"AND"</code>.
	 * The literals are from the enumeration {@link goalModel.EDecomposition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decomposition Type</em>' attribute.
	 * @see goalModel.EDecomposition
	 * @see #setDecompositionType(EDecomposition)
	 * @see goalModel.GoalModelPackage#getDecomposition_DecompositionType()
	 * @model default="AND"
	 * @generated
	 */
	EDecomposition getDecompositionType();

	/**
	 * Sets the value of the '{@link goalModel.Decomposition#getDecompositionType <em>Decomposition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decomposition Type</em>' attribute.
	 * @see goalModel.EDecomposition
	 * @see #getDecompositionType()
	 * @generated
	 */
	void setDecompositionType(EDecomposition value);

} // Decomposition
