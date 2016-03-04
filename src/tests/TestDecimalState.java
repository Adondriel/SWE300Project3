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
 * Tests for the Decimal State
 */
public class TestDecimalState {
	/**
	 * Test the decimal state for input of a digit value.
	 */
	@Test
	public void testDecimalStateDigit(){
		Context context = new Context();
		//get the context into decimal state, by inputing a .
		context.execute('.');
		assertEquals(State_Decimal.getState(), context.getCurrentState());
		assertEquals(0.1, context.getPoint(), 0);
		//Enter a digit char, '5' making the current value .5
		context.execute('5');
		//current decimal place should be 0.01.
		assertEquals(0.01, context.getPoint(), 0);
		assertEquals(0.5, context.getValue(), 0);
		//Now enter another char '4', this should make the value .54.
		context.execute('4');
		//current decimal place should now be .001.
		assertEquals(0.001, context.getPoint(), 0);
		assertEquals(0.54, context.getValue(), 0);
	}
	/**
	 * Test the decimal state for other inputs.
	 */
	@Test
	public void testDecimalStateOther(){
		Context context = new Context();
		//enter a . to put the state into decimal state.
		context.execute('.');
		//insert and invalid character, causing Other behavior.
		context.execute('a');
		//State should now be end state, and value should be 0.
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}
	/**
	 * Test the decimal state for null terminator.
	 */
	@Test
	public void testDecimalStateNullTerminator(){
		Context context = new Context();
		//Enter . to put the start state into decimal state.
		context.execute('.');
		//Enter a digit so that we have a value.	
		context.execute('5');
		//Enter another digit for more precision.
		context.execute('4');
		//Enter a null terminator, to make the decimal state go to the endstate.
		context.execute('\0');
		//State should now be end state, and value should be 0.54.
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0.54, context.getValue(), 0);
	}
}
