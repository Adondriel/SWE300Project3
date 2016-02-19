package states;

public class EndState extends State{

	public EndState(Context context) {
		super(context);
	}

	@Override
	public State execute(int index) {
		System.out.println("The value of '" + myContext.getInput() + "' is: " + myContext.getValue());
		return myContext.getEndState();
	}

	@Override
	public State digit(char c) {
		//do nothing.
		return null;
	}

	@Override
	public State decimal() {
		//do nothing.
		return null;
	}

	@Override
	public State other() {
		//do nothing.
		return null;
	}


}
