import java.util.Scanner;

public class GuessingGameApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Output Welcome Message
		welcomeMessage();

		// Declare and Initialize Variables
		String message = "", choice;

		do {
			// These variables are inside the loop as they need reset each iteration
			int randomNum = (int) (Math.random() * 100) + 1;
			int guess = 0, count = 0;

			// Iterates until the user guesses the random number
			while (guess != randomNum) {
				guess = getInt(scanner, "\nEnter number: "); // Call getInt method
				message = hint(guess, randomNum); // Call hint method
				count++; // Add 1 to count per guess

				// If-Else determines message output
				if (guess == randomNum) {
					System.out.println(message + count + " tries.");
					System.out.println(winner(count));
					scanner.nextLine();
				} else {
					System.out.println(message);
				}
			}

			choice = prompt(scanner, "\nTry again? (y/n): "); // Call the prompt method
		} while (choice.equalsIgnoreCase("y"));

	}

	// WelcomeMessage Method - Does not take anything in or return anything.
	// This method only outputs a welcome message to the user at the beginning of
	// the program.
	public static void welcomeMessage() {
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println("\nI'm thinking of a number from 1 to 100.");
		System.out.println("Try to guess it.");
	}

	// Prompt Method - Takes in a scanner & string and returns a string.
	// This method prompts the user to see if they want to continue play the game.
	// This method validates the data by only returning y or n.
	public static String prompt(Scanner scanner, String prompt) {
		String choice;

		do {
			System.out.print(prompt);
			choice = scanner.nextLine();
		} while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

		return choice;
	}

	// GetInt Method - Takes in a scanner & string and returns an int.
	// This method prompts the user to input an integer.
	// This method validates the data by only returning an integer b/w 1-100.
	public static int getInt(Scanner scanner, String prompt) {

		int guess = 0;
		boolean isValid = false;

		do {
			System.out.print(prompt);
			if (scanner.hasNextInt()) {
				guess = scanner.nextInt();
				if (guess < 1 || guess > 100) {
					System.out.println("Please enter a number 1-100.");
				} else {
					isValid = true;
				}
			} else {
				System.out.println("Invalid Entry.");
				scanner.next();
			}
		} while (!isValid);

		return guess;
	}

	// Hint Method - Takes in 2 integers and returns a string.
	// This method takes the users guess and randomNum and returns a string with
	// a hint based on how high/low they are from the random number.
	public static String hint(int guess, int randomNum) {
		if (guess > randomNum) {
			if ((guess - randomNum) > 10) {
				return "Way too high";
			} else if ((guess - randomNum) < 10) {
				return "Too high";
			}
		} else if (randomNum > guess) {
			if ((randomNum - guess) > 10) {
				return "Way too low";
			} else if ((randomNum - guess) < 10) {
				return "Too low";
			}
		}

		return "You got it in ";

	}

	// Winner Method - Takes in an integer and returns a string.
	// This method returns a message based on the count in the main method.
	public static String winner(int count) {
		if (count <= 3) {
			return "Great Work! You are a mathematical wizard.";
		} else if (count > 3 && count <= 7) {
			return "Not too bad! You've got some potential.";
		} else {
			return "What took you so long? Maybe you should take some lessons.";
		}
	}
}
