package motta.app;

import java.util.ArrayList;
import java.util.List;

import motta.business.CountryIO;
import motta.ui.Console;

public class CountryListManagerApp {

	// Creates a static CountryIO object
	private static CountryIO countryIO = new CountryIO();

	public static void main(String[] args) {

		// Variable declaration
		int option;

		// Output welcome message
		System.out.println("Country List Manager");

		do {
			// Prompt user for selection from menu
			option = displayCommandMenu();

			// Calls correct method based on user selection
			switch (option) {
			case 1:
				listCountries();
				break;
			case 2:
				addCountry();
				break;
			case 3:
				deleteCountry();
				break;
			case 4:
				System.out.println("\nGoodbye");
				break;
			}

		} while (option != 4);

	}

	/**
	 * Displays the menu options for the user and prompts for selection.
	 * 
	 * @return user selection (1-4)
	 */
	private static int displayCommandMenu() {
		System.out.println("\nCOMMAND MENU");
		System.out.println("1 - List countries\n" + "2 - Add a country\n" + "3 - Delete a country\n" + "4 - Exit\n");
		int option = Console.getInt("Enter menu number: ", 0, 5);
		return option;
	}

	/**
	 * Outputs the list of countries.
	 */
	private static void listCountries() {
		List<String> countries = countryIO.getCountries();
		System.out.println();

		for (String c : countries) {
			System.out.println(c);
		}
	}

	/**
	 * Prompts the user for a country to add and saves the updated file.
	 */
	private static void addCountry() {
		String country = Console.getString("\nEnter country: ");
		List<String> countries = countryIO.getCountries();
		countries.add(country);
		if (countryIO.saveCountries((ArrayList<String>) countries)) {
			System.out.println(country + " has been saved");
		}
	}

	/**
	 * Prompts the user for a country to delete and saves the updated file.
	 */
	private static void deleteCountry() {
		String country = Console.getString("\nEnter country: ");
		List<String> countries = countryIO.getCountries();
		countries.remove(country);
		if (countryIO.saveCountries((ArrayList<String>) countries)) {
			System.out.println(country + " has been deleted");
		}
	}

}
