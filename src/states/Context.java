package states;

public class Context {
	private State startState = new StartState();
	private State integerState = new IntegerState();
	private State decimalState = new DecimalState();
	private State endState = new EndState();
	
	private State currentState = startState;
	
	public void execute(){
		//startState.execute(currentState);
		//todo
	}
	
}
