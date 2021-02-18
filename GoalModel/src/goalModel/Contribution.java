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
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='Only_one_target'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot Only_one_target='self.trgs-&gt;size() &lt;2'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='let impact : Integer = if self.contributionType = EContribution::p100 then 100 elseif self.contributionType = EContribution::p75 then 75 \n\t\t\telseif self.contributionType = EContribution::p50 then 50 elseif self.contributionType = EContribution::p25 then 25\n\t\t\telseif self.contributionType = EContribution::n25 then -25 elseif self.contributionType = EContribution::n50 then -50 \n\t\t\telseif self.contributionType = EContribution::n75 then -75 elseif self.contributionType = EContribution::n100 then -100 else 0 endif\n\t\t\tin if trgs-&gt;size() &lt;&gt; 0 then src.name + \' to \' + trgs-&gt;first().name + \' (\' + impact.toString() + \')\' else \'\' endif'"
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
