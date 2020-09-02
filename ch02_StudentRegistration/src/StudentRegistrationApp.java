import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		
		// Create new scanner object
		Scanner scanner = new Scanner(System.in);
		
		// Variable declaration
		String firstName;
		String lastName;
		String temporaryPassword;
		int birthYear;
		
		// Output welcome message
		System.out.println("Student Registration Form");
		
		// Prompt user for input
		System.out.print("\nEnter first name: ");
		firstName = scanner.next();
		System.out.print("Enter last name: ");
		lastName = scanner.next();
		System.out.print("Enter year of birth: ");
		birthYear = scanner.nextInt();
		
		temporaryPassword = firstName + "*" + birthYear;
		
		System.out.println("\nWelcome " + firstName + " " + lastName + "!");
		System.out.println("Your registration is complete." +
							"\nYour temporary password is: " + temporaryPassword);
		
	}

}
