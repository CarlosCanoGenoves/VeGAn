/**
 */
package goalModel.impl;

import goalModel.EValueFrom;
import goalModel.GoalModelPackage;
import goalModel.IntentionalElement;
import goalModel.Iteration;
import goalModel.ValueFrom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value From</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.ValueFromImpl#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.impl.ValueFromImpl#getValue <em>Value</em>}</li>
 *   <li>{@link goalModel.impl.ValueFromImpl#getValueFrom <em>Value From</em>}</li>
 *   <li>{@link goalModel.impl.ValueFromImpl#getIteration <em>Iteration</em>}</li>
 *   <li>{@link goalModel.impl.ValueFromImpl#getIntentionalelement <em>Intentionalelement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueFromImpl extends MinimalEObjectImpl.Container implements ValueFrom {
	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)GoalModelPackage.Literals.VALUE_FROM__NAME).getSettingDelegate();

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final double VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected double value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueFrom() <em>Value From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueFrom()
	 * @generated
	 * @ordered
	 */
	protected static final EValueFrom VALUE_FROM_EDEFAULT = EValueFrom.LOCAL;

	/**
	 * The cached value of the '{@link #getValueFrom() <em>Value From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueFrom()
	 * @generated
	 * @ordered
	 */
	protected EValueFrom valueFrom = VALUE_FROM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIntentionalelement() <em>Intentionalelement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentionalelement()
	 * @generated
	 * @ordered
	 */
	protected IntentionalElement intentionalelement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueFromImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.VALUE_FROM;
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
	public double getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(double newValue) {
		double oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.VALUE_FROM__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EValueFrom getValueFrom() {
		return valueFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueFrom(EValueFrom newValueFrom) {
		EValueFrom oldValueFrom = valueFrom;
		valueFrom = newValueFrom == null ? VALUE_FROM_EDEFAULT : newValueFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.VALUE_FROM__VALUE_FROM, oldValueFrom, valueFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iteration getIteration() {
		if (eContainerFeatureID() != GoalModelPackage.VALUE_FROM__ITERATION) return null;
		return (Iteration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIteration(Iteration newIteration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIteration, GoalModelPackage.VALUE_FROM__ITERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIteration(Iteration newIteration) {
		if (newIteration != eInternalContainer() || (eContainerFeatureID() != GoalModelPackage.VALUE_FROM__ITERATION && newIteration != null)) {
			if (EcoreUtil.isAncestor(this, newIteration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIteration != null)
				msgs = ((InternalEObject)newIteration).eInverseAdd(this, GoalModelPackage.ITERATION__VALUEFROM, Iteration.class, msgs);
			msgs = basicSetIteration(newIteration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.VALUE_FROM__ITERATION, newIteration, newIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntentionalElement getIntentionalelement() {
		if (intentionalelement != null && intentionalelement.eIsProxy()) {
			InternalEObject oldIntentionalelement = (InternalEObject)intentionalelement;
			intentionalelement = (IntentionalElement)eResolveProxy(oldIntentionalelement);
			if (intentionalelement != oldIntentionalelement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GoalModelPackage.VALUE_FROM__INTENTIONALELEMENT, oldIntentionalelement, intentionalelement));
			}
		}
		return intentionalelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionalElement basicGetIntentionalelement() {
		return intentionalelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntentionalelement(IntentionalElement newIntentionalelement) {
		IntentionalElement oldIntentionalelement = intentionalelement;
		intentionalelement = newIntentionalelement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.VALUE_FROM__INTENTIONALELEMENT, oldIntentionalelement, intentionalelement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GoalModelPackage.VALUE_FROM__ITERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIteration((Iteration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GoalModelPackage.VALUE_FROM__ITERATION:
				return basicSetIteration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GoalModelPackage.VALUE_FROM__ITERATION:
				return eInternalContainer().eInverseRemove(this, GoalModelPackage.ITERATION__VALUEFROM, Iteration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GoalModelPackage.VALUE_FROM__NAME:
				return getName();
			case GoalModelPackage.VALUE_FROM__VALUE:
				return getValue();
			case GoalModelPackage.VALUE_FROM__VALUE_FROM:
				return getValueFrom();
			case GoalModelPackage.VALUE_FROM__ITERATION:
				return getIteration();
			case GoalModelPackage.VALUE_FROM__INTENTIONALELEMENT:
				if (resolve) return getIntentionalelement();
				return basicGetIntentionalelement();
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
			case GoalModelPackage.VALUE_FROM__NAME:
				setName((String)newValue);
				return;
			case GoalModelPackage.VALUE_FROM__VALUE:
				setValue((Double)newValue);
				return;
			case GoalModelPackage.VALUE_FROM__VALUE_FROM:
				setValueFrom((EValueFrom)newValue);
				return;
			case GoalModelPackage.VALUE_FROM__ITERATION:
				setIteration((Iteration)newValue);
				return;
			case GoalModelPackage.VALUE_FROM__INTENTIONALELEMENT:
				setIntentionalelement((IntentionalElement)newValue);
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
			case GoalModelPackage.VALUE_FROM__NAME:
				NAME__ESETTING_DELEGATE.dynamicUnset(this, null, 0);
				return;
			case GoalModelPackage.VALUE_FROM__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case GoalModelPackage.VALUE_FROM__VALUE_FROM:
				setValueFrom(VALUE_FROM_EDEFAULT);
				return;
			case GoalModelPackage.VALUE_FROM__ITERATION:
				setIteration((Iteration)null);
				return;
			case GoalModelPackage.VALUE_FROM__INTENTIONALELEMENT:
				setIntentionalelement((IntentionalElement)null);
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
			case GoalModelPackage.VALUE_FROM__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case GoalModelPackage.VALUE_FROM__VALUE:
				return value != VALUE_EDEFAULT;
			case GoalModelPackage.VALUE_FROM__VALUE_FROM:
				return valueFrom != VALUE_FROM_EDEFAULT;
			case GoalModelPackage.VALUE_FROM__ITERATION:
				return getIteration() != null;
			case GoalModelPackage.VALUE_FROM__INTENTIONALELEMENT:
				return intentionalelement != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(", valueFrom: ");
		result.append(valueFrom);
		result.append(')');
		return result.toString();
	}

} //ValueFromImpl
