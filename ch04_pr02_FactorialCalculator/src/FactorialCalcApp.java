import java.util.Scanner;

public class FactorialCalcApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Variable Declaration
		String choice = "";

		// Output Welcome Message
		System.out.println("Welcome to the Factorial Calculator");

		do {
			System.out.print("\nEnter an integer that's greater than 0 and less than 21: ");
			int num = scanner.nextInt();

			long factorial = 1;

			for (int i = 1; i <= num; i++) {
				factorial *= i;
			}

			System.out.println("The factorial of " + num + " is " + factorial);

			System.out.print("\nContinue? (y/n): ");
			choice = scanner.next();
		} while (choice.equalsIgnoreCase("y"));

	}

}