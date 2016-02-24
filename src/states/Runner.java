package states;
import java.util.Scanner;

public class Runner{
	
	// Store User Input Into This Character Array
	private static char[] inputChars;
	
	
	public static void main( String args[] ){
		
		// Scan user Input after prompting, then convert string to a character
		// array, appending the NULL Character [ '\0' ] into the final array slot
		Scanner userInput;
		
		try{
			
			userInput = new Scanner( System.in );	
			
		}catch( Exception e ){
			
			userInput = null;
			
		}
		
		System.out.print("Please Enter Value: ");
		
		inputChars = (userInput.nextLine()+'\0').toCharArray();
		
		
		// Create a new context, and then iterate through the character array inputChars,
		// executing the context's execute on the character at each position
		Context context = new Context(  );

		for( int i = 0; i < inputChars.length; i++ ){
			
			context.execute( inputChars[ i ] );
			
		}
		
		System.out.println( context.getValue() );
		
	}
	
}
