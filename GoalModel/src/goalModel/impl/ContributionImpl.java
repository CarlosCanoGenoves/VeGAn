/**
 */
package goalModel.impl;

import goalModel.Contribution;
import goalModel.EContribution;
import goalModel.GoalModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.ContributionImpl#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.impl.ContributionImpl#getContributionType <em>Contribution Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContributionImpl extends LinkImpl implements Contribution {
	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)GoalModelPackage.Literals.CONTRIBUTION__NAME).getSettingDelegate();

	/**
	 * The default value of the '{@link #getContributionType() <em>Contribution Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributionType()
	 * @generated
	 * @ordered
	 */
	protected static final EContribution CONTRIBUTION_TYPE_EDEFAULT = EContribution.P0;

	/**
	 * The cached value of the '{@link #getContributionType() <em>Contribution Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributionType()
	 * @generated
	 * @ordered
	 */
	protected EContribution contributionType = CONTRIBUTION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.CONTRIBUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String)NAME__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		NAME__ESETTING_DELEGATE.dynamicSet(this, null, 0, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EContribution getContributionType() {
		return contributionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContributionType(EContribution newContributionType) {
		EContribution oldContributionType = contributionType;
		contributionType = newContributionType == null ? CONTRIBUTION_TYPE_EDEFAULT : newContributionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.CONTRIBUTION__CONTRIBUTION_TYPE, oldContributionType, contributionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GoalModelPackage.CONTRIBUTION__NAME:
				return getName();
			case GoalModelPackage.CONTRIBUTION__CONTRIBUTION_TYPE:
				return getContributionType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GoalModelPackage.CONTRIBUTION__NAME:
				setName((String)newValue);
				return;
			case GoalModelPackage.CONTRIBUTION__CONTRIBUTION_TYPE:
				setContributionType((EContribution)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GoalModelPackage.CONTRIBUTION__NAME:
				NAME__ESETTING_DELEGATE.dynamicUnset(this, null, 0);
				return;
			case GoalModelPackage.CONTRIBUTION__CONTRIBUTION_TYPE:
				setContributionType(CONTRIBUTION_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GoalModelPackage.CONTRIBUTION__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case GoalModelPackage.CONTRIBUTION__CONTRIBUTION_TYPE:
				return contributionType != CONTRIBUTION_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (contributionType: ");
		result.append(contributionType);
		result.append(')');
		return result.toString();
	}

} //ContributionImpl
