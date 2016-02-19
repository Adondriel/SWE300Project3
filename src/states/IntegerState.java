package states;

public class IntegerState extends State {

	public IntegerState(Context context) {
		super(context);
	}

	@Override
	public State execute(int index) {
		char myChar = myContext.getInput().charAt(index);
		if (Character.isDigit(myChar)){
			return digit(myChar);
		}
		else if (myChar == '.'){
			return decimal();
		}
		else if (myChar == '\0'){
			return nullTerminator();
		}
		return other();
	}

	@Override
	public State digit(char c) {
		double value = myContext.getValue();
		myContext.setValue(10 * value + (c - '0'));
		return myContext.getIntegerState();
	}

	
	public State nullTerminator() {
		myContext.setValue(myContext.getSign() * myContext.getValue());
		return myContext.getEndState();
	}

	@Override
	public State decimal() {
		myContext.setDecimalPlace(0.1);
		return myContext.getDecimalState();
	}
	
	@Override
	public State other() {
		myContext.setValue(0);
		return myContext.getEndState();
	}

	
}
