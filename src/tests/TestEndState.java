package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import states.Context;
import states.State_End;
/**
 * @author Adam Pine
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
		context.execute('1');
		context.execute('0');
		context.execute('\0');
		context.execute('\0');
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(10, context.getValue(), 0);
		assertEquals(10.0, context.getValue(), 0);
	}
	/**
	 * 2. When there is mysteriously a value AFTER the null terminator. 
	 * This should not happen, if it does value goes to 0.
	 */
	@Test
	public void testEndState(){
		Context context = new Context();
		context.execute('1');
		context.execute('0');
		context.execute('\0');
		context.execute('5');
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}

}
