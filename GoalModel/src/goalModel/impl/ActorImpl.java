/**
 */
package goalModel.impl;

import goalModel.Actor;
import goalModel.GoalModel;
import goalModel.GoalModelPackage;
import goalModel.IntentionalElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.ActorImpl#getGoalmodel <em>Goalmodel</em>}</li>
 *   <li>{@link goalModel.impl.ActorImpl#getIntentionalelements <em>Intentionalelements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorImpl extends GoalElementImpl implements Actor {
	/**
	 * The cached value of the '{@link #getIntentionalelements() <em>Intentionalelements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentionalelements()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentionalElement> intentionalelements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GoalModel getGoalmodel() {
		if (eContainerFeatureID() != GoalModelPackage.ACTOR__GOALMODEL) return null;
		return (GoalModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGoalmodel(GoalModel newGoalmodel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGoalmodel, GoalModelPackage.ACTOR__GOALMODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGoalmodel(GoalModel newGoalmodel) {
		if (newGoalmodel != eInternalContainer() || (eContainerFeatureID() != GoalModelPackage.ACTOR__GOALMODEL && newGoalmodel != null)) {
			if (EcoreUtil.isAncestor(this, newGoalmodel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGoalmodel != null)
				msgs = ((InternalEObject)newGoalmodel).eInverseAdd(this, GoalModelPackage.GOAL_MODEL__ACTORS, GoalModel.class, msgs);
			msgs = basicSetGoalmodel(newGoalmodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.ACTOR__GOALMODEL, newGoalmodel, newGoalmodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntentionalElement> getIntentionalelements() {
		if (intentionalelements == null) {
			intentionalelements = new EObjectContainmentWithInverseEList<IntentionalElement>(IntentionalElement.class, this, GoalModelPackage.ACTOR__INTENTIONALELEMENTS, GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR);
		}
		return intentionalelements;
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
			case GoalModelPackage.ACTOR__GOALMODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGoalmodel((GoalModel)otherEnd, msgs);
			case GoalModelPackage.ACTOR__INTENTIONALELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntentionalelements()).basicAdd(otherEnd, msgs);
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
			case GoalModelPackage.ACTOR__GOALMODEL:
				return basicSetGoalmodel(null, msgs);
			case GoalModelPackage.ACTOR__INTENTIONALELEMENTS:
				return ((InternalEList<?>)getIntentionalelements()).basicRemove(otherEnd, msgs);
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
			case GoalModelPackage.ACTOR__GOALMODEL:
				return eInternalContainer().eInverseRemove(this, GoalModelPackage.GOAL_MODEL__ACTORS, GoalModel.class, msgs);
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
			case GoalModelPackage.ACTOR__GOALMODEL:
				return getGoalmodel();
			case GoalModelPackage.ACTOR__INTENTIONALELEMENTS:
				return getIntentionalelements();
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
			case GoalModelPackage.ACTOR__GOALMODEL:
				setGoalmodel((GoalModel)newValue);
				return;
			case GoalModelPackage.ACTOR__INTENTIONALELEMENTS:
				getIntentionalelements().clear();
				getIntentionalelements().addAll((Collection<? extends IntentionalElement>)newValue);
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
			case GoalModelPackage.ACTOR__GOALMODEL:
				setGoalmodel((GoalModel)null);
				return;
			case GoalModelPackage.ACTOR__INTENTIONALELEMENTS:
				getIntentionalelements().clear();
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
			case GoalModelPackage.ACTOR__GOALMODEL:
				return getGoalmodel() != null;
			case GoalModelPackage.ACTOR__INTENTIONALELEMENTS:
				return intentionalelements != null && !intentionalelements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActorImpl
