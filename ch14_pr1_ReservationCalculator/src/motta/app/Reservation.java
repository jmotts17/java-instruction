package motta.app;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Reservation {

	// Field declarations
	private final Double nightlyRate = 145.00;
	private LocalDate arrivalDate;
	private LocalDate departureDate;

	// Constructors
	public Reservation() {
		arrivalDate = LocalDate.of(0, 0, 0);
		departureDate = LocalDate.of(0, 0, 0);
	}

	public Reservation(LocalDate arrivalDate, LocalDate departureDate) {
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	// Getters & Setters
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public String getArrivalDateFormatted() {
		return DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(arrivalDate);
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public String getDepartureDateFormatted() {
		return DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(departureDate);
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	// Calculates the number of nights
	public int getNumberOfNights() {
		return (int) ChronoUnit.DAYS.between(arrivalDate, departureDate);
	}

	// Returns the nightly rate with a currency format
	public String getPricePerNightFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setMinimumIntegerDigits(2);
		return currency.format(nightlyRate);
	}

	// Calculates the total price based on number of nights and nightly rate
	public double getTotalPrice() {
		return getNumberOfNights() * nightlyRate;
	}

	// Returns the total price with a currency format
	public String getTotalPriceFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setMinimumIntegerDigits(2);
		return currency.format(getTotalPrice());
	}

}
