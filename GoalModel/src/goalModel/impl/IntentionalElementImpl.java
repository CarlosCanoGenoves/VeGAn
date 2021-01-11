/**
 */
package goalModel.impl;

import goalModel.Actor;
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intentional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link goalModel.impl.IntentionalElementImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link goalModel.impl.IntentionalElementImpl#getSrcLinks <em>Src Links</em>}</li>
 *   <li>{@link goalModel.impl.IntentionalElementImpl#getTrgLinks <em>Trg Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntentionalElementImpl extends GoalElementImpl implements IntentionalElement {
	/**
	 * The cached value of the '{@link #getSrcLinks() <em>Src Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> srcLinks;

	/**
	 * The cached value of the '{@link #getTrgLinks() <em>Trg Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrgLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> trgLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntentionalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalModelPackage.Literals.INTENTIONAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Actor getActor() {
		if (eContainerFeatureID() != GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR) return null;
		return (Actor)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActor(Actor newActor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newActor, GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActor(Actor newActor) {
		if (newActor != eInternalContainer() || (eContainerFeatureID() != GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR && newActor != null)) {
			if (EcoreUtil.isAncestor(this, newActor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newActor != null)
				msgs = ((InternalEObject)newActor).eInverseAdd(this, GoalModelPackage.ACTOR__INTENTIONALELEMENTS, Actor.class, msgs);
			msgs = basicSetActor(newActor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR, newActor, newActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Link> getSrcLinks() {
		if (srcLinks == null) {
			srcLinks = new EObjectContainmentWithInverseEList<Link>(Link.class, this, GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS, GoalModelPackage.LINK__SRC);
		}
		return srcLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Link> getTrgLinks() {
		if (trgLinks == null) {
			trgLinks = new EObjectWithInverseResolvingEList.ManyInverse<Link>(Link.class, this, GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS, GoalModelPackage.LINK__TRGS);
		}
		return trgLinks;
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
			case GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetActor((Actor)otherEnd, msgs);
			case GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSrcLinks()).basicAdd(otherEnd, msgs);
			case GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTrgLinks()).basicAdd(otherEnd, msgs);
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
			case GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR:
				return basicSetActor(null, msgs);
			case GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS:
				return ((InternalEList<?>)getSrcLinks()).basicRemove(otherEnd, msgs);
			case GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS:
				return ((InternalEList<?>)getTrgLinks()).basicRemove(otherEnd, msgs);
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
			case GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR:
				return eInternalContainer().eInverseRemove(this, GoalModelPackage.ACTOR__INTENTIONALELEMENTS, Actor.class, msgs);
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
			case GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR:
				return getActor();
			case GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS:
				return getSrcLinks();
			case GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS:
				return getTrgLinks();
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
			case GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR:
				setActor((Actor)newValue);
				return;
			case GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS:
				getSrcLinks().clear();
				getSrcLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS:
				getTrgLinks().clear();
				getTrgLinks().addAll((Collection<? extends Link>)newValue);
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
			case GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR:
				setActor((Actor)null);
				return;
			case GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS:
				getSrcLinks().clear();
				return;
			case GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS:
				getTrgLinks().clear();
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
			case GoalModelPackage.INTENTIONAL_ELEMENT__ACTOR:
				return getActor() != null;
			case GoalModelPackage.INTENTIONAL_ELEMENT__SRC_LINKS:
				return srcLinks != null && !srcLinks.isEmpty();
			case GoalModelPackage.INTENTIONAL_ELEMENT__TRG_LINKS:
				return trgLinks != null && !trgLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IntentionalElementImpl
