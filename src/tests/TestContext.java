package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import states.Context;
import states.State_Integer;

public class TestContext {
	//Context Execute method is tested by each state's tests.
	@Test
	public void testContextSetAndGetCurrentState(){
		Context context = new Context();
		context.setCurrentState(State_Integer.getState());
		assertEquals(State_Integer.getState(), context.getCurrentState());
	}
	
	@Test
	public void testContextSetAndGetValue(){
		Context context = new Context();
		context.setValue(54.52);
		assertEquals(54.52, context.getValue(),0);
	}
	
	@Test
	public void testContextSetAndGetSign(){
		Context context = new Context();
		context.setSign(-1);
		assertEquals(-1, context.getSign(),0);
	}
	
	@Test
	public void testContextSetAndGetPlace(){
		Context context = new Context();
		context.setPoint(0.001);
		assertEquals(0.001, context.getPoint(),0);
	}
}
