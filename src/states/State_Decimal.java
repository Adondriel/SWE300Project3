package states;
public class State_Decimal implements State{

	// The State_Decimal's Singleton Storage
	private static State state;
	
	/**
	 * Initialize the State_Decimal State if it is not already initialized
	 * @return the initialized State_Decimal state [ Singleton ]
	 */
	public static State getState(){
		
		if( State_Decimal.state == null ){
			
			State_Decimal.state = new State_Decimal();
			
		}
		
		return State_Decimal.state;
	}
	
	/**
	 * Check the type of input that c is,
	 * Execute upon the context's values accordingly
	 * Change the context to its next state based upon c's data-type
	 */
	@Override
	public void execute( Context context , char c ){
		
		if( Character.isDigit( c ) ){
			
			// v = v + ( p * c )  &&  p = p / 10  &&  Next State => Decimal
			context.setValue( context.getValue() + ( context.getPoint() * Character.getNumericValue( c ) ) );
			context.setPoint( context.getPoint() / 10 );
			context.setCurrentState( State_Decimal.getState() );
			return;
			
		}else if( c == '\0' ){
			
				// v = v * s && Next State => End
				context.setValue( context.getSign() * context.getValue() );
			
		}else{
			
			// v = 0.0  &&  Next State => End
			context.setValue( 0 );
			
		}		
		
		// Next State => End
		context.setCurrentState( State_End.getState() );
	
	}

}
