package motta.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CountryIO {

	private final String inputFilename = "countries.txt";

	// Returns an ArrayList of the countries stored in the file
	public ArrayList<String> getCountries() {
		ArrayList<String> countries = new ArrayList<>();

		try (BufferedReader in = new BufferedReader(new FileReader(inputFilename))) {
			String line = in.readLine();
			while (line != null) {
				countries.add(line);
				line = in.readLine();
			}
		} catch (IOException e) {
			System.err.println("Caught IOException. Msg: " + e.getMessage());
		}
		return countries;
	}

	// Updates the countries file when a user adds or removes a country from the
	// ArrayList
	public boolean saveCountries(ArrayList<String> countries) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(inputFilename)))) {
			for (String c : countries) {
				out.println(c);
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
		return true;
	}
}
