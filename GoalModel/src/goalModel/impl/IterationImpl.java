/**
 */
package goalModel.impl;

import goalModel.EConfidence;
import goalModel.EImportance;
import goalModel.GoalElement;
import goalModel.GoalModelPackage;
import goalModel.Iteration;

import goalModel.ValueFrom;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.IterationImpl#getName <em>Name</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getIteration <em>Iteration</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getElement <em>Element</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getGlobalValue <em>Global Value</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getLocalValue <em>Local Value</em>}</li>
 *   <li>{@link goalModel.impl.IterationImpl#getValuefrom <em>Valuefrom</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterationImpl extends MinimalEObjectImpl.Container implements Iteration {
	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)GoalModelPackage.Literals.ITERATION__NAME).getSettingDelegate();

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
	 * The default value of the '{@link #getGlobalValue() <em>Global Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalValue()
	 * @generated
	 * @ordered
	 */
	protected static final double GLOBAL_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGlobalValue() <em>Global Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalValue()
	 * @generated
	 * @ordered
	 */
	protected double globalValue = GLOBAL_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalValue() <em>Local Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalValue()
	 * @generated
	 * @ordered
	 */
	protected static final double LOCAL_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLocalValue() <em>Local Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalValue()
	 * @generated
	 * @ordered
	 */
	protected double localValue = LOCAL_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValuefrom() <em>Valuefrom</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValuefrom()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueFrom> valuefrom;

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
	public double getGlobalValue() {
		return globalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGlobalValue(double newGlobalValue) {
		double oldGlobalValue = globalValue;
		globalValue = newGlobalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ITERATION__GLOBAL_VALUE, oldGlobalValue, globalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLocalValue() {
		return localValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocalValue(double newLocalValue) {
		double oldLocalValue = localValue;
		localValue = newLocalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ITERATION__LOCAL_VALUE, oldLocalValue, localValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueFrom> getValuefrom() {
		if (valuefrom == null) {
			valuefrom = new EObjectContainmentWithInverseEList<ValueFrom>(ValueFrom.class, this, GoalModelPackage.ITERATION__VALUEFROM, GoalModelPackage.VALUE_FROM__ITERATION);
		}
		return valuefrom;
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
			case GoalModelPackage.ITERATION__ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetElement((GoalElement)otherEnd, msgs);
			case GoalModelPackage.ITERATION__VALUEFROM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getValuefrom()).basicAdd(otherEnd, msgs);
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
			case GoalModelPackage.ITERATION__VALUEFROM:
				return ((InternalEList<?>)getValuefrom()).basicRemove(otherEnd, msgs);
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
			case GoalModelPackage.ITERATION__NAME:
				return getName();
			case GoalModelPackage.ITERATION__ITERATION:
				return getIteration();
			case GoalModelPackage.ITERATION__IMPORTANCE:
				return getImportance();
			case GoalModelPackage.ITERATION__CONFIDENCE:
				return getConfidence();
			case GoalModelPackage.ITERATION__ELEMENT:
				return getElement();
			case GoalModelPackage.ITERATION__GLOBAL_VALUE:
				return getGlobalValue();
			case GoalModelPackage.ITERATION__LOCAL_VALUE:
				return getLocalValue();
			case GoalModelPackage.ITERATION__VALUEFROM:
				return getValuefrom();
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
			case GoalModelPackage.ITERATION__NAME:
				setName((String)newValue);
				return;
			case GoalModelPackage.ITERATION__ITERATION:
				setIteration((Integer)newValue);
				return;
			case GoalModelPackage.ITERATION__IMPORTANCE:
				setImportance((EImportance)newValue);
				return;
			case GoalModelPackage.ITERATION__CONFIDENCE:
				setConfidence((EConfidence)newValue);
				return;
			case GoalModelPackage.ITERATION__ELEMENT:
				setElement((GoalElement)newValue);
				return;
			case GoalModelPackage.ITERATION__GLOBAL_VALUE:
				setGlobalValue((Double)newValue);
				return;
			case GoalModelPackage.ITERATION__LOCAL_VALUE:
				setLocalValue((Double)newValue);
				return;
			case GoalModelPackage.ITERATION__VALUEFROM:
				getValuefrom().clear();
				getValuefrom().addAll((Collection<? extends ValueFrom>)newValue);
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
			case GoalModelPackage.ITERATION__NAME:
				NAME__ESETTING_DELEGATE.dynamicUnset(this, null, 0);
				return;
			case GoalModelPackage.ITERATION__ITERATION:
				setIteration(ITERATION_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__IMPORTANCE:
				setImportance(IMPORTANCE_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__CONFIDENCE:
				setConfidence(CONFIDENCE_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__ELEMENT:
				setElement((GoalElement)null);
				return;
			case GoalModelPackage.ITERATION__GLOBAL_VALUE:
				setGlobalValue(GLOBAL_VALUE_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__LOCAL_VALUE:
				setLocalValue(LOCAL_VALUE_EDEFAULT);
				return;
			case GoalModelPackage.ITERATION__VALUEFROM:
				getValuefrom().clear();
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
			case GoalModelPackage.ITERATION__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case GoalModelPackage.ITERATION__ITERATION:
				return iteration != ITERATION_EDEFAULT;
			case GoalModelPackage.ITERATION__IMPORTANCE:
				return importance != IMPORTANCE_EDEFAULT;
			case GoalModelPackage.ITERATION__CONFIDENCE:
				return confidence != CONFIDENCE_EDEFAULT;
			case GoalModelPackage.ITERATION__ELEMENT:
				return getElement() != null;
			case GoalModelPackage.ITERATION__GLOBAL_VALUE:
				return globalValue != GLOBAL_VALUE_EDEFAULT;
			case GoalModelPackage.ITERATION__LOCAL_VALUE:
				return localValue != LOCAL_VALUE_EDEFAULT;
			case GoalModelPackage.ITERATION__VALUEFROM:
				return valuefrom != null && !valuefrom.isEmpty();
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
		result.append(" (iteration: ");
		result.append(iteration);
		result.append(", importance: ");
		result.append(importance);
		result.append(", confidence: ");
		result.append(confidence);
		result.append(", globalValue: ");
		result.append(globalValue);
		result.append(", localValue: ");
		result.append(localValue);
		result.append(')');
		return result.toString();
	}

} //IterationImpl
