package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import states.Context;
import states.State_End;
/**
 * @author Adam Pine, Josh McMillen, and Benjamin Uleau
 * Tests for the end state.
 */
public class TestEndState {
	/**
	 * The only reason we should be executing anything in the end state is if we have either of these conditions:
	 * 1. Two null terminators
	 */
	@Test
	public void testEndStateDoubleNullTerminator(){
		Context context = new Context();
		//Insert a value, in this case we are using 10, to ensure the value is kept. even with two nullterminators.
		context.execute('1');
		context.execute('0');
		//Enter double nullterminator.
		context.execute('\0');
		//Check the value before the second null terminator.
		assertEquals(10.0, context.getValue(), 0);
		context.execute('\0');
		//Should stay in end state.
		assertEquals(State_End.getState(), context.getCurrentState());
		//Value should stay the same.
		assertEquals(10.0, context.getValue(), 0);
	}
	/**
	 * 2. When there is somehow a value AFTER the null terminator. 
	 * This should not happen, if it does value goes to 0.
	 */
	@Test
	public void testEndState(){
		Context context = new Context();
		//Using the value 10 again
		context.execute('1');
		context.execute('0');
		context.execute('\0');
		//Insert a value AFTER the null terminator, this should reset the value, because this should not be happening,
		//something went wrong, somewhere.
		context.execute('5');
		//Stay in end state.
		assertEquals(State_End.getState(), context.getCurrentState());
		//Value should be 0.
		assertEquals(0, context.getValue(), 0);
	}

}
