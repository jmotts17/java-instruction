package motta.app;

import java.time.LocalDate;

public class ReservationCalcApp {

	public static void main(String[] args) {

		// Variable declaration
		String choice;

		// Output welcome message
		System.out.println("Reservation Calculator");

		do {

			// Stores result of arrivalInfo in arrival
			LocalDate arrival = arrivalInfo();
			// Stores result of departureInfo in departure
			LocalDate departure = departureInfo();
			// Creates a reservation object
			Reservation reservation = new Reservation(arrival, departure);
			// Outputs results
			travelInfo(reservation);

			// Prompts the user to continue
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

		System.out.println("\nBye!");
	}

	/**
	 * Prompts the user for the arrival month, day, and year.
	 * 
	 * @return LocalDate Arrival Info
	 */
	public static LocalDate arrivalInfo() {
		int month = Console.getInt("\nEnter the arrival month (1-12): ", 0, 13);
		int day = Console.getInt("Enter the arrival day (1-31): ", 0, 32);
		int year = Console.getInt("Enter the arrival year: ");

		return LocalDate.of(year, month, day);
	}

	/**
	 * Prompts the user for the departure month, day, and year.
	 * 
	 * @return LocalDate Arrival Info
	 */
	public static LocalDate departureInfo() {
		int month = Console.getInt("\nEnter the arrival month (1-12): ", 0, 13);
		int day = Console.getInt("Enter the arrival day (1-31): ", 0, 32);
		int year = Console.getInt("Enter the arrival year: ");

		return LocalDate.of(year, month, day);
	}

	/**
	 * Outputs the travel info to the user.
	 * 
	 * @param reservation
	 */
	public static void travelInfo(Reservation reservation) {

		System.out.println("\nArrival Date: " + reservation.getArrivalDateFormatted());
		System.out.println("Departure Date: " + reservation.getDepartureDateFormatted());
		System.out.println("Price: " + reservation.getPricePerNightFormatted() + " per night");
		System.out.println("Total Price: " + reservation.getTotalPriceFormatted() + " for "
				+ reservation.getNumberOfNights() + " nights");
	}
}