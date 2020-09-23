
public class NumberCheckerApp {

	public static void main(String[] args) {

		// Create MyConsole object
		MyConsole console = new MyConsole();

		// Variable declaration
		String choice;

		// Output welcome message
		System.out.println("Welcome to the Odd/Even Checker!");

		do {
			int number = console.getInt("\nEnter an integer: "); // Call getInt method and store in number varaible

			// Verifies and outputs if the number is even / odd
			if (number % 2 == 0) {
				System.out.println("The number " + number + " is even.");
			} else {
				System.out.println("The number " + number + " is odd.");
			}

			// Prompt user to continue
			choice = console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

	}

}
