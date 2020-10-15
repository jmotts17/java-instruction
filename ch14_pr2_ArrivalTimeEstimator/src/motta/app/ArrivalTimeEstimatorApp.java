package motta.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import motta.ui.Console;

public class ArrivalTimeEstimatorApp {

	public static void main(String[] args) {

		// Variable declaration
		String choice;

		// DateTime Formatters
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

		// Output welcome message
		System.out.println("Arrival Time Estimator");

		do {
			// Prompt user for input
			String date = Console.getString("\nDeparture date (YYYY-MM-DD): ");
			String time = Console.getString("Departure time (HH:MM): ");
			double miles = Console.getInt("Number of miles: ");
			double mph = Console.getInt("Miles per hour: ");

			// Parse user input into LocalDate/LocalTime
			LocalDate departureDate = LocalDate.parse(date);
			LocalTime departureTime = LocalTime.parse(time);

			// Calculate hour and minutes
			int hours = (int) Math.floor(miles / mph);
			int minutes = (int) (((miles / mph) * 60) % 60);

			// Create LocalDateTime based on departureDate and departureTime
			LocalDateTime arrivalInfo = LocalDateTime.of(departureDate, departureTime);
			arrivalInfo = arrivalInfo.plusHours(hours).plusMinutes(minutes);

			// Creates a LocalDate based on arrivalInfo date
			LocalDate arrivalDate = arrivalInfo.toLocalDate();
			String arrivalDateFormatted = dateFormatter.format(arrivalDate); // formats arrival date for output

			// Creates a LocalTime based on arrivalInfo time
			LocalTime arrivalTime = arrivalInfo.toLocalTime();
			String arrivalTimeFormatted = timeFormatter.format(arrivalTime); // formats arrival time for output

			// Output results
			outputResults(hours, minutes, arrivalDateFormatted, arrivalTimeFormatted);

			// Prompt user to continue
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

		System.out.println("\nBye!");
	}

	/**
	 * Outputs the Estimated Travel Time hours, minutes, estimated time of arrival
	 * and estimated date of arrival.
	 * 
	 * @param hours
	 * @param minutes
	 * @param arrivalDate
	 * @param arrivalTime
	 */
	public static void outputResults(int hours, int minutes, String arrivalDate, String arrivalTime) {
		System.out.println("\nEstimated Travel Time");
		System.out.println("Hours: " + hours);
		System.out.println("Minutes: " + minutes);
		System.out.println("Estimated date of arrival: " + arrivalDate);
		System.out.println("Estimated time of arrival: " + arrivalTime);
	}

}
