/**
 */
package goalModel.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>goalModel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class GoalModelTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new GoalModelTests("goalModel Tests");
		suite.addTestSuite(ActorTest.class);
		suite.addTestSuite(ContributionTest.class);
		suite.addTestSuite(DependencyTest.class);
		suite.addTestSuite(IterationTest.class);
		suite.addTestSuite(GoalTest.class);
		suite.addTestSuite(TaskTest.class);
		suite.addTestSuite(SoftGoalTest.class);
		suite.addTestSuite(ValueFromTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalModelTests(String name) {
		super(name);
	}

} //GoalModelTests
