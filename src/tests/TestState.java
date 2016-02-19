package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import states.Context;

public class TestState {
	private Context myContext;
	@Before
	public void doBefore(){
		myContext = new Context("-12.34");
	}
	@Test
	public void testStartStateDigit(){
		myContext.execute();
		myContext.execute();
		myContext.execute();
		myContext.execute();
		myContext.execute();
		myContext.execute();
		myContext.execute();


	}
}
