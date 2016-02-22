package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import states.Context;
import states.State_Decimal;
import states.State_End;
import states.State_Integer;
public class TestIntegerState {
	@Test
	public void testIntegerStateNullTerminator(){
		Context context = new Context();
		context.execute('\0');
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}
	@Test
	public void testIntegerStateDecimal(){
		Context context = new Context();
		context.execute('.');
		assertEquals(State_Decimal.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}
	@Test
	public void testIntegerStateDigit(){
		Context context = new Context();
		context.execute('5');
		assertEquals(State_Integer.getState(), context.getCurrentState());
		assertEquals('5'-'0', context.getValue(), 0);
		context.execute('0');
		assertEquals(50, context.getValue(), 0);
	}
	@Test
	public void testIntegerStateOther(){
		Context context = new Context();
		context.execute('a');
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}
}
