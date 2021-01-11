/**
 */
package goalModel.impl;

import goalModel.Decomposition;
import goalModel.EDecomposition;
import goalModel.GoalModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decomposition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.DecompositionImpl#getDecompositionType <em>Decomposition Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecompositionImpl extends LinkImpl implements Decomposition {
	/**
	 * The default value of the '{@link #getDecompositionType() <em>Decomposition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecompositionType()
	 * @generated
	 * @ordered
	 */
	protected static final EDecomposition DECOMPOSITION_TYPE_EDEFAULT = EDecomposition.AND;

	/**
	 * The cached value of the '{@link #getDecompositionType() <em>Decomposition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecompositionType()
	 * @generated
	 * @ordered
	 */
	protected EDecomposition decompositionType = DECOMPOSITION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecompositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.DECOMPOSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDecomposition getDecompositionType() {
		return decompositionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDecompositionType(EDecomposition newDecompositionType) {
		EDecomposition oldDecompositionType = decompositionType;
		decompositionType = newDecompositionType == null ? DECOMPOSITION_TYPE_EDEFAULT : newDecompositionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.DECOMPOSITION__DECOMPOSITION_TYPE, oldDecompositionType, decompositionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GoalModelPackage.DECOMPOSITION__DECOMPOSITION_TYPE:
				return getDecompositionType();
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
			case GoalModelPackage.DECOMPOSITION__DECOMPOSITION_TYPE:
				setDecompositionType((EDecomposition)newValue);
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
			case GoalModelPackage.DECOMPOSITION__DECOMPOSITION_TYPE:
				setDecompositionType(DECOMPOSITION_TYPE_EDEFAULT);
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
			case GoalModelPackage.DECOMPOSITION__DECOMPOSITION_TYPE:
				return decompositionType != DECOMPOSITION_TYPE_EDEFAULT;
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
		result.append(" (decompositionType: ");
		result.append(decompositionType);
		result.append(')');
		return result.toString();
	}

} //DecompositionImpl
