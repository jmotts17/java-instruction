package motta.app;

public class EmailCreatorApp {

	public static void main(String[] args) {

		// Customer String containing first name, last name and email
		String[] csv = { "   james   ,butler,jbutler@gmail.com", "Josephine,Darakjy,Josephine_Darakjy@darakjy.org",
				"ART,VENERE,ART@VENERE.ORG" };

		// Email template
		String template = "To:      {email}\n" + "From:    noreply@deals.com\n" + "Subject: Deals!\n\n"
				+ "Hi {first_name},\n\n" + "We've got some great deals for you. Check our website!";

		// Creates an array of Person objects set to the length of the csv string
		Person[] persons = new Person[csv.length];

		// Inputs the data into the persons array
		for (int i = 0; i < csv.length; i++) {
			// Creates an array of Strings to store the person fields
			String[] csvSplit = new String[3];
			// Splits the csv array by commas
			csvSplit = csv[i].split(",");
			// Creates a new Person object and stores it in the persons array
			persons[i] = new Person(csvSplit[0].trim().toLowerCase(), csvSplit[1].trim().toLowerCase(),
					csvSplit[2].trim().toLowerCase());
		}

		// Output welcome message
		System.out.println("Email Creator\n");

		// Output the template with each persons email / name
		for (int i = 0; i < persons.length; i++) {
			// Creates a StringBuilder version of the template
			StringBuilder newTemplate = new StringBuilder();
			newTemplate.append(template);

			// Stores the first letter of the persons first name
			char firstLetter = persons[i].getFirstName().charAt(0);
			// Stores a capitalized version of the firstLetter
			char firstLetterUpper = Character.toUpperCase(firstLetter);

			// Replaces the first name and email with the persons first name and email
			newTemplate.replace(64, 76, persons[i].getFirstName().replace(firstLetter, firstLetterUpper));
			newTemplate.replace(9, 16, persons[i].getEmail());

			// Outputs the results
			System.out.println("================================================================");
			System.out.println(newTemplate);
		}

	}
}
