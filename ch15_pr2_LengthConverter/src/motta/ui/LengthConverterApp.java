package motta.ui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import motta.business.Conversion;

public class LengthConverterApp {

	public static void main(String[] args) {

		// Output welcome message
		System.out.println("Length Converter");

		// Variable declaration
		int choice;

		List<Conversion> conversions = new ArrayList<>();
		conversions.add(new Conversion("Miles", 0.0, "Kilometers", 1.6093));
		conversions.add(new Conversion("Kilometers", 0.0, "Miles", 0.6214));
		conversions.add(new Conversion("Inches", 0.0, "Centimeters", 2.54));

		do {
			displayMenu();
			choice = Console.getInt("\nEnter menu number: ", 0, 5);

			switch (choice) {
			case 1:
				displayConversions(conversions);
				calculateConversion(conversions);
				break;
			case 2:
				Conversion newConversion = addConversion();
				conversions.add(newConversion);
				System.out.println("\nEntry added.");
				break;
			case 3:
				deleteConversion(conversions);
				System.out.println("\nEntry removed.");
				break;
			case 4:
				// Nothing to do
				break;
			}

		} while (choice != 4);

		System.out.println("\nGoodbye!");

	}

	/**
	 * Outputs the length converter menu.
	 */
	public static void displayMenu() {
		System.out.println("\n1 - Convert a length");
		System.out.println("2 - Add a type of conversion");
		System.out.println("3 - Delete a type of conversion");
		System.out.println("4 - Exit");
	}

	/**
	 * Outputs the current conversions contained in the list.
	 * 
	 * @param conversions
	 */
	public static void displayConversions(List<Conversion> conversions) {
		int count = 1;

		System.out.println();
		for (Conversion conversion : conversions) {
			System.out.println(count + " - " + conversion);
			count++;
		}
	}

	/**
	 * Calculates the conversion based on the option the user chooses from the
	 * conversion menu and the input they enter.
	 * 
	 * @param conversions
	 */
	public static void calculateConversion(List<Conversion> conversions) {
		// Create formatter & set maximum fraction digits
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(3);
		// Prompt user for option and decrement it for arraylist
		int conversionChoice = Console.getInt("\nEnter conversion number: ");
		conversionChoice--;

		// if-else validates user input
		if (!(conversionChoice >= conversions.size()) && !(conversionChoice < 0)) {
			Conversion conversion = conversions.get(conversionChoice);
			double number = Console.getDouble("\nEnter " + conversion.getFromUnit() + ": ");
			conversion.setFromValue(number);
			System.out.println(number + " " + conversion.getFromUnit() + " = " + nf.format(conversion.getToValue())
					+ " " + conversion.getToUnit());
		} else {
			System.out.println("Invalid conversion number");
		}
	}

	/**
	 * Prompts the user for the values of a Conversion object and returns a new
	 * Conversion object to the main method.
	 * 
	 * @return Conversion
	 */
	public static Conversion addConversion() {
		String fromUnit = Console.getString("\nEnter 'From' unit: ");
		String toUnit = Console.getString("Enter 'To' unit: ");
		double conversion = Console.getDouble("Enter the conversion ratio: ");

		return new Conversion(fromUnit, 0.0, toUnit, conversion);
	}

	/**
	 * Displays the current conversions list, prompts the user for a conversion
	 * number, decrements the conversion number for the list and removes it.
	 * 
	 * @param conversions
	 */
	public static void deleteConversion(List<Conversion> conversions) {
		displayConversions(conversions);
		int conversionChoice = Console.getInt("Enter conversion number: ");
		conversions.remove(--conversionChoice);
	}

}
