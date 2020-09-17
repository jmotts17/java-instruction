import java.util.Scanner;

public class GuessNumberApp {

	private static void displayWelcome(int limit) {
		System.out.println("Guess the number!");
		System.out.println("I'm thinking of a number from 1 to " + limit);
		System.out.println();
	}

	public static int getRandomInt(int limit) {
		double d = Math.random() * limit; // d is >= 0.0 and < limit
		int randomInt = (int) d; // convert double to int
		randomInt++; // int is >= 1 and <= limit
		return randomInt;
	}

	public static void main(String[] args) {
		final int LIMIT = 10;

		displayWelcome(LIMIT);
		int number = getRandomInt(LIMIT);

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int count = 1;
		int guess;

		while (true) {
			guess = getIntWithinRange(sc, "Your guess: ", 1, LIMIT);

//			try {
//				guess = sc.nextInt();
//			} catch (InputMismatchException e) {
//				System.out.println("Error! Invalid entry.");
//				sc.nextLine();
//				continue;
//			}

			if (guess < 1 || guess > LIMIT) {
				System.out.println("Invalid guess. Try again.");
				continue;
			}

			if (guess < number) {
				System.out.println("Too low.");
			} else if (guess > number) {
				System.out.println("Too high.");
			} else {
				System.out.println("You guessed it in " + count + " tries.\n");
				break;
			}
			count++;
		}
		System.out.println("Bye!");
	}

	/**
	 * Prompts the user for an integer between minInclusive and maxInclusive
	 * 
	 * @param sc
	 * @param prompt
	 * @param minInclusive
	 * @param maxInclusive
	 * @return
	 */
	public static int getIntWithinRange(Scanner sc, String prompt, int minInclusive, int maxInclusive) {
		boolean isValid = false;
		int retVal = 0;

		while (!isValid) {
			retVal = getInt(sc, prompt);

			if (retVal >= minInclusive && retVal <= maxInclusive) {
				isValid = true;
			} else {
				System.out.println("Value must be between " + minInclusive + " and " + maxInclusive + ".");
			}
		}

		return retVal;
	}

	public static int getInt(Scanner sc, String prompt) {
		int retVal = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				retVal = sc.nextInt();
				isValid = true;
				sc.nextLine();
			} else {
				System.out.println("Invalid entry");
				sc.nextLine();
			}
		}

		return retVal;
	}
}