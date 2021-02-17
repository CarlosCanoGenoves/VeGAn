/**
 */
package goalModel.util;

import goalModel.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see goalModel.GoalModelPackage
 * @generated
 */
public class GoalModelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final GoalModelValidator INSTANCE = new GoalModelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "goalModel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalModelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return GoalModelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case GoalModelPackage.GOAL_MODEL:
				return validateGoalModel((GoalModel)value, diagnostics, context);
			case GoalModelPackage.ACTOR:
				return validateActor((Actor)value, diagnostics, context);
			case GoalModelPackage.INTENTIONAL_ELEMENT:
				return validateIntentionalElement((IntentionalElement)value, diagnostics, context);
			case GoalModelPackage.LINK:
				return validateLink((Link)value, diagnostics, context);
			case GoalModelPackage.GOAL_ELEMENT:
				return validateGoalElement((GoalElement)value, diagnostics, context);
			case GoalModelPackage.CONTRIBUTION:
				return validateContribution((Contribution)value, diagnostics, context);
			case GoalModelPackage.DEPENDENCY:
				return validateDependency((Dependency)value, diagnostics, context);
			case GoalModelPackage.ITERATION:
				return validateIteration((Iteration)value, diagnostics, context);
			case GoalModelPackage.GOAL:
				return validateGoal((Goal)value, diagnostics, context);
			case GoalModelPackage.TASK:
				return validateTask((Task)value, diagnostics, context);
			case GoalModelPackage.SOFT_GOAL:
				return validateSoftGoal((SoftGoal)value, diagnostics, context);
			case GoalModelPackage.DECOMPOSITION:
				return validateDecomposition((Decomposition)value, diagnostics, context);
			case GoalModelPackage.VALUE_FROM:
				return validateValueFrom((ValueFrom)value, diagnostics, context);
			case GoalModelPackage.EIMPORTANCE:
				return validateEImportance((EImportance)value, diagnostics, context);
			case GoalModelPackage.ECONTRIBUTION:
				return validateEContribution((EContribution)value, diagnostics, context);
			case GoalModelPackage.ECONFIDENCE:
				return validateEConfidence((EConfidence)value, diagnostics, context);
			case GoalModelPackage.EDECOMPOSITION:
				return validateEDecomposition((EDecomposition)value, diagnostics, context);
			case GoalModelPackage.EVALUE_FROM:
				return validateEValueFrom((EValueFrom)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoalModel(GoalModel goalModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(goalModel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(goalModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateGoalModel_uniqueActorName(goalModel, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the uniqueActorName constraint of '<em>Goal Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String GOAL_MODEL__UNIQUE_ACTOR_NAME__EEXPRESSION = "self.actors->isUnique(name)";

	/**
	 * Validates the uniqueActorName constraint of '<em>Goal Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoalModel_uniqueActorName(GoalModel goalModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GoalModelPackage.Literals.GOAL_MODEL,
				 goalModel,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "uniqueActorName",
				 GOAL_MODEL__UNIQUE_ACTOR_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validateActor_uniqueIntentionalElementName(actor, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the uniqueIntentionalElementName constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACTOR__UNIQUE_INTENTIONAL_ELEMENT_NAME__EEXPRESSION = "self.intentionalelements->isUnique(name)";

	/**
	 * Validates the uniqueIntentionalElementName constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor_uniqueIntentionalElementName(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GoalModelPackage.Literals.ACTOR,
				 actor,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "uniqueIntentionalElementName",
				 ACTOR__UNIQUE_INTENTIONAL_ELEMENT_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntentionalElement(IntentionalElement intentionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(intentionalElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneDecomposition(intentionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneFather(intentionalElement, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the onlyOneDecomposition constraint of '<em>Intentional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String INTENTIONAL_ELEMENT__ONLY_ONE_DECOMPOSITION__EEXPRESSION = "self.srcLinks->select(oclIsTypeOf(Decomposition))->size() < 2";

	/**
	 * Validates the onlyOneDecomposition constraint of '<em>Intentional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntentionalElement_onlyOneDecomposition(IntentionalElement intentionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GoalModelPackage.Literals.INTENTIONAL_ELEMENT,
				 intentionalElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "onlyOneDecomposition",
				 INTENTIONAL_ELEMENT__ONLY_ONE_DECOMPOSITION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the onlyOneFather constraint of '<em>Intentional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String INTENTIONAL_ELEMENT__ONLY_ONE_FATHER__EEXPRESSION = "self.trgLinks->select(oclIsTypeOf(Decomposition))->size() < 2";

	/**
	 * Validates the onlyOneFather constraint of '<em>Intentional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntentionalElement_onlyOneFather(IntentionalElement intentionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GoalModelPackage.Literals.INTENTIONAL_ELEMENT,
				 intentionalElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "onlyOneFather",
				 INTENTIONAL_ELEMENT__ONLY_ONE_FATHER__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLink(Link link, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(link, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoalElement(GoalElement goalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(goalElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContribution(Contribution contribution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(contribution, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validateContribution_oneTarget(contribution, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the oneTarget constraint of '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONTRIBUTION__ONE_TARGET__EEXPRESSION = "self.trgs->size() <2";

	/**
	 * Validates the oneTarget constraint of '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContribution_oneTarget(Contribution contribution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GoalModelPackage.Literals.CONTRIBUTION,
				 contribution,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "oneTarget",
				 CONTRIBUTION__ONE_TARGET__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency(Dependency dependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dependency, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validateDependency_oneTarget(dependency, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the oneTarget constraint of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DEPENDENCY__ONE_TARGET__EEXPRESSION = "self.trgs->size() <2";

	/**
	 * Validates the oneTarget constraint of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency_oneTarget(Dependency dependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GoalModelPackage.Literals.DEPENDENCY,
				 dependency,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "oneTarget",
				 DEPENDENCY__ONE_TARGET__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteration(Iteration iteration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iteration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(goal, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneDecomposition(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneFather(goal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTask(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(task, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneDecomposition(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneFather(task, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSoftGoal(SoftGoal softGoal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(softGoal, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneDecomposition(softGoal, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntentionalElement_onlyOneFather(softGoal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecomposition(Decomposition decomposition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(decomposition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validateDecomposition_sameActor(decomposition, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the sameActor constraint of '<em>Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DECOMPOSITION__SAME_ACTOR__EEXPRESSION = "self.trgs->forAll(actor = self.src.actor)";

	/**
	 * Validates the sameActor constraint of '<em>Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecomposition_sameActor(Decomposition decomposition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GoalModelPackage.Literals.DECOMPOSITION,
				 decomposition,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sameActor",
				 DECOMPOSITION__SAME_ACTOR__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueFrom(ValueFrom valueFrom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueFrom, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEImportance(EImportance eImportance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEContribution(EContribution eContribution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEConfidence(EConfidence eConfidence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEDecomposition(EDecomposition eDecomposition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEValueFrom(EValueFrom eValueFrom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //GoalModelValidator
