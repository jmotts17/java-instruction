import java.util.Scanner;

public class RectangleCalculatorApp {

	public static void main(String[] args) {
		
		// Create new Scanner object
		Scanner scanner = new Scanner(System.in);
		
		// Variable Declaration
		double length, width;
		String prompt = "y";
		
		// Output welcome message
		System.out.println("Welcome to the Area and Perimeter Calculator");
		
		while(prompt.equalsIgnoreCase("y")) {
			// Prompt user for input
			System.out.print("\nEnter Length: ");
			length = scanner.nextDouble();
			System.out.print("Enter Width: ");
			width = scanner.nextDouble();
			
			// Calculate area and perimeter
			double area = width * length;
			double perimeter = (2 * width) + (2 * length);
			
			// Output results
			System.out.println("Area: " + area
							  + "\nPerimeter: " + perimeter);
			
			// Prompt user to go again
			System.out.print("\nContinue? (y/n): ");
			prompt = scanner.next();			
		}
	
	}
	
}
