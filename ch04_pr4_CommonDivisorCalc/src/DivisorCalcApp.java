public class DivisorCalcApp {

	public static void main(String[] args) {

		// Variable Declaration
		String choice = "";

		// Output Welcome Message
		System.out.println("Greatest Common Divisor Finder");

		do {

			// Prompt user for input
			int num1 = Console.getInt("\nEnter first number: ");
			int num2 = Console.getInt("Enter second number: ");

			// Call calculateGCD method
			int gcd = calculateGreatestCommonDivisor(num1, num2);

			// Output results
			System.out.println("Greatest Common Divisor: " + gcd);

			// Prompt user to continue
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

	}

	// Calculate GCD
	private static int calculateGreatestCommonDivisor(int num1, int num2) {
		while (num1 != num2) {
			if (num1 > num2) {
				num1 = num1 - num2;
			} else {
				num2 = num2 - num1;
			}
		}

		return num2;
	}

}
