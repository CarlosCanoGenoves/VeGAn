/**
 */
package goalModel.impl;

import goalModel.EConfidence;
import goalModel.EImportance;
import goalModel.GoalElement;
import goalModel.GoalModelPackage;
import goalModel.Iteration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.IterationImpl#getIteration <em>Iteration</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getValue <em>Value</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterationImpl extends MinimalEObjectImpl.Container implements Iteration {
	/**
	 * The default value of the '{@link #getIteration() <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteration()
	 * @generated
	 * @ordered
	 */
	protected static final int ITERATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIteration() <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteration()
	 * @generated
	 * @ordered
	 */
	protected int iteration = ITERATION_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.ITERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIteration() {
		return iteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIteration(int newIteration) {
		int oldIteration = iteration;
		iteration = newIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ITERATION__ITERATION, oldIteration, iteration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ITERATION__IMPORTANCE, oldImportance, importance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ITERATION__CONFIDENCE, oldConfidence, confidence));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ITERATION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GoalElement getElement() {
		if (eContainerFeatureID() != GoalModelPackage.ITERATION__ELEMENT) return null;
		return (GoalElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(GoalElement newElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElement, GoalModelPackage.ITERATION__ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement(GoalElement newElement) {
		if (newElement != eInternalContainer() || (eContainerFeatureID() != GoalModelPackage.ITERATION__ELEMENT && newElement != null)) {
			if (EcoreUtil.isAncestor(this, newElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, GoalModelPackage.GOAL_ELEMENT__ITERATIONS, GoalElement.class, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ITERATION__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GoalModelPackage.ITERATION__ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetElement((GoalElement)otherEnd, msgs);
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
			case GoalModelPackage.ITERATION__ELEMENT:
				return basicSetElement(null, msgs);
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
			case GoalModelPackage.ITERATION__ELEMENT:
				return eInternalContainer().eInverseRemove(this, GoalModelPackage.GOAL_ELEMENT__ITERATIONS, GoalElement.class, msgs);
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
			case GoalModelPackage.ITERATION__ITERATION:
				return getIteration();
			case GoalModelPackage.ITERATION__IMPORTANCE:
				return getImportance();
			case GoalModelPackage.ITERATION__CONFIDENCE:
				return getConfidence();
			case GoalModelPackage.ITERATION__VALUE:
				return getValue();
			case GoalModelPackage.ITERATION__ELEMENT:
				return getElement();
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
			case GoalModelPackage.ITERATION__ITERATION:
				setIteration((Integer)newValue);
				return;
			case GoalModelPackage.ITERATION__IMPORTANCE:
				setImportance((EImportance)newValue);
				return;
			case GoalModelPackage.ITERATION__CONFIDENCE:
				setConfidence((EConfidence)newValue);
				return;
			case GoalModelPackage.ITERATION__VALUE:
				setValue((Double)newValue);
				return;
			case GoalModelPackage.ITERATION__ELEMENT:
				setElement((GoalElement)newValue);
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
			case GoalModelPackage.ITERATION__ITERATION:
				setIteration(ITERATION_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__IMPORTANCE:
				setImportance(IMPORTANCE_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__CONFIDENCE:
				setConfidence(CONFIDENCE_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__ELEMENT:
				setElement((GoalElement)null);
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
			case GoalModelPackage.ITERATION__ITERATION:
				return iteration != ITERATION_EDEFAULT;
			case GoalModelPackage.ITERATION__IMPORTANCE:
				return importance != IMPORTANCE_EDEFAULT;
			case GoalModelPackage.ITERATION__CONFIDENCE:
				return confidence != CONFIDENCE_EDEFAULT;
			case GoalModelPackage.ITERATION__VALUE:
				return value != VALUE_EDEFAULT;
			case GoalModelPackage.ITERATION__ELEMENT:
				return getElement() != null;
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
		result.append(" (Iteration: ");
		result.append(iteration);
		result.append(", Importance: ");
		result.append(importance);
		result.append(", Confidence: ");
		result.append(confidence);
		result.append(", Value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //IterationImpl
