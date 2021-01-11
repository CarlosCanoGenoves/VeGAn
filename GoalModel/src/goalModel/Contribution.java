/**
 */
package goalModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link goalModel.Contribution#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.Contribution#getContributionType <em>Contribution Type</em>}</li>
 * </ul>
 *
 * @see goalModel.GoalModelPackage#getContribution()
 * @model
 * @generated
 */
public interface Contribution extends Link {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see goalModel.GoalModelPackage#getContribution_Name()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='src.name+\' to \'+trgs-&gt;first().name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link goalModel.Contribution#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Contribution Type</b></em>' attribute.
	 * The default value is <code>"p0"</code>.
	 * The literals are from the enumeration {@link goalModel.EContribution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contribution Type</em>' attribute.
	 * @see goalModel.EContribution
	 * @see #setContributionType(EContribution)
	 * @see goalModel.GoalModelPackage#getContribution_ContributionType()
	 * @model default="p0"
	 * @generated
	 */
	EContribution getContributionType();

	/**
	 * Sets the value of the '{@link goalModel.Contribution#getContributionType <em>Contribution Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contribution Type</em>' attribute.
	 * @see goalModel.EContribution
	 * @see #getContributionType()
	 * @generated
	 */
	void setContributionType(EContribution value);

} // Contribution
