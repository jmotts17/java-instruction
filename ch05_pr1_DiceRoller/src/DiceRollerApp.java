import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Output Welcome Message
		System.out.println("Dice Roller\n");

		// Call prompt method and store result in choice variable
		String choice = prompt(scanner, "Roll the dice? (y/n): ");

		// Loop continues as long as user enters "y"
		while (choice.equalsIgnoreCase("y")) {
			// Call rollDice method
			rollDice();

			// Call prompt method and store result in choice variable
			choice = prompt(scanner, "\nRoll the dice? (y/n): ");
		}

	}

	// Prompt Method - Prompts the user to roll the dice.
	// This method verifies that the user entered valid data.
	public static String prompt(Scanner scanner, String prompt) {

		String choice;

		do {
			System.out.print(prompt);
			choice = scanner.next();
		} while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

		return choice;
	}

	// rollDice Method - Creates 2 dice and outputs the results.
	public static void rollDice() {

		int die1 = (int) (Math.random() * 6) + 1;
		int die2 = (int) (Math.random() * 6) + 1;

		System.out.println("\nDie 1: " + die1);
		System.out.println("Die 2: " + die2);
		System.out.println("Total: " + (die1 + die2));

		if (die1 == 1 && die2 == 1) {
			System.out.println("Snake Eyes!");
		} else if (die1 == 6 && die2 == 6) {
			System.out.println("Boxcars!");
		}

	}

}
