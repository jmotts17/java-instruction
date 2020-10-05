import java.util.LinkedList;

public class StackCalculator {

	// Field declaration
	private LinkedList<Double> calculator;

	// Default constructor
	public StackCalculator() {
		calculator = new LinkedList<>();
	}

	// Adds a double to the top of the stack
	public void push(double x) {
		calculator.addFirst(x);
	}

	// Removes/returns a double from the top of the stack
	public double pop() {
		return calculator.remove();
	}

	// Adds the top 2 values of the stack and pushes the sum to the top
	public void add() {
		double val1 = this.pop();
		double val2 = this.pop();
		double sum = val1 + val2;
		push(sum);
	}

	// Subtracts the top 2 values of the stack and pushes the difference to the top
	public void subtract() {
		double val1 = this.pop();
		double val2 = this.pop();
		double difference = val1 - val2;
		push(difference);
	}

	// Multiplies the top 2 values of the stack and pushes the product to the top
	public void multiply() {
		double val1 = this.pop();
		double val2 = this.pop();
		double product = val1 * val2;
		push(product);
	}

	// Divides the top 2 values of the stack and pushes the quotient to the top
	public void divide() {
		double val1 = this.pop();
		double val2 = this.pop();
		double quotient = val1 / val2;
		push(quotient);
	}

	// Clears the stack
	public void clear() {
		calculator.clear();
	}

	// Stores the values of the stack in an array and returns it
	public double[] getValues() {
		double[] calcArray = new double[calculator.size()];

		for (int i = 0; i < calculator.size(); i++) {
			calcArray[i] = calculator.get(i);
		}

		return calcArray;
	}

	// Returns the size of the stack
	public int size() {
		return calculator.size();
	}

}
