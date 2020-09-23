import java.util.Scanner;

public class MyConsole extends Console {

	// Create Scanner object
	private Scanner sc = new Scanner(System.in);

	// Overrides the overloaded console method getString
	@Override
	public String getString(String prompt, String value1, String value2) {
		String s;
		do {
			System.out.print(prompt);
			s = sc.nextLine(); // read user entry

			// Provides error message if response is empty or not 'y' or 'n'
			if (s.trim().isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			} else if (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2)) {
				System.out.println("Error! Entry must be 'y' or 'n'. Try agian.");
			}
		} while (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2));
		return s;
	}

}
