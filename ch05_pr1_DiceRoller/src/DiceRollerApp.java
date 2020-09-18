import java.util.Scanner;

class DiceRollerApp {

	public static void main(String[] args) {

		// Output Welcome Message
		System.out.println("Dice Roller");

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Variable Declaration
		final String MESSAGE = "Roll the dice? (y/n): ";
		String response = prompt(scanner, MESSAGE);

		while (response.equalsIgnoreCase("y")) {
			// Create 2 variables to store the return from rollDice
			int dice1 = rollDice();
			int dice2 = rollDice();

			// Calls the outputResults method
			outputResults(dice1, dice2);

			// Calls the prompt method
			response = prompt(scanner, MESSAGE);
		}
	}

	/**
	 * Prompt - Outputs a prompt to use the user and validates the users entry.
	 * 
	 * @param scanner
	 * @param message
	 * @return String
	 */
	private static String prompt(Scanner scanner, String message) {
		String response;

		do {
			System.out.print("\n" + message);
			response = scanner.next();
		} while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n"));

		return response;

	}

	/**
	 * RollDice calculates and returns a number 1-6.
	 * 
	 * @return int
	 */
	private static int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	/**
	 * OutputResults outputs the results of the dice rolls, the total and a message
	 * if the user rolls 2 1's or 2 6's.
	 * 
	 * @param dice1
	 * @param dice2
	 */
	private static void outputResults(int dice1, int dice2) {

		System.out.println("\nDice 1: " + dice1);
		System.out.println("Dice 2: " + dice2);
		System.out.println("Total:  " + (dice1 + dice2));

		if (dice1 == 1 && dice2 == 1) {
			System.out.println("Snake Eyes!");
		} else if (dice1 == 6 && dice2 == 6) {
			System.out.println("Boxcars!");
		}

	}
}