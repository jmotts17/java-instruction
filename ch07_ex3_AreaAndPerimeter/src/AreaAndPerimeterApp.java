import java.util.Scanner;

public class AreaAndPerimeterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area and Perimeter Calculator");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// Get input from user
			System.out.print("Enter length: ");
			double length = Double.parseDouble(sc.nextLine());

			System.out.print("Enter width:  ");
			double width = Double.parseDouble(sc.nextLine());

			// Create new rectangle object
			Rectangle rectangle = new Rectangle(length, width);

			// Display output
			System.out.println("Area:         " + rectangle.getAreaString());
			System.out.println("Perimeter:    " + rectangle.getPerimeterString());

			// See if the user wants to continue
			System.out.print("\nContinue? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
		}
		System.out.println("Bye!");
	}
}
