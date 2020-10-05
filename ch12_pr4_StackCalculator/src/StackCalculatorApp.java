
public class StackCalculatorApp {

	public static void main(String[] args) {

		// Creates a StackCalculator Object
		StackCalculator calculator = new StackCalculator();

		// Variable Declarations
		String response;
		double num = 0;

		// Output welcome message
		System.out.println("Welcome to the Stack Calculator.");

		do {

			// Prompts user to select an option
			response = Console.getString("\nCommands: push n, add, sub, mult, div, clear, or quit.");

			// Splits user response by a space for the push n command
			String[] tokens = response.split(" ");
			response = tokens[0];
			if (tokens.length > 1) {
				num = Double.parseDouble(tokens[1]);
			}

			// Calls the correct method based on the user response
			switch (response) {
			case "push":
				calculator.push(num);
				displayStack(calculator);
				break;
			case "add":
				calculator.add();
				displayStack(calculator);
				break;
			case "sub":
				calculator.subtract();
				displayStack(calculator);
				break;
			case "mult":
				calculator.multiply();
				displayStack(calculator);
				break;
			case "div":
				calculator.divide();
				displayStack(calculator);
				break;
			case "clear":
				calculator.clear();
				System.out.println("empty");
				break;
			case "quit":
				System.out.println("\nThanks for using the Stack Calculator.");
				break;
			default:
				System.out.println("\nPlease select a valid command.");
			}

		} while (!response.equalsIgnoreCase("quit"));

	}

	/**
	 * Display Stack takes in the stack calculator object and calls the getValues
	 * method that returns the stack as an array. This method outputs the values
	 * stored in the array.
	 * 
	 * @param calculator
	 */
	public static void displayStack(StackCalculator calculator) {
		double[] stack = calculator.getValues();
		for (double num : stack) {
			System.out.println(num);
		}
	}

}
