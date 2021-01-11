/**
 */
package goalModel.impl;

import goalModel.GoalModel;
import goalModel.GoalModelPackage;
import goalModel.IntentionalElement;
import goalModel.Link;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.LinkImpl#getGoalmodel <em>Goalmodel</em>}</li>
 *   <li>{@link goalModel.impl.LinkImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link goalModel.impl.LinkImpl#getTrgs <em>Trgs</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LinkImpl extends MinimalEObjectImpl.Container implements Link {
	/**
	 * The cached value of the '{@link #getGoalmodel() <em>Goalmodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalmodel()
	 * @generated
	 * @ordered
	 */
	protected GoalModel goalmodel;

	/**
	 * The cached value of the '{@link #getTrgs() <em>Trgs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrgs()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentionalElement> trgs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GoalModel getGoalmodel() {
		if (goalmodel != null && goalmodel.eIsProxy()) {
			InternalEObject oldGoalmodel = (InternalEObject)goalmodel;
			goalmodel = (GoalModel)eResolveProxy(oldGoalmodel);
			if (goalmodel != oldGoalmodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GoalModelPackage.LINK__GOALMODEL, oldGoalmodel, goalmodel));
			}
		}
		return goalmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalModel basicGetGoalmodel() {
		return goalmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGoalmodel(GoalModel newGoalmodel, NotificationChain msgs) {
		GoalModel oldGoalmodel = goalmodel;
		goalmodel = newGoalmodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GoalModelPackage.LINK__GOALMODEL, oldGoalmodel, newGoalmodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGoalmodel(GoalModel newGoalmodel) {
		if (newGoalmodel != goalmodel) {
			NotificationChain msgs = null;
			if (goalmodel != null)
				msgs = ((InternalEObject)goalmodel).eInverseRemove(this, GoalModelPackage.GOAL_MODEL__INTER_ACTOR_LINKS, GoalModel.class, msgs);
			if (newGoalmodel != null)
				msgs = ((InternalEObject)newGoalmodel).eInverseAdd(this, GoalModelPackage.GOAL_MODEL__INTER_ACTOR_LINKS, GoalModel.class, msgs);
			msgs = basicSetGoalmodel(newGoalmodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.LINK__GOALMODEL, newGoalmodel, newGoalmodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntentionalElement getSrc() {
		if (eContainerFeatureID() != GoalModelPackage.LINK__SRC) return null;
		return (IntentionalElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSrc(IntentionalElement newSrc, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSrc, GoalModelPackage.LINK__SRC, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrc(IntentionalElement newSrc) {
		if (newSrc != eInternalContainer() || (eContainerFeatureID() != GoalModelPackage.LINK__SRC && newSrc != null)) {
			if (EcoreUtil.isAncestor(this, newSrc))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSrc != null)
				msgs = ((InternalEObject)newSrc).eInverseAdd(this, GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS, IntentionalElement.class, msgs);
			msgs = basicSetSrc(newSrc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.LINK__SRC, newSrc, newSrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntentionalElement> getTrgs() {
		if (trgs == null) {
			trgs = new EObjectWithInverseResolvingEList.ManyInverse<IntentionalElement>(IntentionalElement.class, this, GoalModelPackage.LINK__TRGS, GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS);
		}
		return trgs;
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
			case GoalModelPackage.LINK__GOALMODEL:
				if (goalmodel != null)
					msgs = ((InternalEObject)goalmodel).eInverseRemove(this, GoalModelPackage.GOAL_MODEL__INTER_ACTOR_LINKS, GoalModel.class, msgs);
				return basicSetGoalmodel((GoalModel)otherEnd, msgs);
			case GoalModelPackage.LINK__SRC:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSrc((IntentionalElement)otherEnd, msgs);
			case GoalModelPackage.LINK__TRGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTrgs()).basicAdd(otherEnd, msgs);
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
			case GoalModelPackage.LINK__GOALMODEL:
				return basicSetGoalmodel(null, msgs);
			case GoalModelPackage.LINK__SRC:
				return basicSetSrc(null, msgs);
			case GoalModelPackage.LINK__TRGS:
				return ((InternalEList<?>)getTrgs()).basicRemove(otherEnd, msgs);
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
			case GoalModelPackage.LINK__SRC:
				return eInternalContainer().eInverseRemove(this, GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS, IntentionalElement.class, msgs);
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
			case GoalModelPackage.LINK__GOALMODEL:
				if (resolve) return getGoalmodel();
				return basicGetGoalmodel();
			case GoalModelPackage.LINK__SRC:
				return getSrc();
			case GoalModelPackage.LINK__TRGS:
				return getTrgs();
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
			case GoalModelPackage.LINK__GOALMODEL:
				setGoalmodel((GoalModel)newValue);
				return;
			case GoalModelPackage.LINK__SRC:
				setSrc((IntentionalElement)newValue);
				return;
			case GoalModelPackage.LINK__TRGS:
				getTrgs().clear();
				getTrgs().addAll((Collection<? extends IntentionalElement>)newValue);
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
			case GoalModelPackage.LINK__GOALMODEL:
				setGoalmodel((GoalModel)null);
				return;
			case GoalModelPackage.LINK__SRC:
				setSrc((IntentionalElement)null);
				return;
			case GoalModelPackage.LINK__TRGS:
				getTrgs().clear();
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
			case GoalModelPackage.LINK__GOALMODEL:
				return goalmodel != null;
			case GoalModelPackage.LINK__SRC:
				return getSrc() != null;
			case GoalModelPackage.LINK__TRGS:
				return trgs != null && !trgs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LinkImpl
