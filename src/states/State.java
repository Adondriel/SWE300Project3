package states;

public abstract class State {
	Context myContext;
	public State(Context context){
		myContext = context;
	}
	public abstract State execute(int index);
	
	public abstract State digit(char c);
	
	//public abstract State positive();
	
	//public abstract State negative();
	
	public abstract State decimal();
	
	public abstract State other();
	
	//public abstract State nullTerminator();
}
