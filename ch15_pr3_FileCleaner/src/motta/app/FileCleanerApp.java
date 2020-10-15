package motta.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import motta.business.User;

public class FileCleanerApp {

	public static void main(String[] args) {

		// Variable declaration
		final String FIELD_SEP = ",";

		// Creates an ArrayList to store the User objects
		ArrayList<User> users = new ArrayList<User>();

		// Output Welcome Message
		System.out.println("File Cleaner");

		Path prospectsPath = Paths.get("prospects.csv");
		File prospectsFile = prospectsPath.toFile();

		if (Files.exists(prospectsPath)) {
			try (BufferedReader in = new BufferedReader(new FileReader(prospectsFile))) {
				String line = in.readLine();
				while (line != null) {
					// Stores the line and splits it by commas
					String[] fields = line.split(FIELD_SEP);

					// Creates a variable for the first name and only capitalizes the first letter
					String firstName = fields[0].trim().toLowerCase();
					String firstLetterUpper = firstName.substring(0, 1).toUpperCase();
					firstName = firstLetterUpper + firstName.substring(1);

					// Creates a variable for the last name and only capitalizes the first letter
					String lastName = fields[1].trim().toLowerCase();
					String lastLetterUpper = lastName.substring(0, 1).toUpperCase();
					lastName = lastLetterUpper + lastName.substring(1);

					// Creates a variable for the email and makes it lower case
					String email = fields[2].trim().toLowerCase();

					// Creates a User object and adds it to the users ArrayList
					User user = new User(firstName, lastName, email);
					users.add(user);

					// Stores the next line
					line = in.readLine();
				}
				// Outputs once the input is complete
				System.out.println("\nSource file: " + prospectsPath);
			} catch (IOException e) {
				System.out.println("Error Message: " + e.getMessage());
			}
		} else {
			System.out.println(prospectsPath.toAbsolutePath() + " doesn't exist.");
		}

		Path cleanProspectsPath = Paths.get("prospects_clean.csv");
		File cleanProspectsFile = cleanProspectsPath.toFile();

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(cleanProspectsFile)))) {
			for (User user : users) {
				// Prints the "clean" users to the new file
				out.print(user.getFirstName() + FIELD_SEP);
				out.print(user.getLastName() + FIELD_SEP);
				out.println(user.getEmail());
			}
			// Outputs once the output is complete
			System.out.println("Cleaned file: " + cleanProspectsFile);
		} catch (IOException e) {
			System.out.println("Error Message: " + e.getMessage());
		}

		// Output completion message
		System.out.println("\nCongratulations! Your file has been cleaned!");
	}
}
