package states;

public class StartState extends State {
	public StartState(Context context) {
		super(context);
	}

	@Override
	public State digit(char c) {
		myContext.setValue(c-'0');
		return myContext.getIntegerState();
	}
	
	public State positive() {
		myContext.setSign(1);
		return myContext.getIntegerState();
	}

	public State negative() {
		myContext.setSign(-1);
		return myContext.getIntegerState();
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

	@Override
	public State execute(int index){
		char myChar = myContext.getInput().charAt(index);
		if (Character.isDigit(myChar)){
			return digit(myChar);
		}
		else if (myChar == '+'){
			return positive();
		}
		else if (myChar == '-'){
			return negative();
		}
		else if (myChar == '.'){
			return decimal();
		}
		return other();
	}
}
