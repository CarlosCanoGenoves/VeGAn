/**
 */
package goalModel.impl;

import goalModel.Actor;
import goalModel.Contribution;
import goalModel.Decomposition;
import goalModel.Dependency;
import goalModel.EConfidence;
import goalModel.EContribution;
import goalModel.EDecomposition;
import goalModel.EEvaluation;
import goalModel.EImportance;
import goalModel.EValueFrom;
import goalModel.Goal;
import goalModel.GoalElement;
import goalModel.GoalModel;
import goalModel.GoalModelFactory;
import goalModel.GoalModelPackage;
import goalModel.IntentionalElement;
import goalModel.Iteration;
import goalModel.Link;
import goalModel.SoftGoal;
import goalModel.Task;

import goalModel.ValueFrom;
import goalModel.util.GoalModelValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GoalModelPackageImpl extends EPackageImpl implements GoalModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intentionalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decompositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueFromEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eImportanceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eContributionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eConfidenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eDecompositionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eValueFromEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eEvaluationEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see goalModel.GoalModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GoalModelPackageImpl() {
		super(eNS_URI, GoalModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link GoalModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GoalModelPackage init() {
		if (isInited) return (GoalModelPackage)EPackage.Registry.INSTANCE.getEPackage(GoalModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGoalModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GoalModelPackageImpl theGoalModelPackage = registeredGoalModelPackage instanceof GoalModelPackageImpl ? (GoalModelPackageImpl)registeredGoalModelPackage : new GoalModelPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theGoalModelPackage.createPackageContents();

		// Initialize created meta-data
		theGoalModelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theGoalModelPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return GoalModelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theGoalModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GoalModelPackage.eNS_URI, theGoalModelPackage);
		return theGoalModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGoalModel() {
		return goalModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalModel_Name() {
		return (EAttribute)goalModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGoalModel_Actors() {
		return (EReference)goalModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalModel_Iteration() {
		return (EAttribute)goalModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActor_Goalmodel() {
		return (EReference)actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActor_Intentionalelements() {
		return (EReference)actorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntentionalElement() {
		return intentionalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntentionalElement_Actor() {
		return (EReference)intentionalElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntentionalElement_SrcLinks() {
		return (EReference)intentionalElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntentionalElement_TrgLinks() {
		return (EReference)intentionalElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLink_Src() {
		return (EReference)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLink_Trgs() {
		return (EReference)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGoalElement() {
		return goalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalElement_Name() {
		return (EAttribute)goalElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalElement_ElementName() {
		return (EAttribute)goalElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalElement_Importance() {
		return (EAttribute)goalElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalElement_Confidence() {
		return (EAttribute)goalElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalElement_LocalValue() {
		return (EAttribute)goalElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGoalElement_Iterations() {
		return (EReference)goalElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalElement_GlobalValue() {
		return (EAttribute)goalElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoalElement_Evaluation() {
		return (EAttribute)goalElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContribution() {
		return contributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContribution_Name() {
		return (EAttribute)contributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContribution_ContributionType() {
		return (EAttribute)contributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependency() {
		return dependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_Name() {
		return (EAttribute)dependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIteration() {
		return iterationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteration_Name() {
		return (EAttribute)iterationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteration_Iteration() {
		return (EAttribute)iterationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteration_Importance() {
		return (EAttribute)iterationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteration_Confidence() {
		return (EAttribute)iterationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteration_Element() {
		return (EReference)iterationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteration_GlobalValue() {
		return (EAttribute)iterationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteration_LocalValue() {
		return (EAttribute)iterationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteration_Valuefrom() {
		return (EReference)iterationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGoal() {
		return goalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSoftGoal() {
		return softGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDecomposition() {
		return decompositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDecomposition_DecompositionType() {
		return (EAttribute)decompositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValueFrom() {
		return valueFromEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueFrom_Name() {
		return (EAttribute)valueFromEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueFrom_Value() {
		return (EAttribute)valueFromEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueFrom_ValueFrom() {
		return (EAttribute)valueFromEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValueFrom_Iteration() {
		return (EReference)valueFromEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValueFrom_Intentionalelement() {
		return (EReference)valueFromEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEImportance() {
		return eImportanceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEContribution() {
		return eContributionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEConfidence() {
		return eConfidenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEDecomposition() {
		return eDecompositionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEValueFrom() {
		return eValueFromEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEEvaluation() {
		return eEvaluationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GoalModelFactory getGoalModelFactory() {
		return (GoalModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		goalModelEClass = createEClass(GOAL_MODEL);
		createEAttribute(goalModelEClass, GOAL_MODEL__NAME);
		createEReference(goalModelEClass, GOAL_MODEL__ACTORS);
		createEAttribute(goalModelEClass, GOAL_MODEL__ITERATION);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__GOALMODEL);
		createEReference(actorEClass, ACTOR__INTENTIONALELEMENTS);

		intentionalElementEClass = createEClass(INTENTIONAL_ELEMENT);
		createEReference(intentionalElementEClass, INTENTIONAL_ELEMENT__ACTOR);
		createEReference(intentionalElementEClass, INTENTIONAL_ELEMENT__SRC_LINKS);
		createEReference(intentionalElementEClass, INTENTIONAL_ELEMENT__TRG_LINKS);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__SRC);
		createEReference(linkEClass, LINK__TRGS);

		goalElementEClass = createEClass(GOAL_ELEMENT);
		createEAttribute(goalElementEClass, GOAL_ELEMENT__NAME);
		createEAttribute(goalElementEClass, GOAL_ELEMENT__ELEMENT_NAME);
		createEAttribute(goalElementEClass, GOAL_ELEMENT__IMPORTANCE);
		createEAttribute(goalElementEClass, GOAL_ELEMENT__CONFIDENCE);
		createEAttribute(goalElementEClass, GOAL_ELEMENT__LOCAL_VALUE);
		createEReference(goalElementEClass, GOAL_ELEMENT__ITERATIONS);
		createEAttribute(goalElementEClass, GOAL_ELEMENT__GLOBAL_VALUE);
		createEAttribute(goalElementEClass, GOAL_ELEMENT__EVALUATION);

		contributionEClass = createEClass(CONTRIBUTION);
		createEAttribute(contributionEClass, CONTRIBUTION__NAME);
		createEAttribute(contributionEClass, CONTRIBUTION__CONTRIBUTION_TYPE);

		dependencyEClass = createEClass(DEPENDENCY);
		createEAttribute(dependencyEClass, DEPENDENCY__NAME);

		iterationEClass = createEClass(ITERATION);
		createEAttribute(iterationEClass, ITERATION__NAME);
		createEAttribute(iterationEClass, ITERATION__ITERATION);
		createEAttribute(iterationEClass, ITERATION__IMPORTANCE);
		createEAttribute(iterationEClass, ITERATION__CONFIDENCE);
		createEReference(iterationEClass, ITERATION__ELEMENT);
		createEAttribute(iterationEClass, ITERATION__GLOBAL_VALUE);
		createEAttribute(iterationEClass, ITERATION__LOCAL_VALUE);
		createEReference(iterationEClass, ITERATION__VALUEFROM);

		goalEClass = createEClass(GOAL);

		taskEClass = createEClass(TASK);

		softGoalEClass = createEClass(SOFT_GOAL);

		decompositionEClass = createEClass(DECOMPOSITION);
		createEAttribute(decompositionEClass, DECOMPOSITION__DECOMPOSITION_TYPE);

		valueFromEClass = createEClass(VALUE_FROM);
		createEAttribute(valueFromEClass, VALUE_FROM__NAME);
		createEAttribute(valueFromEClass, VALUE_FROM__VALUE);
		createEAttribute(valueFromEClass, VALUE_FROM__VALUE_FROM);
		createEReference(valueFromEClass, VALUE_FROM__ITERATION);
		createEReference(valueFromEClass, VALUE_FROM__INTENTIONALELEMENT);

		// Create enums
		eImportanceEEnum = createEEnum(EIMPORTANCE);
		eContributionEEnum = createEEnum(ECONTRIBUTION);
		eConfidenceEEnum = createEEnum(ECONFIDENCE);
		eDecompositionEEnum = createEEnum(EDECOMPOSITION);
		eValueFromEEnum = createEEnum(EVALUE_FROM);
		eEvaluationEEnum = createEEnum(EEVALUATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actorEClass.getESuperTypes().add(this.getGoalElement());
		intentionalElementEClass.getESuperTypes().add(this.getGoalElement());
		contributionEClass.getESuperTypes().add(this.getLink());
		dependencyEClass.getESuperTypes().add(this.getLink());
		goalEClass.getESuperTypes().add(this.getIntentionalElement());
		taskEClass.getESuperTypes().add(this.getIntentionalElement());
		softGoalEClass.getESuperTypes().add(this.getIntentionalElement());
		decompositionEClass.getESuperTypes().add(this.getLink());

		// Initialize classes, features, and operations; add parameters
		initEClass(goalModelEClass, GoalModel.class, "GoalModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoalModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, GoalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoalModel_Actors(), this.getActor(), this.getActor_Goalmodel(), "actors", null, 0, -1, GoalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalModel_Iteration(), ecorePackage.getEInt(), "iteration", "0", 1, 1, GoalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_Goalmodel(), this.getGoalModel(), this.getGoalModel_Actors(), "goalmodel", null, 1, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_Intentionalelements(), this.getIntentionalElement(), this.getIntentionalElement_Actor(), "intentionalelements", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentionalElementEClass, IntentionalElement.class, "IntentionalElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntentionalElement_Actor(), this.getActor(), this.getActor_Intentionalelements(), "actor", null, 1, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentionalElement_SrcLinks(), this.getLink(), this.getLink_Src(), "srcLinks", null, 0, -1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentionalElement_TrgLinks(), this.getLink(), this.getLink_Trgs(), "trgLinks", null, 0, -1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_Src(), this.getIntentionalElement(), this.getIntentionalElement_SrcLinks(), "src", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLink_Trgs(), this.getIntentionalElement(), this.getIntentionalElement_TrgLinks(), "trgs", null, 1, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalElementEClass, GoalElement.class, "GoalElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoalElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, GoalElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalElement_ElementName(), ecorePackage.getEString(), "elementName", null, 0, 1, GoalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalElement_Importance(), this.getEImportance(), "importance", "Not_Defined", 0, 1, GoalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalElement_Confidence(), this.getEConfidence(), "confidence", "Not_Defined", 0, 1, GoalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalElement_LocalValue(), ecorePackage.getEDouble(), "localValue", null, 1, 1, GoalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoalElement_Iterations(), this.getIteration(), this.getIteration_Element(), "iterations", null, 0, -1, GoalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalElement_GlobalValue(), ecorePackage.getEDouble(), "globalValue", null, 1, 1, GoalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalElement_Evaluation(), this.getEEvaluation(), "evaluation", "Not_Defined", 0, 1, GoalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contributionEClass, Contribution.class, "Contribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContribution_Name(), ecorePackage.getEString(), "name", null, 0, 1, Contribution.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getContribution_ContributionType(), this.getEContribution(), "contributionType", "p0", 0, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyEClass, Dependency.class, "Dependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDependency_Name(), ecorePackage.getEString(), "name", null, 0, 1, Dependency.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(iterationEClass, Iteration.class, "Iteration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIteration_Name(), ecorePackage.getEString(), "name", null, 0, 1, Iteration.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIteration_Iteration(), ecorePackage.getEInt(), "iteration", null, 1, 1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIteration_Importance(), this.getEImportance(), "importance", null, 0, 1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIteration_Confidence(), this.getEConfidence(), "confidence", "Confident", 0, 1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteration_Element(), this.getGoalElement(), this.getGoalElement_Iterations(), "element", null, 0, 1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIteration_GlobalValue(), ecorePackage.getEDouble(), "globalValue", null, 1, 1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIteration_LocalValue(), ecorePackage.getEDouble(), "localValue", null, 1, 1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteration_Valuefrom(), this.getValueFrom(), this.getValueFrom_Iteration(), "valuefrom", null, 0, -1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(softGoalEClass, SoftGoal.class, "SoftGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(decompositionEClass, Decomposition.class, "Decomposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecomposition_DecompositionType(), this.getEDecomposition(), "decompositionType", "AND", 0, 1, Decomposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueFromEClass, ValueFrom.class, "ValueFrom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueFrom_Name(), ecorePackage.getEString(), "name", null, 0, 1, ValueFrom.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueFrom_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, ValueFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueFrom_ValueFrom(), this.getEValueFrom(), "valueFrom", null, 0, 1, ValueFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValueFrom_Iteration(), this.getIteration(), this.getIteration_Valuefrom(), "iteration", null, 1, 1, ValueFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValueFrom_Intentionalelement(), this.getIntentionalElement(), null, "intentionalelement", null, 1, 1, ValueFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eImportanceEEnum, EImportance.class, "EImportance");
		addEEnumLiteral(eImportanceEEnum, EImportance.VERY_HIGH);
		addEEnumLiteral(eImportanceEEnum, EImportance.HIGH);
		addEEnumLiteral(eImportanceEEnum, EImportance.MEDIUM);
		addEEnumLiteral(eImportanceEEnum, EImportance.LOW);
		addEEnumLiteral(eImportanceEEnum, EImportance.VERY_LOW);
		addEEnumLiteral(eImportanceEEnum, EImportance.NOT_DEFINED);

		initEEnum(eContributionEEnum, EContribution.class, "EContribution");
		addEEnumLiteral(eContributionEEnum, EContribution.P100);
		addEEnumLiteral(eContributionEEnum, EContribution.P75);
		addEEnumLiteral(eContributionEEnum, EContribution.P50);
		addEEnumLiteral(eContributionEEnum, EContribution.P25);
		addEEnumLiteral(eContributionEEnum, EContribution.P0);
		addEEnumLiteral(eContributionEEnum, EContribution.N25);
		addEEnumLiteral(eContributionEEnum, EContribution.N50);
		addEEnumLiteral(eContributionEEnum, EContribution.N75);
		addEEnumLiteral(eContributionEEnum, EContribution.N100);

		initEEnum(eConfidenceEEnum, EConfidence.class, "EConfidence");
		addEEnumLiteral(eConfidenceEEnum, EConfidence.POSSIBLY_MORE);
		addEEnumLiteral(eConfidenceEEnum, EConfidence.CONFIDENT);
		addEEnumLiteral(eConfidenceEEnum, EConfidence.POSSIBLY_LESS);
		addEEnumLiteral(eConfidenceEEnum, EConfidence.NOT_DEFINED);

		initEEnum(eDecompositionEEnum, EDecomposition.class, "EDecomposition");
		addEEnumLiteral(eDecompositionEEnum, EDecomposition.AND);
		addEEnumLiteral(eDecompositionEEnum, EDecomposition.IOR);
		addEEnumLiteral(eDecompositionEEnum, EDecomposition.XOR);

		initEEnum(eValueFromEEnum, EValueFrom.class, "EValueFrom");
		addEEnumLiteral(eValueFromEEnum, EValueFrom.LOCAL);
		addEEnumLiteral(eValueFromEEnum, EValueFrom.EXTERNAL);

		initEEnum(eEvaluationEEnum, EEvaluation.class, "EEvaluation");
		addEEnumLiteral(eEvaluationEEnum, EEvaluation.STRONGLY_AGREE);
		addEEnumLiteral(eEvaluationEEnum, EEvaluation.AGREE);
		addEEnumLiteral(eEvaluationEEnum, EEvaluation.NEUTRAL);
		addEEnumLiteral(eEvaluationEEnum, EEvaluation.DISAGREE);
		addEEnumLiteral(eEvaluationEEnum, EEvaluation.STRONGLY_DISAGREE);
		addEEnumLiteral(eEvaluationEEnum, EEvaluation.NOT_DEFINED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// http://www.obeo.fr/dsl/dnc/archetype
		createArchetypeAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
		addAnnotation
		  (goalModelEClass,
		   source,
		   new String[] {
			   "constraints", "The_name_of_the_actor_must_be_unique"
		   });
		addAnnotation
		  (actorEClass,
		   source,
		   new String[] {
			   "constraints", "The_name_of_the_intentional_element_must_be_unique"
		   });
		addAnnotation
		  (intentionalElementEClass,
		   source,
		   new String[] {
			   "constraints", "An_intentional_element_can_only_have_one_decomposition An_intentional_element_can_only_decompose_one_element"
		   });
		addAnnotation
		  (goalElementEClass,
		   source,
		   new String[] {
			   "constraints", "Importance_not_defined Confidence_not_defined"
		   });
		addAnnotation
		  (contributionEClass,
		   source,
		   new String[] {
			   "constraints", "Only_one_target"
		   });
		addAnnotation
		  (dependencyEClass,
		   source,
		   new String[] {
			   "constraints", "Only_one_target"
		   });
		addAnnotation
		  (decompositionEClass,
		   source,
		   new String[] {
			   "constraints", "All_the_intentional_elements_of_a_decomposition_must_belong_to_the_same_actor"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (goalModelEClass,
		   source,
		   new String[] {
			   "The_name_of_the_actor_must_be_unique", "self.actors->isUnique(name)"
		   });
		addAnnotation
		  (actorEClass,
		   source,
		   new String[] {
			   "The_name_of_the_intentional_element_must_be_unique", "self.intentionalelements->isUnique(name)"
		   });
		addAnnotation
		  (intentionalElementEClass,
		   source,
		   new String[] {
			   "An_intentional_element_can_only_have_one_decomposition", "self.srcLinks->select(oclIsTypeOf(Decomposition))->size() < 2",
			   "An_intentional_element_can_only_decompose_one_element", "self.trgLinks->select(oclIsTypeOf(Decomposition))->size() < 2"
		   });
		addAnnotation
		  (goalElementEClass,
		   source,
		   new String[] {
			   "Importance_not_defined", "importance <> EImportance::Not_Defined",
			   "Confidence_not_defined", "confidence <> EConfidence::Not_Defined"
		   });
		addAnnotation
		  (getGoalElement_Name(),
		   source,
		   new String[] {
			   "derivation", "let imp : String = if self.importance = EImportance::Very_High then \'Very High\' \n\t\t\telseif self.importance = EImportance::High then \'High\'\n\t\t\telseif self.importance = EImportance::Medium then \'Medium\'\n\t\t\telseif self.importance = EImportance::Low then \'Low\' \n\t\t\telseif self.importance = EImportance::Very_Low then \'Very Low\'\n\t\t\telse \'Not Defined\' endif\n\t\t\tin let conf : String = if self.confidence = EConfidence::Possibly_More then \'Possibly More\' \n\t\t\telseif self.confidence = EConfidence::Confident then \'Confident\' \n\t\t\telseif self.confidence = EConfidence::Possibly_Less then \'Possibly Less\' \n\t\t\telse \'Not Defined\' endif\n\t\t\tin elementName + \' \' + imp + \' \' + conf"
		   });
		addAnnotation
		  (contributionEClass,
		   source,
		   new String[] {
			   "Only_one_target", "self.trgs->size() <2"
		   });
		addAnnotation
		  (getContribution_Name(),
		   source,
		   new String[] {
			   "derivation", "let impact : Integer = if self.contributionType = EContribution::p100 then 100 elseif self.contributionType = EContribution::p75 then 75 \n\t\t\telseif self.contributionType = EContribution::p50 then 50 elseif self.contributionType = EContribution::p25 then 25\n\t\t\telseif self.contributionType = EContribution::n25 then -25 elseif self.contributionType = EContribution::n50 then -50 \n\t\t\telseif self.contributionType = EContribution::n75 then -75 elseif self.contributionType = EContribution::n100 then -100 else 0 endif\n\t\t\tin if trgs->size() <> 0 then src.name + \' to \' + trgs->first().name + \' (\' + impact.toString() + \')\' else \'\' endif"
		   });
		addAnnotation
		  (dependencyEClass,
		   source,
		   new String[] {
			   "Only_one_target", "self.trgs->size() <2"
		   });
		addAnnotation
		  (getDependency_Name(),
		   source,
		   new String[] {
			   "derivation", "if trgs->size() <> 0 then src.name+\' to \'+trgs->first().name else \'\' endif"
		   });
		addAnnotation
		  (getIteration_Name(),
		   source,
		   new String[] {
			   "derivation", "let reducedValue : String = if globalValue < 0 then (if globalValue.toString().size() >5 then globalValue.toString().substring(1, 5) else globalValue.toString() endif) else (if globalValue.toString().size() > 4 then globalValue.toString().substring(1, 4) else globalValue.toString() endif) endif \n\t\t\t\t\tin iteration.toString() + \'- Value: \' + reducedValue"
		   });
		addAnnotation
		  (decompositionEClass,
		   source,
		   new String[] {
			   "All_the_intentional_elements_of_a_decomposition_must_belong_to_the_same_actor", "self.trgs->forAll(actor = self.src.actor)"
		   });
		addAnnotation
		  (getValueFrom_Name(),
		   source,
		   new String[] {
			   "derivation", "let reducedValue : String = if value < 0 then (if value.toString().size() >5 then value.toString().substring(1, 5) else value.toString() endif) else (if value.toString().size() > 4 then value.toString().substring(1, 4) else value.toString() endif) endif \n\t\t\t\t\tin reducedValue + \' - \' + intentionalelement.name"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.obeo.fr/dsl/dnc/archetype</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArchetypeAnnotations() {
		String source = "http://www.obeo.fr/dsl/dnc/archetype";
		addAnnotation
		  (iterationEClass,
		   source,
		   new String[] {
			   "archetype", "Thing"
		   });
	}

} //GoalModelPackageImpl
