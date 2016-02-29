package states;

public class State_Start implements State{
	
	// The State_Start's Singleton Storage
	private static State state;
	
	/**
	 * Private constructor, to make this a singleton. does not actually have do anything.
	 */
	private State_Start(){
		
	}
	/**
	 * Initialize the State_Start State if it is not already initialized
	 * @return the initialized State_Start State [ Singleton ]
	 */
	public static State getState(){
		
		if( State_Start.state == null ){
			
			State_Start.state = new State_Start();
			
		}
		
		return State_Start.state;
	}
	
	
	@Override
	public void execute( Context context , char c ){

		if( Character.isDigit( c ) ){
			
			// v = c  &&  Next State => Integer
			context.setValue( Character.getNumericValue( c ) );
			context.setCurrentState( State_Integer.getState() );
			
		}else if( c == '-' ){
			
			// s = -1  &&  Next State => Integer
			context.setSign( -1 );
			context.setCurrentState( State_Integer.getState() );
				
		}else if( c == '+' ){
			
			// s = 1  &&  Next State => Integer
			context.setSign( 1 );
			context.setCurrentState( State_Integer.getState() );
				
		}else if( c == '.' ){
			
			// p = 0.1  &&  Next State => Decimal
			context.setPoint( 0.1 );
			context.setCurrentState( State_Decimal.getState() );
				
		}else{
			
			// v = 0.0  &&  Next State => End
			context.setValue( 0 );
			context.setCurrentState( State_End.getState() );
			
		}
		
	}

}