package motta.app;

import java.time.LocalDate;
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

			// Calculate estimated arrival time
			LocalTime arrivalTime = departureTime.plusHours(hours).plusMinutes(minutes);
			String arrivalTimeFormatted = timeFormatter.format(arrivalTime);

			// Calculate estimated arrival date
			LocalDate arrivalDate = getLocalDate(arrivalTime, departureDate, departureTime);
			String arrivalDateFormatted = dateFormatter.format(arrivalDate);

			// Output results
			outputResults(hours, minutes, arrivalDateFormatted, arrivalTimeFormatted);

			// Prompt user to continue
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

		System.out.println("Bye!");
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

	/**
	 * If arrival time is before departure time, returns departureDay + 1. Otherwise
	 * returns departureDate as it is the same day.
	 * 
	 * @param arrivalTime
	 * @param departureDate
	 * @param departureTime
	 * @return LocaleDate / Arrival Date
	 */
	public static LocalDate getLocalDate(LocalTime arrivalTime, LocalDate departureDate, LocalTime departureTime) {
		if (arrivalTime.isBefore(departureTime)) {
			return departureDate.plusDays(1);
		} else {
			return departureDate;
		}
	}
}
