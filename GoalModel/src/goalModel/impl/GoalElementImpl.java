/**
 */
package goalModel.impl;

import goalModel.EConfidence;
import goalModel.EEvaluation;
import goalModel.EImportance;
import goalModel.GoalElement;
import goalModel.GoalModelPackage;
import goalModel.Iteration;

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
 *   <li>{@link goalModel.impl.GoalElementImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getImportance <em>Importance</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getLocalValue <em>Local Value</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getIterations <em>Iterations</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getGlobalValue <em>Global Value</em>}</li>
 *   <li>{@link goalModel.impl.GoalElementImpl#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GoalElementImpl extends MinimalEObjectImpl.Container implements GoalElement {
	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)GoalModelPackage.Literals.GOAL_ELEMENT__NAME).getSettingDelegate();

	/**
	 * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected String elementName = ELEMENT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportance() <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportance()
	 * @generated
	 * @ordered
	 */
	protected static final EImportance IMPORTANCE_EDEFAULT = EImportance.NOT_DEFINED;

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
	protected static final EConfidence CONFIDENCE_EDEFAULT = EConfidence.NOT_DEFINED;

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
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected EList<Iteration> iterations;

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
	 * The default value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluation()
	 * @generated
	 * @ordered
	 */
	protected static final EEvaluation EVALUATION_EDEFAULT = EEvaluation.NOT_DEFINED;

	/**
	 * The cached value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluation()
	 * @generated
	 * @ordered
	 */
	protected EEvaluation evaluation = EVALUATION_EDEFAULT;

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
	public String getElementName() {
		return elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElementName(String newElementName) {
		String oldElementName = elementName;
		elementName = newElementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__ELEMENT_NAME, oldElementName, elementName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__LOCAL_VALUE, oldLocalValue, localValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__GLOBAL_VALUE, oldGlobalValue, globalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEvaluation getEvaluation() {
		return evaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEvaluation(EEvaluation newEvaluation) {
		EEvaluation oldEvaluation = evaluation;
		evaluation = newEvaluation == null ? EVALUATION_EDEFAULT : newEvaluation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.GOAL_ELEMENT__EVALUATION, oldEvaluation, evaluation));
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
			case GoalModelPackage.GOAL_ELEMENT__ELEMENT_NAME:
				return getElementName();
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				return getImportance();
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				return getConfidence();
			case GoalModelPackage.GOAL_ELEMENT__LOCAL_VALUE:
				return getLocalValue();
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				return getIterations();
			case GoalModelPackage.GOAL_ELEMENT__GLOBAL_VALUE:
				return getGlobalValue();
			case GoalModelPackage.GOAL_ELEMENT__EVALUATION:
				return getEvaluation();
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
			case GoalModelPackage.GOAL_ELEMENT__ELEMENT_NAME:
				setElementName((String)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				setImportance((EImportance)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				setConfidence((EConfidence)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__LOCAL_VALUE:
				setLocalValue((Double)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				getIterations().clear();
				getIterations().addAll((Collection<? extends Iteration>)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__GLOBAL_VALUE:
				setGlobalValue((Double)newValue);
				return;
			case GoalModelPackage.GOAL_ELEMENT__EVALUATION:
				setEvaluation((EEvaluation)newValue);
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
				NAME__ESETTING_DELEGATE.dynamicUnset(this, null, 0);
				return;
			case GoalModelPackage.GOAL_ELEMENT__ELEMENT_NAME:
				setElementName(ELEMENT_NAME_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				setImportance(IMPORTANCE_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				setConfidence(CONFIDENCE_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__LOCAL_VALUE:
				setLocalValue(LOCAL_VALUE_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				getIterations().clear();
				return;
			case GoalModelPackage.GOAL_ELEMENT__GLOBAL_VALUE:
				setGlobalValue(GLOBAL_VALUE_EDEFAULT);
				return;
			case GoalModelPackage.GOAL_ELEMENT__EVALUATION:
				setEvaluation(EVALUATION_EDEFAULT);
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
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case GoalModelPackage.GOAL_ELEMENT__ELEMENT_NAME:
				return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
			case GoalModelPackage.GOAL_ELEMENT__IMPORTANCE:
				return importance != IMPORTANCE_EDEFAULT;
			case GoalModelPackage.GOAL_ELEMENT__CONFIDENCE:
				return confidence != CONFIDENCE_EDEFAULT;
			case GoalModelPackage.GOAL_ELEMENT__LOCAL_VALUE:
				return localValue != LOCAL_VALUE_EDEFAULT;
			case GoalModelPackage.GOAL_ELEMENT__ITERATIONS:
				return iterations != null && !iterations.isEmpty();
			case GoalModelPackage.GOAL_ELEMENT__GLOBAL_VALUE:
				return globalValue != GLOBAL_VALUE_EDEFAULT;
			case GoalModelPackage.GOAL_ELEMENT__EVALUATION:
				return evaluation != EVALUATION_EDEFAULT;
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
		result.append(" (elementName: ");
		result.append(elementName);
		result.append(", importance: ");
		result.append(importance);
		result.append(", confidence: ");
		result.append(confidence);
		result.append(", localValue: ");
		result.append(localValue);
		result.append(", globalValue: ");
		result.append(globalValue);
		result.append(", evaluation: ");
		result.append(evaluation);
		result.append(')');
		return result.toString();
	}

} //GoalElementImpl
