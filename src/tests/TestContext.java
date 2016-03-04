package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import states.Context;
import states.State_Decimal;
import states.State_End;
import states.State_Integer;
import states.State_Start;
/**
 * 
 * @author Adam Pine, Josh McMillen, and Benjamin Uleau
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
		assertEquals(54.52, context.getValue(), 0);
	}
	/**
	 * Tests the setter and getter for sign.
	 */
	@Test
	public void testContextSetAndGetSign(){
		Context context = new Context();
		context.setSign(-1);
		assertEquals(-1, context.getSign(), 0);
	}
	/**
	 * Tests the getter and setter for place, which represents the current decimal place.
	 */
	@Test
	public void testContextSetAndGetPlace(){
		Context context = new Context();
		context.setPoint(0.001);
		assertEquals(0.001, context.getPoint(), 0);
	}
	
	/**
	 * Tests the state process when context is fed a positive integer formatted string
	 */
	@Test
	public void testStateProcessPositiveInteger(){
		Context context = new Context();
		assertEquals( State_Start.getState() , context.getCurrentState());
		context.execute('1');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('2');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('\0');
		assertEquals( State_End.getState() , context.getCurrentState());
		assertEquals(12.00 , context.getValue(), 0);
	}
	
	/**
	 * Tests the state process when context is fed a negative integer formatted string
	 */
	@Test
	public void testStateProcessNegativeInteger(){
		Context context = new Context();
		assertEquals( State_Start.getState() , context.getCurrentState());
		context.execute('-');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('1');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('2');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('\0');
		assertEquals( State_End.getState() , context.getCurrentState());
		assertEquals(-12.0 , context.getValue(), 0);
	}
	
	/**
	 * Tests the state process when context is fed a positive integer ( with + ) formatted string
	 */
	@Test
	public void testStateProcessPositiveDecimal(){
		Context context = new Context();
		assertEquals( State_Start.getState() , context.getCurrentState());
		context.execute('+');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('1');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('.');
		assertEquals( State_Decimal.getState() , context.getCurrentState());
		context.execute('0');
		assertEquals( State_Decimal.getState() , context.getCurrentState());
		context.execute('\0');
		assertEquals( State_End.getState() , context.getCurrentState());
		assertEquals(1.0 , context.getValue(), 0);
	}
	
	/**
	 * Tests the state process when context is fed a negative decimal formatted string
	 */
	@Test
	public void testStateProcessNegativeDecimal(){
		Context context = new Context();
		assertEquals( State_Start.getState() , context.getCurrentState());
		context.execute('-');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('.');
		assertEquals( State_Decimal.getState() , context.getCurrentState());
		context.execute('0');
		assertEquals( State_Decimal.getState() , context.getCurrentState());
		context.execute('1');
		assertEquals( State_Decimal.getState() , context.getCurrentState());
		context.execute('\0');
		assertEquals( State_End.getState() , context.getCurrentState());
		assertEquals(-0.01 , context.getValue(), 0);
	}
	
	/**
	 * Tests the state process when context is fed a negative decimal formatted string
	 */
	@Test
	public void testStateProcessNonIntegerInput(){
		Context context = new Context();
		assertEquals( State_Start.getState() , context.getCurrentState());
		context.execute('1');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('2');
		assertEquals( State_Integer.getState() , context.getCurrentState());
		context.execute('a');
		assertEquals( State_End.getState() , context.getCurrentState());
		context.execute('\0');
		assertEquals( State_End.getState() , context.getCurrentState());
		assertEquals(0.0 , context.getValue(), 0);
	}
}
