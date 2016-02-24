package states;
public class Context {

	// Context's Current State
	private State state;
	
	// Context's Current Sign
	private int sign;
	
	// Context's Current Value and Pointer Position
	private double value, point;

	/**
	 * Initialize context's variables
	 * -- State => State_Start
	 * -- Sign => 1
	 * -- Value => 0.0
	 * -- Point => 1.0
	 */
	public Context() {
		this.state = State_Start.getState();
		this.setSign(1);
		this.setValue(0.0);
		this.setPoint(1.0);
	}

	/**
	 * Execute the context's current state's execute method
	 * @param c execute current state's execute method on c and this context
	 */
	public void execute(char c) {
		state.execute(this, c);
	}

	/**
	 * Set the current state of the context
	 * @param state set this.state as type [ Start , Integer , Decimal , or End ] state
	 */
	public void setCurrentState(State state) {
		this.state = state;
	}

	/**
	 * Get the current state of the context
	 * @return state where state is of [ Start , Integer , Decimal , or End ] state type
	 */
	public State getCurrentState() {
		return state;
	}

	/**
	 * Get context's current value
	 * @return value return double value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Set context's current value
	 * @param value set this.value to double value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Get context's current sign 
	 * @return sign return either -1 or 1
	 */
	public int getSign() {
		return sign;
	}

	/**
	 * Set context's current sign
	 * @param sign set this.sign to either -1 or 1
	 */
	public void setSign(int sign) {
		this.sign = sign;
	}

	/**
	 * Get context's current pointer position
	 * @return point return a double value 
	 * 		between 10000000000000000.0 and 0.00000000000000001 -- Default Value 1.0
	 */
	public double getPoint() {
		return point;
	}

	/**
	 * Set context's current pointer position
	 * @param point set this.value to double value 
	 * 		between 10000000000000000.0 and 0.00000000000000001 -- Default Value 1.0
	 */
	public void setPoint(double point) {
		this.point = point;
	}
}
