/**
 */
package goalModel.tests;

import goalModel.GoalModelFactory;
import goalModel.SoftGoal;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Soft Goal</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SoftGoalTest extends IntentionalElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SoftGoalTest.class);
	}

	/**
	 * Constructs a new Soft Goal test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftGoalTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Soft Goal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SoftGoal getFixture() {
		return (SoftGoal)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GoalModelFactory.eINSTANCE.createSoftGoal());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SoftGoalTest
