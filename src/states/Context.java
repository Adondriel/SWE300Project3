package states;

public class Context {
	private State startState = null;
	private State integerState = null;
	private State decimalState = null;
	private State endState = null;
	private State currentState = null;
	
	private double sign = 0;
	private double value = 0;
	private double decimalPlace = 0;
	private String input = null;
	private int inputIndex = 0;
	
	public Context(String input){
		this.input = input;

		startState = new StartState(this);
		integerState = new IntegerState(this);
		decimalState = new DecimalState(this);
		endState = new EndState(this);
		currentState = startState;
	}
	
	public void execute(){
		if (inputIndex >= input.length()){
			endState.execute(inputIndex);
		}else{
			currentState = currentState.execute(inputIndex);
			System.out.println("S = " + sign);
			System.out.println("V = " + value);
			System.out.println("P = " + decimalPlace);
			inputIndex++;
		}
	}
	public double getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getDecimalPlace() {
		return decimalPlace;
	}
	public void setDecimalPlace(double decimalPlace) {
		this.decimalPlace = decimalPlace;
	}
	public State getStartState() {
		return startState;
	}
	public State getIntegerState() {
		return integerState;
	}
	public State getDecimalState() {
		return decimalState;
	}
	public State getEndState() {
		return endState;
	}
	public State getCurrentState() {
		return currentState;
	}
	public String getInput() {
		return input;
	}
	
	
	
}
