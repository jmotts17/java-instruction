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
			// Prompt user for input
			System.out.print("\nEnter miles: ");
			miles = scanner.nextDouble();
			System.out.print("Enter miles per hour: ");
			mph = scanner.nextDouble();

			// Calculate hours and minutes
			hours = (int) Math.floor(miles / mph);
			minutes = (int) (((miles / mph) * 60) % 60);

			// Output results
			System.out.println("\nEstimated travel time");
			System.out.println("---------------------");
			System.out.println("Hours:   " + hours);
			System.out.println("Minutes: " + minutes);

			// Prompt user to continue
			System.out.print("\nContinue? (y/n): ");
			prompt = scanner.next();
		} while (prompt.equalsIgnoreCase("y"));

	}

}
