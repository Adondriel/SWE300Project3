package states;
/**
 * 
 * @author Adam Pine, Josh McMillen, and Benjamin Uleau
 * 
 * */
public interface State{
	
	// State's Inheritable Execute Method
	public void execute( Context context , char c );	
	
}
