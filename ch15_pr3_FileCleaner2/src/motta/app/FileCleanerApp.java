package motta.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import motta.business.Prospect;

public class FileCleanerApp {

	private static final String inputFileName = "prospect.csv";
	private static final String outputFileName = "prospect_clean.csv";

	public static void main(String[] args) {

		System.out.println("File Cleaner\n");

		try (BufferedReader in = new BufferedReader(new FileReader(inputFileName));
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)))) {

			String line = in.readLine();
			while (line != null) {
				Prospect p = createProspect(line);
				out.print(p.getFirstName() + "," + p.getLastName() + "," + p.getEmail() + "\n");
				line = in.readLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println("Source file: " + inputFileName);
		System.out.println("Cleaned file: " + outputFileName);
		System.out.println("\nCongratulations! Your file has been cleaned!");

//		// Read input file into a List of Strings
//		List<String> lines = new ArrayList<>();
//		try (BufferedReader in = new BufferedReader(new FileReader(inputFileName))) {
//			String line = in.readLine();
//			while (line != null) {
//				lines.add(line);
//				line = in.readLine();
//			}
//		} catch (FileNotFoundException e) {
//			System.err.println("Input file " + inputFileName + " not found.");
//		} catch (IOException e) {
//			System.err.println("Caught IOException. Msg: " + e.getMessage());
//		}
//
//		// Cleanse and convert Strings to EmailRecipients
//		List<Prospect> prospects = new ArrayList<>();
//		for (String line : lines) {
//			Prospect prospect = createProspect(line);
//			prospects.add(prospect);
//		}
//
//		// Write the EmailRecipients to the output file
//		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)))) {
//			for (Prospect p : prospects) {
//				out.print(p.getFirstName() + "," + p.getLastName() + "," + p.getEmail() + "\n");
//			}
//		} catch (IOException e) {
//			System.err.println("Caught IOException. Msg: " + e.getMessage());
//		}

	}

	public static Prospect createProspect(String csvStr) {
		String[] nameParts = csvStr.split(",");

		String emailAddress = nameParts[2].toLowerCase();
		String firstName = convertToTitleCase(nameParts[0]);
		String lastName = convertToTitleCase(nameParts[1]);

		Prospect prospect = new Prospect(firstName, lastName, emailAddress);

		return prospect;
	}

	public static String convertToTitleCase(String inputStr) {
		String firstNameTrimmed = inputStr.trim();
		String nameFirstLetter = firstNameTrimmed.substring(0, 1);
		nameFirstLetter = nameFirstLetter.toUpperCase();

		String nameAfterFirstLetter = firstNameTrimmed.substring(1);
		nameAfterFirstLetter = nameAfterFirstLetter.toLowerCase();

		String titleCaseName = nameFirstLetter + nameAfterFirstLetter;

		return titleCaseName;
	}

}
