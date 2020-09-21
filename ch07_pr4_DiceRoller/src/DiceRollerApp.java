
public class DiceRollerApp {

	public static void main(String[] args) {

		// Output welcome message
		System.out.println("Welcome to the Dice Roller!");

		// Declare choice variable
		String choice;

		// Prompt user to roll the dice
		choice = Console.getString("\nRoll the dice? (y/n): ", "y", "n");

		while (!choice.equalsIgnoreCase("n")) {
			// Create dice object
			Dice dice = new Dice();
			// Roll the dice
			dice.roll();
			// Output results
			dice.printRoll();

			// Prompt user to continue
			choice = Console.getString("\nRoll again? (y/n): ", "y", "n");
		}

	}

}
