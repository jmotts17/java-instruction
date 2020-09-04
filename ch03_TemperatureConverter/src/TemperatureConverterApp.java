import java.text.NumberFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {

		// Create Scanner object
		Scanner scanner = new Scanner(System.in);

		// Number Formatter for Decimal Place
		NumberFormat formatter = NumberFormat.getInstance();
		formatter.setMaximumFractionDigits(2);

		// Variable declaration
		String prompt = "";
		String celDegrees = "";
		double fahDegrees;

		// Output welcome message
		System.out.println("Welcome to the Temperature Converter");

		// Do-While Loop continues as long as user enters y
		do {
			// Prompt user for Fahrenheit Degrees
			System.out.print("\nEnter degrees in Fahrenheit: ");
			fahDegrees = scanner.nextDouble();

			// Calculate and output Celsius Degrees
			celDegrees = formatter.format((fahDegrees - 32) * 5 / 9);
			System.out.println("Degrees in Celsius: " + celDegrees);

			// Prompt user to continue
			System.out.print("\nContinue? (y/n): ");
			prompt = scanner.next();
		} while (prompt.equalsIgnoreCase("y"));

	}

}
