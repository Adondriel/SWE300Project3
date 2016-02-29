package states;

public class State_Integer implements State{

	// The State_Integer's Singleton Storage
	private static State state;
	/**
	 * Private constructor, to make this a singleton. does not actually have do anything.
	 */
	private State_Integer(){
		
	}
	/**
	 * Initialize the State_Integer State if it is not already initialized
	 * @return the initialized State_Integer State [ Singleton ]
	 */
	public static State getState(){
		
		if( State_Integer.state == null ){
			
			State_Integer.state = new State_Integer();
			
		}
		
		return State_Integer.state;
	}
	
	/**
	 * Check the type of input that c is,
	 * Execute upon the context's values accordingly
	 * Change the context to its next state based upon c's data-type
	 */
	@Override
	public void execute( Context context , char c ){
		
		if( Character.isDigit( c ) ){
			
			// v = ( v * 10 ) + c  &&  Next State => Integer
			context.setValue( ( 10 * context.getValue() ) + Character.getNumericValue( c ) );
			context.setCurrentState( State_Integer.getState() );
			return;
			
		}else if( c == '.' ){
			
				// p = 0.1  &&  Next State => Decimal
				context.setPoint( 0.1 );
				context.setCurrentState( State_Decimal.getState() );
				return;
				
		}else if( c == '\0' ){
			
			// v = v * s  &&  Next State => End
			context.setValue( context.getSign() * context.getValue() );
			context.setCurrentState( State_End.getState() );
			return;
			
		}else{
			
			// v = 0.0  &&  Next State => End
			context.setValue( 0 );
			context.setCurrentState( State_End.getState() );
			
		}
		
	}

}
