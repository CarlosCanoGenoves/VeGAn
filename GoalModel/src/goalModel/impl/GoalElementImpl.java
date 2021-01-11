/**
 */
package goalModel.impl;

import goalModel.EConfidence;
import goalModel.EImportance;
import goalModel.GoalElement;
import goalModel.GoalModelPackage;
import goalModel.Iteration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.GoalElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getIterations <em>Iterations</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GoalElementImpl extends MinimalEObjectImpl.Container implements GoalElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportance() <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportance()
	 * @generated
	 * @ordered
	 */
	protected static final EImportance IMPORTANCE_EDEFAULT = EImportance.VERY_HIGH;

	/**
	 * The cached value of the '{@link #getImportance() <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportance()
	 * @generated
	 * @ordered
	 */
	protected EImportance importance = IMPORTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfidence() <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidence()
	 * @generated
	 * @ordered
	 */
	protected static final EConfidence CONFIDENCE_EDEFAULT = EConfidence.CONFIDENT;

	/**
	 * The cached value of the '{@link #getConfidence() <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidence()
	 * @generated
	 * @ordered
	 */
	protected EConfidence confidence = CONFIDENCE_EDEFAULT;

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
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected EList<Iteration> iterations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.GOAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImportance getImportance() {
		return importance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImportance(EImportance newImportance) {
		EImportance oldImportance = importance;
		importance = newImportance == null ? IMPORTANCE_EDEFAULT : newImportance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__IMPORTANCE, oldImportance, importance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EConfidence getConfidence() {
		return confidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConfidence(EConfidence newConfidence) {
		EConfidence oldConfidence = confidence;
		confidence = newConfidence == null ? CONFIDENCE_EDEFAULT : newConfidence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__CONFIDENCE, oldConfidence, confidence));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Iteration> getIterations() {
		if (iterations == null) {
			iterations = new EObjectContainmentWithInverseEList<Iteration>(Iteration.class, this, GoalModelPackage.GOAL_ELEMENT__ITERATIONS, GoalModelPackage.ITERATION__ELEMENT);
		}
		return iterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIterations()).basicAdd(otherEnd, msgs);
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
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				return ((InternalEList<?>)getIterations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GoalModelPackage.GOAL_ELEMENT__NAME:
				return getName();
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				return getImportance();
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				return getConfidence();
			case GoalModelPackage.GOAL_ELEMENT__VALUE:
				return getValue();
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				return getIterations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GoalModelPackage.GOAL_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				setImportance((EImportance)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				setConfidence((EConfidence)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__VALUE:
				setValue((Double)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				getIterations().clear();
				getIterations().addAll((Collection<? extends Iteration>)newValue);
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
			case GoalModelPackage.GOAL_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				setImportance(IMPORTANCE_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				setConfidence(CONFIDENCE_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				getIterations().clear();
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
			case GoalModelPackage.GOAL_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				return importance != IMPORTANCE_EDEFAULT;
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				return confidence != CONFIDENCE_EDEFAULT;
			case GoalModelPackage.GOAL_ELEMENT__VALUE:
				return value != VALUE_EDEFAULT;
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				return iterations != null && !iterations.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", importance: ");
		result.append(importance);
		result.append(", confidence: ");
		result.append(confidence);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //GoalElementImpl
