import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);

	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	// Overloaded getString Method -- Takes 2 values
	public static String getString(String prompt, String value1, String value2) {
		String s;
		do {
			System.out.print(prompt);
			s = sc.nextLine(); // read user entry

			// Provides error message if response is empty or not 'y' or 'n'
			if (s.trim().isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			} else if (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2)) {
				System.out.println("Error! Entry must be '" + value1 + "' or '" + value2 + "'. Try again.");
			}
		} while (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2));
		return s;
	}

	// Overloaded getString Method -- Takes 3 values
	public static String getString(String prompt, String value1, String value2, String value3) {
		String s;
		do {
			System.out.print(prompt);
			s = sc.nextLine(); // read user entry

			// Provides error message if response is empty or not 'y' or 'n'
			if (s.trim().isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			} else if (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2) && !s.equalsIgnoreCase(value3)) {
				System.out.println(
						"Error! Entry must be '" + value1 + "' or '" + value2 + "' or '" + value3 + "'. Try again.");
			}
		} while (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2) && !s.equalsIgnoreCase(value3));
		return s;
	}

	public static int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(prompt);
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (i >= max) {
				System.out.println("Error! Number must be less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return i;
	}

	public static double getDouble(String prompt) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid number. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			d = getDouble(prompt);
			if (d <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (d >= max) {
				System.out.println("Error! Number must be less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return d;
	}
}