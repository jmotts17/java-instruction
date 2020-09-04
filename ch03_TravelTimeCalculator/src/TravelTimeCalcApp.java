import java.util.Scanner;

public class TravelTimeCalcApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Variable Declaration
		String prompt = "";
		double miles, mph;
		int hours, minutes;

		// Output welcome message
		System.out.println("Welcome to the Travel Time Calculator");

		do {

			System.out.println("Enter miles: ");
			miles = scanner.nextDouble();

			System.out.println("Enter miles per hour: ");
			mph = scanner.nextDouble();

			System.out.print("Continue? (y/n): ");
			prompt = scanner.next();
		} while (prompt.equalsIgnoreCase("y"));

	}

}
