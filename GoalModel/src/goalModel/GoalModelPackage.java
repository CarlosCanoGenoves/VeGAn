/**
 */
package goalModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see goalModel.GoalModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface GoalModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "goalModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://goalModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "goalModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GoalModelPackage eINSTANCE = goalModel.impl.GoalModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link goalModel.impl.GoalModelImpl <em>Goal Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.GoalModelImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getGoalModel()
	 * @generated
	 */
	int GOAL_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_MODEL__ACTORS = 1;

	/**
	 * The feature id for the '<em><b>Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_MODEL__ITERATION = 2;

	/**
	 * The number of structural features of the '<em>Goal Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Goal Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.GoalElementImpl <em>Goal Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.GoalElementImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getGoalElement()
	 * @generated
	 */
	int GOAL_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__ELEMENT_NAME = 1;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__IMPORTANCE = 2;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__CONFIDENCE = 3;

	/**
	 * The feature id for the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__LOCAL_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__ITERATIONS = 5;

	/**
	 * The feature id for the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__GLOBAL_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT__EVALUATION = 7;

	/**
	 * The number of structural features of the '<em>Goal Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Goal Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.ActorImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = GOAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ELEMENT_NAME = GOAL_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__IMPORTANCE = GOAL_ELEMENT__IMPORTANCE;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CONFIDENCE = GOAL_ELEMENT__CONFIDENCE;

	/**
	 * The feature id for the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__LOCAL_VALUE = GOAL_ELEMENT__LOCAL_VALUE;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ITERATIONS = GOAL_ELEMENT__ITERATIONS;

	/**
	 * The feature id for the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__GLOBAL_VALUE = GOAL_ELEMENT__GLOBAL_VALUE;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__EVALUATION = GOAL_ELEMENT__EVALUATION;

	/**
	 * The feature id for the '<em><b>Goalmodel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__GOALMODEL = GOAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Intentionalelements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INTENTIONALELEMENTS = GOAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = GOAL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_OPERATION_COUNT = GOAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.IntentionalElementImpl <em>Intentional Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.IntentionalElementImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getIntentionalElement()
	 * @generated
	 */
	int INTENTIONAL_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__NAME = GOAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__ELEMENT_NAME = GOAL_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__IMPORTANCE = GOAL_ELEMENT__IMPORTANCE;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__CONFIDENCE = GOAL_ELEMENT__CONFIDENCE;

	/**
	 * The feature id for the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__LOCAL_VALUE = GOAL_ELEMENT__LOCAL_VALUE;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__ITERATIONS = GOAL_ELEMENT__ITERATIONS;

	/**
	 * The feature id for the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__GLOBAL_VALUE = GOAL_ELEMENT__GLOBAL_VALUE;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__EVALUATION = GOAL_ELEMENT__EVALUATION;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__ACTOR = GOAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__SRC_LINKS = GOAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Trg Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__TRG_LINKS = GOAL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Intentional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT_FEATURE_COUNT = GOAL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Intentional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT_OPERATION_COUNT = GOAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.LinkImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 3;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SRC = 0;

	/**
	 * The feature id for the '<em><b>Trgs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TRGS = 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.ContributionImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 5;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__SRC = LINK__SRC;

	/**
	 * The feature id for the '<em><b>Trgs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__TRGS = LINK__TRGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__NAME = LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contribution Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__CONTRIBUTION_TYPE = LINK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = LINK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_OPERATION_COUNT = LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.DependencyImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 6;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SRC = LINK__SRC;

	/**
	 * The feature id for the '<em><b>Trgs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__TRGS = LINK__TRGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__NAME = LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = LINK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.IterationImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__ITERATION = 1;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IMPORTANCE = 2;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__CONFIDENCE = 3;

	/**
	 * The feature id for the '<em><b>Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__GLOBAL_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__LOCAL_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Valuefrom</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__VALUEFROM = 7;

	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.GoalImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = INTENTIONAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ELEMENT_NAME = INTENTIONAL_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IMPORTANCE = INTENTIONAL_ELEMENT__IMPORTANCE;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CONFIDENCE = INTENTIONAL_ELEMENT__CONFIDENCE;

	/**
	 * The feature id for the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__LOCAL_VALUE = INTENTIONAL_ELEMENT__LOCAL_VALUE;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ITERATIONS = INTENTIONAL_ELEMENT__ITERATIONS;

	/**
	 * The feature id for the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__GLOBAL_VALUE = INTENTIONAL_ELEMENT__GLOBAL_VALUE;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__EVALUATION = INTENTIONAL_ELEMENT__EVALUATION;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ACTOR = INTENTIONAL_ELEMENT__ACTOR;

	/**
	 * The feature id for the '<em><b>Src Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SRC_LINKS = INTENTIONAL_ELEMENT__SRC_LINKS;

	/**
	 * The feature id for the '<em><b>Trg Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__TRG_LINKS = INTENTIONAL_ELEMENT__TRG_LINKS;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = INTENTIONAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = INTENTIONAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.TaskImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = INTENTIONAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ELEMENT_NAME = INTENTIONAL_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__IMPORTANCE = INTENTIONAL_ELEMENT__IMPORTANCE;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CONFIDENCE = INTENTIONAL_ELEMENT__CONFIDENCE;

	/**
	 * The feature id for the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__LOCAL_VALUE = INTENTIONAL_ELEMENT__LOCAL_VALUE;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ITERATIONS = INTENTIONAL_ELEMENT__ITERATIONS;

	/**
	 * The feature id for the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__GLOBAL_VALUE = INTENTIONAL_ELEMENT__GLOBAL_VALUE;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EVALUATION = INTENTIONAL_ELEMENT__EVALUATION;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ACTOR = INTENTIONAL_ELEMENT__ACTOR;

	/**
	 * The feature id for the '<em><b>Src Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__SRC_LINKS = INTENTIONAL_ELEMENT__SRC_LINKS;

	/**
	 * The feature id for the '<em><b>Trg Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TRG_LINKS = INTENTIONAL_ELEMENT__TRG_LINKS;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = INTENTIONAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OPERATION_COUNT = INTENTIONAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.SoftGoalImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getSoftGoal()
	 * @generated
	 */
	int SOFT_GOAL = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__NAME = INTENTIONAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__ELEMENT_NAME = INTENTIONAL_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__IMPORTANCE = INTENTIONAL_ELEMENT__IMPORTANCE;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__CONFIDENCE = INTENTIONAL_ELEMENT__CONFIDENCE;

	/**
	 * The feature id for the '<em><b>Local Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__LOCAL_VALUE = INTENTIONAL_ELEMENT__LOCAL_VALUE;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__ITERATIONS = INTENTIONAL_ELEMENT__ITERATIONS;

	/**
	 * The feature id for the '<em><b>Global Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__GLOBAL_VALUE = INTENTIONAL_ELEMENT__GLOBAL_VALUE;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__EVALUATION = INTENTIONAL_ELEMENT__EVALUATION;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__ACTOR = INTENTIONAL_ELEMENT__ACTOR;

	/**
	 * The feature id for the '<em><b>Src Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__SRC_LINKS = INTENTIONAL_ELEMENT__SRC_LINKS;

	/**
	 * The feature id for the '<em><b>Trg Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__TRG_LINKS = INTENTIONAL_ELEMENT__TRG_LINKS;

	/**
	 * The number of structural features of the '<em>Soft Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL_FEATURE_COUNT = INTENTIONAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Soft Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL_OPERATION_COUNT = INTENTIONAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.DecompositionImpl <em>Decomposition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.DecompositionImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getDecomposition()
	 * @generated
	 */
	int DECOMPOSITION = 11;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__SRC = LINK__SRC;

	/**
	 * The feature id for the '<em><b>Trgs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__TRGS = LINK__TRGS;

	/**
	 * The feature id for the '<em><b>Decomposition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__DECOMPOSITION_TYPE = LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decomposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION_FEATURE_COUNT = LINK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Decomposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION_OPERATION_COUNT = LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link goalModel.impl.ValueFromImpl <em>Value From</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.impl.ValueFromImpl
	 * @see goalModel.impl.GoalModelPackageImpl#getValueFrom()
	 * @generated
	 */
	int VALUE_FROM = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FROM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FROM__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Value From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FROM__VALUE_FROM = 2;

	/**
	 * The feature id for the '<em><b>Iteration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FROM__ITERATION = 3;

	/**
	 * The feature id for the '<em><b>Intentionalelement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FROM__INTENTIONALELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Value From</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FROM_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Value From</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FROM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link goalModel.EImportance <em>EImportance</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.EImportance
	 * @see goalModel.impl.GoalModelPackageImpl#getEImportance()
	 * @generated
	 */
	int EIMPORTANCE = 13;

	/**
	 * The meta object id for the '{@link goalModel.EContribution <em>EContribution</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.EContribution
	 * @see goalModel.impl.GoalModelPackageImpl#getEContribution()
	 * @generated
	 */
	int ECONTRIBUTION = 14;

	/**
	 * The meta object id for the '{@link goalModel.EConfidence <em>EConfidence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.EConfidence
	 * @see goalModel.impl.GoalModelPackageImpl#getEConfidence()
	 * @generated
	 */
	int ECONFIDENCE = 15;

	/**
	 * The meta object id for the '{@link goalModel.EDecomposition <em>EDecomposition</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.EDecomposition
	 * @see goalModel.impl.GoalModelPackageImpl#getEDecomposition()
	 * @generated
	 */
	int EDECOMPOSITION = 16;


	/**
	 * The meta object id for the '{@link goalModel.EValueFrom <em>EValue From</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.EValueFrom
	 * @see goalModel.impl.GoalModelPackageImpl#getEValueFrom()
	 * @generated
	 */
	int EVALUE_FROM = 17;


	/**
	 * The meta object id for the '{@link goalModel.EEvaluation <em>EEvaluation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see goalModel.EEvaluation
	 * @see goalModel.impl.GoalModelPackageImpl#getEEvaluation()
	 * @generated
	 */
	int EEVALUATION = 18;


	/**
	 * Returns the meta object for class '{@link goalModel.GoalModel <em>Goal Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Model</em>'.
	 * @see goalModel.GoalModel
	 * @generated
	 */
	EClass getGoalModel();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see goalModel.GoalModel#getName()
	 * @see #getGoalModel()
	 * @generated
	 */
	EAttribute getGoalModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link goalModel.GoalModel#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see goalModel.GoalModel#getActors()
	 * @see #getGoalModel()
	 * @generated
	 */
	EReference getGoalModel_Actors();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalModel#getIteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iteration</em>'.
	 * @see goalModel.GoalModel#getIteration()
	 * @see #getGoalModel()
	 * @generated
	 */
	EAttribute getGoalModel_Iteration();

	/**
	 * Returns the meta object for class '{@link goalModel.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see goalModel.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the container reference '{@link goalModel.Actor#getGoalmodel <em>Goalmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Goalmodel</em>'.
	 * @see goalModel.Actor#getGoalmodel()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Goalmodel();

	/**
	 * Returns the meta object for the containment reference list '{@link goalModel.Actor#getIntentionalelements <em>Intentionalelements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intentionalelements</em>'.
	 * @see goalModel.Actor#getIntentionalelements()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Intentionalelements();

	/**
	 * Returns the meta object for class '{@link goalModel.IntentionalElement <em>Intentional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intentional Element</em>'.
	 * @see goalModel.IntentionalElement
	 * @generated
	 */
	EClass getIntentionalElement();

	/**
	 * Returns the meta object for the container reference '{@link goalModel.IntentionalElement#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Actor</em>'.
	 * @see goalModel.IntentionalElement#getActor()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_Actor();

	/**
	 * Returns the meta object for the containment reference list '{@link goalModel.IntentionalElement#getSrcLinks <em>Src Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Src Links</em>'.
	 * @see goalModel.IntentionalElement#getSrcLinks()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_SrcLinks();

	/**
	 * Returns the meta object for the reference list '{@link goalModel.IntentionalElement#getTrgLinks <em>Trg Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trg Links</em>'.
	 * @see goalModel.IntentionalElement#getTrgLinks()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_TrgLinks();

	/**
	 * Returns the meta object for class '{@link goalModel.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see goalModel.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the container reference '{@link goalModel.Link#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see goalModel.Link#getSrc()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Src();

	/**
	 * Returns the meta object for the reference list '{@link goalModel.Link#getTrgs <em>Trgs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trgs</em>'.
	 * @see goalModel.Link#getTrgs()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Trgs();

	/**
	 * Returns the meta object for class '{@link goalModel.GoalElement <em>Goal Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Element</em>'.
	 * @see goalModel.GoalElement
	 * @generated
	 */
	EClass getGoalElement();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see goalModel.GoalElement#getName()
	 * @see #getGoalElement()
	 * @generated
	 */
	EAttribute getGoalElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalElement#getElementName <em>Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Name</em>'.
	 * @see goalModel.GoalElement#getElementName()
	 * @see #getGoalElement()
	 * @generated
	 */
	EAttribute getGoalElement_ElementName();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalElement#getImportance <em>Importance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Importance</em>'.
	 * @see goalModel.GoalElement#getImportance()
	 * @see #getGoalElement()
	 * @generated
	 */
	EAttribute getGoalElement_Importance();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalElement#getConfidence <em>Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidence</em>'.
	 * @see goalModel.GoalElement#getConfidence()
	 * @see #getGoalElement()
	 * @generated
	 */
	EAttribute getGoalElement_Confidence();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalElement#getLocalValue <em>Local Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Value</em>'.
	 * @see goalModel.GoalElement#getLocalValue()
	 * @see #getGoalElement()
	 * @generated
	 */
	EAttribute getGoalElement_LocalValue();

	/**
	 * Returns the meta object for the containment reference list '{@link goalModel.GoalElement#getIterations <em>Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iterations</em>'.
	 * @see goalModel.GoalElement#getIterations()
	 * @see #getGoalElement()
	 * @generated
	 */
	EReference getGoalElement_Iterations();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalElement#getGlobalValue <em>Global Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global Value</em>'.
	 * @see goalModel.GoalElement#getGlobalValue()
	 * @see #getGoalElement()
	 * @generated
	 */
	EAttribute getGoalElement_GlobalValue();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.GoalElement#getEvaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Evaluation</em>'.
	 * @see goalModel.GoalElement#getEvaluation()
	 * @see #getGoalElement()
	 * @generated
	 */
	EAttribute getGoalElement_Evaluation();

	/**
	 * Returns the meta object for class '{@link goalModel.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see goalModel.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Contribution#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see goalModel.Contribution#getName()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Name();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Contribution#getContributionType <em>Contribution Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contribution Type</em>'.
	 * @see goalModel.Contribution#getContributionType()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_ContributionType();

	/**
	 * Returns the meta object for class '{@link goalModel.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see goalModel.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Dependency#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see goalModel.Dependency#getName()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Name();

	/**
	 * Returns the meta object for class '{@link goalModel.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see goalModel.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Iteration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see goalModel.Iteration#getName()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_Name();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Iteration#getIteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iteration</em>'.
	 * @see goalModel.Iteration#getIteration()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_Iteration();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Iteration#getImportance <em>Importance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Importance</em>'.
	 * @see goalModel.Iteration#getImportance()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_Importance();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Iteration#getConfidence <em>Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidence</em>'.
	 * @see goalModel.Iteration#getConfidence()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_Confidence();

	/**
	 * Returns the meta object for the container reference '{@link goalModel.Iteration#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Element</em>'.
	 * @see goalModel.Iteration#getElement()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Element();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Iteration#getGlobalValue <em>Global Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global Value</em>'.
	 * @see goalModel.Iteration#getGlobalValue()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_GlobalValue();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Iteration#getLocalValue <em>Local Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Value</em>'.
	 * @see goalModel.Iteration#getLocalValue()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_LocalValue();

	/**
	 * Returns the meta object for the containment reference list '{@link goalModel.Iteration#getValuefrom <em>Valuefrom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Valuefrom</em>'.
	 * @see goalModel.Iteration#getValuefrom()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Valuefrom();

	/**
	 * Returns the meta object for class '{@link goalModel.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see goalModel.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for class '{@link goalModel.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see goalModel.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for class '{@link goalModel.SoftGoal <em>Soft Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soft Goal</em>'.
	 * @see goalModel.SoftGoal
	 * @generated
	 */
	EClass getSoftGoal();

	/**
	 * Returns the meta object for class '{@link goalModel.Decomposition <em>Decomposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decomposition</em>'.
	 * @see goalModel.Decomposition
	 * @generated
	 */
	EClass getDecomposition();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.Decomposition#getDecompositionType <em>Decomposition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decomposition Type</em>'.
	 * @see goalModel.Decomposition#getDecompositionType()
	 * @see #getDecomposition()
	 * @generated
	 */
	EAttribute getDecomposition_DecompositionType();

	/**
	 * Returns the meta object for class '{@link goalModel.ValueFrom <em>Value From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value From</em>'.
	 * @see goalModel.ValueFrom
	 * @generated
	 */
	EClass getValueFrom();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.ValueFrom#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see goalModel.ValueFrom#getName()
	 * @see #getValueFrom()
	 * @generated
	 */
	EAttribute getValueFrom_Name();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.ValueFrom#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see goalModel.ValueFrom#getValue()
	 * @see #getValueFrom()
	 * @generated
	 */
	EAttribute getValueFrom_Value();

	/**
	 * Returns the meta object for the attribute '{@link goalModel.ValueFrom#getValueFrom <em>Value From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value From</em>'.
	 * @see goalModel.ValueFrom#getValueFrom()
	 * @see #getValueFrom()
	 * @generated
	 */
	EAttribute getValueFrom_ValueFrom();

	/**
	 * Returns the meta object for the container reference '{@link goalModel.ValueFrom#getIteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Iteration</em>'.
	 * @see goalModel.ValueFrom#getIteration()
	 * @see #getValueFrom()
	 * @generated
	 */
	EReference getValueFrom_Iteration();

	/**
	 * Returns the meta object for the reference '{@link goalModel.ValueFrom#getIntentionalelement <em>Intentionalelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intentionalelement</em>'.
	 * @see goalModel.ValueFrom#getIntentionalelement()
	 * @see #getValueFrom()
	 * @generated
	 */
	EReference getValueFrom_Intentionalelement();

	/**
	 * Returns the meta object for enum '{@link goalModel.EImportance <em>EImportance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EImportance</em>'.
	 * @see goalModel.EImportance
	 * @generated
	 */
	EEnum getEImportance();

	/**
	 * Returns the meta object for enum '{@link goalModel.EContribution <em>EContribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EContribution</em>'.
	 * @see goalModel.EContribution
	 * @generated
	 */
	EEnum getEContribution();

	/**
	 * Returns the meta object for enum '{@link goalModel.EConfidence <em>EConfidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EConfidence</em>'.
	 * @see goalModel.EConfidence
	 * @generated
	 */
	EEnum getEConfidence();

	/**
	 * Returns the meta object for enum '{@link goalModel.EDecomposition <em>EDecomposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDecomposition</em>'.
	 * @see goalModel.EDecomposition
	 * @generated
	 */
	EEnum getEDecomposition();

	/**
	 * Returns the meta object for enum '{@link goalModel.EValueFrom <em>EValue From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EValue From</em>'.
	 * @see goalModel.EValueFrom
	 * @generated
	 */
	EEnum getEValueFrom();

	/**
	 * Returns the meta object for enum '{@link goalModel.EEvaluation <em>EEvaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EEvaluation</em>'.
	 * @see goalModel.EEvaluation
	 * @generated
	 */
	EEnum getEEvaluation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GoalModelFactory getGoalModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link goalModel.impl.GoalModelImpl <em>Goal Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.GoalModelImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getGoalModel()
		 * @generated
		 */
		EClass GOAL_MODEL = eINSTANCE.getGoalModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_MODEL__NAME = eINSTANCE.getGoalModel_Name();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_MODEL__ACTORS = eINSTANCE.getGoalModel_Actors();

		/**
		 * The meta object literal for the '<em><b>Iteration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_MODEL__ITERATION = eINSTANCE.getGoalModel_Iteration();

		/**
		 * The meta object literal for the '{@link goalModel.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.ActorImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Goalmodel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__GOALMODEL = eINSTANCE.getActor_Goalmodel();

		/**
		 * The meta object literal for the '<em><b>Intentionalelements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INTENTIONALELEMENTS = eINSTANCE.getActor_Intentionalelements();

		/**
		 * The meta object literal for the '{@link goalModel.impl.IntentionalElementImpl <em>Intentional Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.IntentionalElementImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getIntentionalElement()
		 * @generated
		 */
		EClass INTENTIONAL_ELEMENT = eINSTANCE.getIntentionalElement();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTIONAL_ELEMENT__ACTOR = eINSTANCE.getIntentionalElement_Actor();

		/**
		 * The meta object literal for the '<em><b>Src Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTIONAL_ELEMENT__SRC_LINKS = eINSTANCE.getIntentionalElement_SrcLinks();

		/**
		 * The meta object literal for the '<em><b>Trg Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTIONAL_ELEMENT__TRG_LINKS = eINSTANCE.getIntentionalElement_TrgLinks();

		/**
		 * The meta object literal for the '{@link goalModel.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.LinkImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__SRC = eINSTANCE.getLink_Src();

		/**
		 * The meta object literal for the '<em><b>Trgs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TRGS = eINSTANCE.getLink_Trgs();

		/**
		 * The meta object literal for the '{@link goalModel.impl.GoalElementImpl <em>Goal Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.GoalElementImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getGoalElement()
		 * @generated
		 */
		EClass GOAL_ELEMENT = eINSTANCE.getGoalElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_ELEMENT__NAME = eINSTANCE.getGoalElement_Name();

		/**
		 * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_ELEMENT__ELEMENT_NAME = eINSTANCE.getGoalElement_ElementName();

		/**
		 * The meta object literal for the '<em><b>Importance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_ELEMENT__IMPORTANCE = eINSTANCE.getGoalElement_Importance();

		/**
		 * The meta object literal for the '<em><b>Confidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_ELEMENT__CONFIDENCE = eINSTANCE.getGoalElement_Confidence();

		/**
		 * The meta object literal for the '<em><b>Local Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_ELEMENT__LOCAL_VALUE = eINSTANCE.getGoalElement_LocalValue();

		/**
		 * The meta object literal for the '<em><b>Iterations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_ELEMENT__ITERATIONS = eINSTANCE.getGoalElement_Iterations();

		/**
		 * The meta object literal for the '<em><b>Global Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_ELEMENT__GLOBAL_VALUE = eINSTANCE.getGoalElement_GlobalValue();

		/**
		 * The meta object literal for the '<em><b>Evaluation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_ELEMENT__EVALUATION = eINSTANCE.getGoalElement_Evaluation();

		/**
		 * The meta object literal for the '{@link goalModel.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.ContributionImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getContribution()
		 * @generated
		 */
		EClass CONTRIBUTION = eINSTANCE.getContribution();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__NAME = eINSTANCE.getContribution_Name();

		/**
		 * The meta object literal for the '<em><b>Contribution Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__CONTRIBUTION_TYPE = eINSTANCE.getContribution_ContributionType();

		/**
		 * The meta object literal for the '{@link goalModel.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.DependencyImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__NAME = eINSTANCE.getDependency_Name();

		/**
		 * The meta object literal for the '{@link goalModel.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.IterationImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__NAME = eINSTANCE.getIteration_Name();

		/**
		 * The meta object literal for the '<em><b>Iteration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__ITERATION = eINSTANCE.getIteration_Iteration();

		/**
		 * The meta object literal for the '<em><b>Importance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__IMPORTANCE = eINSTANCE.getIteration_Importance();

		/**
		 * The meta object literal for the '<em><b>Confidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__CONFIDENCE = eINSTANCE.getIteration_Confidence();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__ELEMENT = eINSTANCE.getIteration_Element();

		/**
		 * The meta object literal for the '<em><b>Global Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__GLOBAL_VALUE = eINSTANCE.getIteration_GlobalValue();

		/**
		 * The meta object literal for the '<em><b>Local Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__LOCAL_VALUE = eINSTANCE.getIteration_LocalValue();

		/**
		 * The meta object literal for the '<em><b>Valuefrom</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__VALUEFROM = eINSTANCE.getIteration_Valuefrom();

		/**
		 * The meta object literal for the '{@link goalModel.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.GoalImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '{@link goalModel.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.TaskImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '{@link goalModel.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.SoftGoalImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getSoftGoal()
		 * @generated
		 */
		EClass SOFT_GOAL = eINSTANCE.getSoftGoal();

		/**
		 * The meta object literal for the '{@link goalModel.impl.DecompositionImpl <em>Decomposition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.DecompositionImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getDecomposition()
		 * @generated
		 */
		EClass DECOMPOSITION = eINSTANCE.getDecomposition();

		/**
		 * The meta object literal for the '<em><b>Decomposition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECOMPOSITION__DECOMPOSITION_TYPE = eINSTANCE.getDecomposition_DecompositionType();

		/**
		 * The meta object literal for the '{@link goalModel.impl.ValueFromImpl <em>Value From</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.impl.ValueFromImpl
		 * @see goalModel.impl.GoalModelPackageImpl#getValueFrom()
		 * @generated
		 */
		EClass VALUE_FROM = eINSTANCE.getValueFrom();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_FROM__NAME = eINSTANCE.getValueFrom_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_FROM__VALUE = eINSTANCE.getValueFrom_Value();

		/**
		 * The meta object literal for the '<em><b>Value From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_FROM__VALUE_FROM = eINSTANCE.getValueFrom_ValueFrom();

		/**
		 * The meta object literal for the '<em><b>Iteration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_FROM__ITERATION = eINSTANCE.getValueFrom_Iteration();

		/**
		 * The meta object literal for the '<em><b>Intentionalelement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_FROM__INTENTIONALELEMENT = eINSTANCE.getValueFrom_Intentionalelement();

		/**
		 * The meta object literal for the '{@link goalModel.EImportance <em>EImportance</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.EImportance
		 * @see goalModel.impl.GoalModelPackageImpl#getEImportance()
		 * @generated
		 */
		EEnum EIMPORTANCE = eINSTANCE.getEImportance();

		/**
		 * The meta object literal for the '{@link goalModel.EContribution <em>EContribution</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.EContribution
		 * @see goalModel.impl.GoalModelPackageImpl#getEContribution()
		 * @generated
		 */
		EEnum ECONTRIBUTION = eINSTANCE.getEContribution();

		/**
		 * The meta object literal for the '{@link goalModel.EConfidence <em>EConfidence</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.EConfidence
		 * @see goalModel.impl.GoalModelPackageImpl#getEConfidence()
		 * @generated
		 */
		EEnum ECONFIDENCE = eINSTANCE.getEConfidence();

		/**
		 * The meta object literal for the '{@link goalModel.EDecomposition <em>EDecomposition</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.EDecomposition
		 * @see goalModel.impl.GoalModelPackageImpl#getEDecomposition()
		 * @generated
		 */
		EEnum EDECOMPOSITION = eINSTANCE.getEDecomposition();

		/**
		 * The meta object literal for the '{@link goalModel.EValueFrom <em>EValue From</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.EValueFrom
		 * @see goalModel.impl.GoalModelPackageImpl#getEValueFrom()
		 * @generated
		 */
		EEnum EVALUE_FROM = eINSTANCE.getEValueFrom();

		/**
		 * The meta object literal for the '{@link goalModel.EEvaluation <em>EEvaluation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see goalModel.EEvaluation
		 * @see goalModel.impl.GoalModelPackageImpl#getEEvaluation()
		 * @generated
		 */
		EEnum EEVALUATION = eINSTANCE.getEEvaluation();

	}

} //GoalModelPackage
