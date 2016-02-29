package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import states.Context;
import states.State_Decimal;
import states.State_End;
import states.State_Integer;
/**
 * 
 * @author Adam Pine
 * Tests for the Start State
 */
public class TestStartState {
	/**
	 * Tests the start state for a digit input.
	 */
	@Test
	public void testStartStateDigit(){
		Context context = new Context();
		//Input that char 5.
		context.execute('5');
		//Currentstate should be integer state.
		assertEquals(State_Integer.getState(), context.getCurrentState());
		//Value should be 5
		assertEquals(5.0, context.getValue(), 0);
	}
	/**
	 * Tests the start state for a decimal input.
	 */
	@Test
	public void testStartStateDecimal(){
		Context context = new Context();
		//Input a '.'
		context.execute('.');
		//The state should be decimal state.
		assertEquals(State_Decimal.getState(), context.getCurrentState());
	}
	/**
	 * Tests the start state for a + sign.
	 */
	@Test
	public void testStartStatePos(){
		Context context = new Context();
		//Input the character '+'
		context.execute('+');
		//State should be integer
		assertEquals(State_Integer.getState(), context.getCurrentState());
		//Sign should be 1.
		assertEquals(1, context.getSign());
	}
	/**
	 * Tests the start state for a - sign.
	 */
	@Test
	public void testStartStateNeg(){
		Context context = new Context();
		//Input the character '-'
		context.execute('-');
		//State should be integer state.
		assertEquals(State_Integer.getState(), context.getCurrentState());
		//Sign should be changed to -1.
		assertEquals(-1, context.getSign());
	}
	/**
	 * Tests the start state for anything that is not a valid input.
	 */
	@Test
	public void testStartStateOther(){
		Context context = new Context();
		//Input an invalid character, in this case 'a'
		context.execute('a');
		//state should be end.
		assertEquals(State_End.getState(), context.getCurrentState());
		//value should be 0.
		assertEquals(0, context.getValue(), 0);
	}

}
