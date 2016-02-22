package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import states.Context;
import states.State_Decimal;
import states.State_End;
import states.State_Integer;
public class TestDecimalState {
	@Test
	public void testDecimalStateDigit(){
		Context context = new Context();
		//get the context into decimal state, by inputing a .
		context.execute('.');
		assertEquals(State_Decimal.getState(), context.getCurrentState());
		assertEquals(0.1, context.getPoint(), 0);
		//Enter a digit char, '5' making the current value .5
		context.execute('5');
		assertEquals(0.01, context.getPoint(), 0);
		assertEquals(0.5, context.getValue(), 0);
		//Now enter another char '4', this should make the value .54.
		context.execute('4');
		assertEquals(0.001, context.getPoint(), 0);
		assertEquals(0.54, context.getValue(), 0);
	}
	@Test
	public void testDecimalStateOther(){
		Context context = new Context();
		context.execute('.');
		context.execute('a');
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0, context.getValue(), 0);
	}
	@Test
	public void testDecimalStateNullTerminator(){
		Context context = new Context();
		context.execute('.');
		context.execute('5');
		context.execute('4');
		context.execute('\0');
		assertEquals(State_End.getState(), context.getCurrentState());
		assertEquals(0.54, context.getValue(), 0);
	}
}
