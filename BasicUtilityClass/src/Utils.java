import java.util.Scanner;

/*
	For a completely stateless utility class in Java, I suggest the class be declared public and final, and have a private constructor to prevent instantiation. 
	The final keyword prevents sub-classing and can improve efficiency at runtime.

	The class should contain all static methods and should not be declared abstract (as that would imply the class is not concrete and has to be implemented in some way).

	The class should be given a name that corresponds to its set of provided utilities (or "Util" if the class is to provide a wide range of uncategorized utilities).

	The class should not contain a nested class unless the nested class is to be a utility class as well (though this practice is potentially complex and hurts readability).

	Methods in the class should have appropriate names.

	Methods only used by the class itself should be private.

	The class should not have any non-final/non-static class fields.

	The class can also be statically imported by other classes to improve code readability (this depends on the complexity of the project however).
	
	Perhaps most importantly of all, the documentation for each method should be precise and descriptive. 
	Chances are methods from this class will be used very often and its good to have high quality documentation to complement the code.
	
	
 */

public final class Utils {

	private Utils() {
	}

	// getInt verifies that the user entered a valid integer
	public static int getInt(Scanner sc, String prompt) {
		int retVal = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				retVal = sc.nextInt();
				isValid = true;
				sc.nextLine();
			} else {
				System.out.println("Invalid integer number");
				sc.nextLine();
			}
		}

		return retVal;
	}

	// getDouble verifies that the user entered a valid double
	public static double getDouble(Scanner sc, String prompt) {
		double retVal = 0.0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				retVal = sc.nextDouble();
				isValid = true;
				sc.nextLine();
			} else {
				System.out.println("Invalid decimal number");
				sc.nextLine();
			}
		}

		return retVal;
	}

}
