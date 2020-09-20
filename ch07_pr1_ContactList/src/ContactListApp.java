import java.util.Scanner;

public class ContactListApp {

	public static void main(String[] args) {

		// Create scanner object
		Scanner scanner = new Scanner(System.in);

		// Output welcome message
		System.out.println("Welcome to the Contact List Application");

		// Variable declaration
		String choice;

		do {
			// Prompt user for input
			String firstName = Console.getString("\nEnter first name: ");
			String lastName = Console.getString("Enter last name: ");
			String email = Console.getString("Enter email: ");
			String phoneNumber = Console.getString("Enter phone: ");

			// Create new contact & Output current contact
			Contact contact = new Contact(firstName, lastName, email, phoneNumber);
			System.out.println(contact.displayContact());

			// Prompt user to continue
			choice = Console.getString("\nContinue? (y/n): ");
		} while (choice.equalsIgnoreCase("y"));

	}

}
