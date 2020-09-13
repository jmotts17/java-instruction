import java.util.Scanner;

public class PowersApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Varaible Declaration
		String choice = "";

		// Output Welcome Message
		System.out.println("Welcome to the Squares and Cubes table");

		do {

			// Prompt user for input
			System.out.print("\nEnter an integer: ");
			int num = scanner.nextInt();

			// Output Table Header
			System.out.println("\nNumber   Squared  Cubed");
			System.out.println("======   =======  =====");

			// Calculate and Output Results
			for (int i = 1; i <= num; i++) {
				System.out.println(i + "\t " + (i * i) + "\t  " + (i * i * i));
			}

			// Prompt user to continue
			System.out.print("\nContinue? (y/n:) ");
			choice = scanner.next();
		} while (choice.equalsIgnoreCase("y"));

	}

}
