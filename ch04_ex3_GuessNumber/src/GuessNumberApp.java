import java.util.Scanner;

public class GuessNumberApp {

	private static void displayWelcome(int limit) {
		System.out.println("Guess the number!");
		System.out.println("I'm thinking of a number from 1 to " + limit);
		System.out.println();
	}

	/**
	 * Returns a random integer between 1 and limit
	 */
	private static int getRandomInt(int limit) {
		// get a random number between 1 and the limit
		double d = Math.random() * limit; // d is >= 0.0 and < limit
		int number = (int) d; // convert double to int
		number++; // int is >= 1 and <= limit
		return number;
	}

	public static void main(String[] args) {
		final int LIMIT = 10;

		displayWelcome(LIMIT);
		int number = getRandomInt(LIMIT);

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int guess = 0;

		while (guess != number) {
			System.out.print("Your guess: ");
			guess = sc.nextInt();

			if (guess < 1 || guess > LIMIT) {
				System.out.println("Invalid guess. Try again.");
				count--;
			} else if (guess < number) {
				System.out.println("Too low.");
			} else if (guess > number) {
				System.out.println("Too high.");
			}

			count++;
		}
		System.out.println("\nYou guessed it in " + count + " tries.\n");

		System.out.println("Bye!");
	}
}