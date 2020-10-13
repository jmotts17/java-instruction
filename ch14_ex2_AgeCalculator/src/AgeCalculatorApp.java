import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Age Calculator\n");

		// Get the current date
		LocalDate currentDay = LocalDate.now();

		// Get input from the the user
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your date of birth (YYYY-MM-DD): ");
		String dateOfBirthString = sc.nextLine();
		System.out.println();

		// Get and validate user's date of birth
		LocalDate birthday = LocalDate.parse(dateOfBirthString);
		if (birthday.isAfter(currentDay)) {
			System.out.println("Invalid date entered. Please try again.");
		} else {

			// If user's date of birth is valid
			// Format and print user's date of birth
			System.out.println(
					"Your date of birth is " + DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(birthday));

			// Format and print the current date
			System.out.println(
					"The current date is " + DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(currentDay));

			// Calculate and print the user's age
			int yearsOld = (int) ChronoUnit.YEARS.between(birthday, currentDay);
			System.out.println("Your age is " + yearsOld);
		}
	}
}