package states;

public class DecimalState extends State{

	public DecimalState(Context context) {
		super(context);
	}

	@Override
	public State execute(int index) {
		char myChar = myContext.getInput().charAt(index);
		if (Character.isDigit(myChar)){
			return digit(myChar);
		}
		else if (myChar == '\0'){
			return nullTerminator();
		}
		return other();
	}

	@Override
	public State digit(char c) {
		double v = myContext.getValue();
		double p = myContext.getDecimalPlace();
		v += p * (c-'0');
		p /= 10;
		myContext.setValue(v);
		myContext.setDecimalPlace(p);
		return myContext.getDecimalState();
	}
	
	public State nullTerminator() {
		myContext.setValue(myContext.getSign() * myContext.getValue());
		return myContext.getEndState();
	}
	
	@Override
	public State other() {
		myContext.setValue(0);
		return myContext.getEndState();
	}
	@Override
	public State decimal() {
		//do nothing
		return null;
	}


}
