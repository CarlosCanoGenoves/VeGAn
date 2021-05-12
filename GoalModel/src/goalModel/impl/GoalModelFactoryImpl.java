/**
 */
package goalModel.impl;

import goalModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GoalModelFactoryImpl extends EFactoryImpl implements GoalModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GoalModelFactory init() {
		try {
			GoalModelFactory theGoalModelFactory = (GoalModelFactory)EPackage.Registry.INSTANCE.getEFactory(GoalModelPackage.eNS_URI);
			if (theGoalModelFactory != null) {
				return theGoalModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GoalModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GoalModelPackage.GOAL_MODEL: return createGoalModel();
			case GoalModelPackage.ACTOR: return createActor();
			case GoalModelPackage.CONTRIBUTION: return createContribution();
			case GoalModelPackage.DEPENDENCY: return createDependency();
			case GoalModelPackage.ITERATION: return createIteration();
			case GoalModelPackage.GOAL: return createGoal();
			case GoalModelPackage.TASK: return createTask();
			case GoalModelPackage.SOFT_GOAL: return createSoftGoal();
			case GoalModelPackage.DECOMPOSITION: return createDecomposition();
			case GoalModelPackage.VALUE_FROM: return createValueFrom();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GoalModelPackage.EIMPORTANCE:
				return createEImportanceFromString(eDataType, initialValue);
			case GoalModelPackage.ECONTRIBUTION:
				return createEContributionFromString(eDataType, initialValue);
			case GoalModelPackage.ECONFIDENCE:
				return createEConfidenceFromString(eDataType, initialValue);
			case GoalModelPackage.EDECOMPOSITION:
				return createEDecompositionFromString(eDataType, initialValue);
			case GoalModelPackage.EVALUE_FROM:
				return createEValueFromFromString(eDataType, initialValue);
			case GoalModelPackage.EEVALUATION:
				return createEEvaluationFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GoalModelPackage.EIMPORTANCE:
				return convertEImportanceToString(eDataType, instanceValue);
			case GoalModelPackage.ECONTRIBUTION:
				return convertEContributionToString(eDataType, instanceValue);
			case GoalModelPackage.ECONFIDENCE:
				return convertEConfidenceToString(eDataType, instanceValue);
			case GoalModelPackage.EDECOMPOSITION:
				return convertEDecompositionToString(eDataType, instanceValue);
			case GoalModelPackage.EVALUE_FROM:
				return convertEValueFromToString(eDataType, instanceValue);
			case GoalModelPackage.EEVALUATION:
				return convertEEvaluationToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GoalModel createGoalModel() {
		GoalModelImpl goalModel = new GoalModelImpl();
		return goalModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contribution createContribution() {
		ContributionImpl contribution = new ContributionImpl();
		return contribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Dependency createDependency() {
		DependencyImpl dependency = new DependencyImpl();
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iteration createIteration() {
		IterationImpl iteration = new IterationImpl();
		return iteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SoftGoal createSoftGoal() {
		SoftGoalImpl softGoal = new SoftGoalImpl();
		return softGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Decomposition createDecomposition() {
		DecompositionImpl decomposition = new DecompositionImpl();
		return decomposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueFrom createValueFrom() {
		ValueFromImpl valueFrom = new ValueFromImpl();
		return valueFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImportance createEImportanceFromString(EDataType eDataType, String initialValue) {
		EImportance result = EImportance.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEImportanceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EContribution createEContributionFromString(EDataType eDataType, String initialValue) {
		EContribution result = EContribution.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEContributionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfidence createEConfidenceFromString(EDataType eDataType, String initialValue) {
		EConfidence result = EConfidence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEConfidenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDecomposition createEDecompositionFromString(EDataType eDataType, String initialValue) {
		EDecomposition result = EDecomposition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDecompositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EValueFrom createEValueFromFromString(EDataType eDataType, String initialValue) {
		EValueFrom result = EValueFrom.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEValueFromToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEvaluation createEEvaluationFromString(EDataType eDataType, String initialValue) {
		EEvaluation result = EEvaluation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEEvaluationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GoalModelPackage getGoalModelPackage() {
		return (GoalModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GoalModelPackage getPackage() {
		return GoalModelPackage.eINSTANCE;
	}

} //GoalModelFactoryImpl
