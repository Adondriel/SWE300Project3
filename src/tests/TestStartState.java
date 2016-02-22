package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import states.Context;
import states.State_Decimal;
import states.State_End;
import states.State_Integer;
public class TestStartState {
	@Test
	public void testStartStateDecimal(){
		Context context = new Context();
		context.execute('.');
		assertEquals(State_Decimal.getState(), context.getCurrentState());
	}
	@Test
	public void testStartStatePos(){
		Context context = new Context();
		context.execute('+');
		assertEquals(State_Integer.getState(), context.getCurrentState());
		assertEquals(1, context.getSign());
	}
	@Test
	public void testStartStateNeg(){
		Context context = new Context();
		context.execute('-');
		assertEquals(State_Integer.getState(), context.getCurrentState());
		assertEquals(-1, context.getSign());
	}
	@Test
	public void testStartStateOther(){
		Context context = new Context();
		context.execute('a');
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}
	@Test
	public void testStartStateDigit(){
		Context context = new Context();
		context.execute('5');
		assertEquals(State_Integer.getState(), context.getCurrentState());
		assertEquals('5'-'0', context.getValue(), 0);
	}
}
