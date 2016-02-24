package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import states.Context;
import states.State_Integer;
/**
 * 
 * @author Adam Pine
 * Tests the methods of context.
 * Execute method is tested by the individual state tests.
 */
public class TestContext {
	/**
	 * Tests the setter and getter for currentstate method.
	 */
	@Test
	public void testContextSetAndGetCurrentState(){
		Context context = new Context();
		context.setCurrentState(State_Integer.getState());
		assertEquals(State_Integer.getState(), context.getCurrentState());
	}
	/**
	 * Tests the setter and getter for value.
	 */
	@Test
	public void testContextSetAndGetValue(){
		Context context = new Context();
		context.setValue(54.52);
		assertEquals(54.52, context.getValue(),0);
	}
	/**
	 * Tests the setter and getter for sign.
	 */
	@Test
	public void testContextSetAndGetSign(){
		Context context = new Context();
		context.setSign(-1);
		assertEquals(-1, context.getSign(),0);
	}
	/**
	 * Tests the getter and setter for place, which represents the current decimal place.
	 */
	@Test
	public void testContextSetAndGetPlace(){
		Context context = new Context();
		context.setPoint(0.001);
		assertEquals(0.001, context.getPoint(),0);
	}
}
