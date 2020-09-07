import java.util.Scanner;

public class ChangeCalcApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Variable Declaration
		String prompt = "";

		// Output Welcome Message
		System.out.println("Welcome to the Change Calculator");

		do {
			// Prompt user for input
			System.out.print("\nEnter number of cents (0-99): ");
			int cents = scanner.nextInt();

			// Declare and Initialize Variables
			// Must be reset at beginning of loop
			int quarters = 0, dimes = 0, nickels = 0, pennies = 0;

			// Calculate Results
			while (cents > 0) {
				if (cents > 25) {
					quarters++;
					cents -= 25;
				} else if (cents > 10) {
					dimes++;
					cents -= 10;
				} else if (cents > 5) {
					nickels++;
					cents -= 5;
				} else if (cents > 0) {
					pennies++;
					cents -= 1;
				}
			}

			// Output Results
			System.out.println("\nQuarters: \t" + quarters);
			System.out.println("Dimes:  \t" + dimes);
			System.out.println("Nickels: \t" + nickels);
			System.out.println("Pennies: \t" + pennies);

			// Prompt user to continue
			System.out.print("\nContinue? (y/n): ");
			prompt = scanner.next();
		} while (prompt.equalsIgnoreCase("y"));

	}

}
