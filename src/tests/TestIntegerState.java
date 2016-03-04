package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import states.Context;
import states.State_Decimal;
import states.State_End;
import states.State_Integer;
/**
 * 
 * @author Adam Pine, Josh McMillen, and Benjamin Uleau
 * Tests for the integer state.
 */
public class TestIntegerState {
	/**
	 * Tests the integer state for null terminator.
	 */
	@Test
	public void testIntegerStateNullTerminator(){
		Context context = new Context();
		//Make the start state enter the integer state.
		context.execute('1');
		//Input a null terminator.
		context.execute('\0');
		//Test that the state is now end state.
		assertEquals(State_End.getState(), context.getCurrentState());
		//Value should be 1.0
		assertEquals(1.0, context.getValue(), 0);

	}
	/**
	 * Tests the integer state for a decimal input.
	 */
	@Test
	public void testIntegerStateDecimal(){
		Context context = new Context();
		//Make start state enter the integer state.
		context.execute('1');
		//Enter a '.' to enter decimal state.
		context.execute('.');
		//State should now be decimal state, and value should be 1.0.
		assertEquals(State_Decimal.getState(), context.getCurrentState());
		assertEquals(1.0, context.getValue(), 0);

	}
	/**
	 * Tests the integer state for a digit input.
	 */
	@Test
	public void testIntegerStateDigit(){
		Context context = new Context();
		//Put the start state into integer state.
		context.execute('5');
		//input another digit to make sure that putting in another integer does correct behavior.
		context.execute('0');
		//Currentstate should remain in integer state.
		assertEquals(State_Integer.getState(), context.getCurrentState());
		//the value should be 50.
		assertEquals(50.0, context.getValue(), 0);
	}
	/**
	 * Test the integer state for other input.
	 */
	@Test
	public void testIntegerStateOther(){
		Context context = new Context();
		//Make the start state enter integer state.
		context.execute('1');
		//Input an invalid character
		context.execute('a');
		//State should change to end state, and value should be 0 because it is an invalid input.
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}
}
