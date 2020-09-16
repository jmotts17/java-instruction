import java.util.Scanner;

public class DivisorCalcApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Variable Declaration
		String choice = "";

		// Output Welcome Message
		System.out.println("Greatest Common Divisor Finder");

		do {

			// Prompt user for input
			System.out.print("\nEnter first number: ");
			int num1 = scanner.nextInt();
			System.out.print("Enter second number: ");
			int num2 = scanner.nextInt();

			// Calculate GCD
			while (num1 != num2) {
				if (num1 > num2) {
					num1 = num1 - num2;
				} else {
					num2 = num2 - num1;
				}
			}

			// Output results
			System.out.println("Greatest Common Divisor: " + num2);

			// Prompt user to continue
			System.out.print("\nContinue? (y/n): ");
			choice = scanner.next();
		} while (choice.equalsIgnoreCase("y"));

	}

}
