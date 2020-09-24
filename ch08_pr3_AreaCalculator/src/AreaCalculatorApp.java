
public class AreaCalculatorApp {

	public static void main(String[] args) {

		// Variable Declaration
		String choice, response;
		double area;

		// Output welcome message
		System.out.println("Welcome to the Area Calculator");

		do {
			// Output prompt to user to see which shape they want to get the area of
			response = Console.getString("\nCalculate the area of a circle, square, or rectangle? (c/s/r): ", "c", "s",
					"r");

			switch (response) {
			// Case c - Calls areaOfCircle method and outputs the return
			case "c":
				area = areaOfCircle("\nEnter raidus: ");
				System.out.println("\nThe area of the circle you entered is " + area);
				break;
			// Case s - Calls areaOfSquare method and outputs the return
			case "s":
				area = areaOfSquare("\nEnter width: ");
				System.out.println("\nThe area of the square you entered is " + area);
				break;
			// Case r - Calls areaOfRectangle method and outputs the return
			case "r":
				area = areaOfRectangle("\nEnter width: ", "Enter height: ");
				System.out.println("\nThe area of the rectangle you entered is " + area);
				break;
			}

			// Prompts the user if they want to continue
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));
	}

	/**
	 * Prompts user to enter a radius. Creates a circle using the radius.
	 * 
	 * @param prompt
	 * @return the circles area.
	 */
	public static double areaOfCircle(String prompt) {
		double radius = Console.getDouble(prompt);
		Circle circle = new Circle(radius);
		return circle.getArea();
	}

	/**
	 * Prompts the user to enter a width. Creates a square using the width.
	 * 
	 * @param prompt
	 * @return the squares area.
	 */
	public static double areaOfSquare(String prompt) {
		double width = Console.getDouble(prompt);
		Square square = new Square(width);
		return square.getArea();
	}

	/**
	 * Prompts the user for a width and height. Creates a rectangle using the width
	 * and height.
	 * 
	 * @param prompt1
	 * @param prompt2
	 * @return the rectangles area.
	 */
	public static double areaOfRectangle(String prompt1, String prompt2) {
		double width = Console.getDouble(prompt1);
		double height = Console.getDouble(prompt2);
		Rectangle rectangle = new Rectangle(width, height);
		return rectangle.getArea();
	}

}
