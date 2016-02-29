package states;

public class State_End implements State{
	
	// The State_Ends's Singleton Storage
	private static State state;
	
	/**
	 * Private constructor, to make this a singleton. does not actually have do anything.
	 */
	private State_End(){
		
	}
	/**
	 * Initialize the State_End State if it is not already initialized
	 * @return the initialized State_End State [ Singleton ]
	 */
	public static State getState(){
		
		if( State_End.state == null ){
			
			State_End.state = new State_End();
			
		}
		
		return State_End.state;
	}
	
	/**
	 * Check the type of input that c is,
	 * If c is not a null character, then there is an error in logic and the context's value should be 0.0
	 * Otherwise, State_End's execute should do nothing
	 */
	@Override
	public void execute( Context context , char c ){
		
		if( c == '\0'){
			
			return;
			
		}else{
			
			context.setValue( 0 );
			
		}
		
	}

}
