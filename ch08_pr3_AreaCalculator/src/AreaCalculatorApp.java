
public class AreaCalculatorApp {

	public static void main(String[] args) {

		// Variable Declaration
		String choice, response;
		Circle circle;
		Square square;
		Rectangle rectangle;

		// Output welcome message
		System.out.println("Welcome to the Area Calculator");

		do {
			// Output prompt to user to see which shape they want to get the area of
			response = Console.getString("\nCalculate the area of a circle, square, or rectangle? (c/s/r): ", "c", "s",
					"r");

			switch (response) {
			// Case c - Calls create circle method and outputs the area and perimeter
			case "c":
			case "C":
				circle = createCircle("\nEnter radius: ");
				System.out.println("\nThe area of the circle you entered is " + circle.getArea());
				System.out.println("The perimeter of the circle you entered is " + circle.getPerimeter());
				break;
			// Case s - Calls create square method and outputs the area and perimeter
			case "s":
			case "S":
				square = createSquare("\nEnter width: ");
				System.out.println("\nThe area of the square you entered is " + square.getArea());
				System.out.println("The perimeter of the square you entered is " + square.getPerimeter());
				break;
			// Case r - Calls create rectangle method and outputs the area and perimeter
			case "r":
			case "R":
				rectangle = createRectangle("\nEnter width: ", "Enter height: ");
				System.out.println("\nThe area of the rectangle you entered is " + rectangle.getArea());
				System.out.println("The perimeter of the rectangle you entered is " + rectangle.getPerimeter());
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
	 * @return circle
	 */
	public static Circle createCircle(String prompt) {
		double radius = Console.getDouble(prompt);
		Circle circle = new Circle(radius);
		return circle;
	}

	/**
	 * Prompts the user to enter a width. Creates a square using the width.
	 * 
	 * @param prompt
	 * @return square
	 */
	public static Square createSquare(String prompt) {
		double width = Console.getDouble(prompt);
		Square square = new Square(width);
		return square;
	}

	/**
	 * Prompts the user for a width and height. Creates a rectangle using the width
	 * and height.
	 * 
	 * @param prompt1
	 * @param prompt2
	 * @return rectangle
	 */
	public static Rectangle createRectangle(String prompt1, String prompt2) {
		double width = Console.getDouble(prompt1);
		double height = Console.getDouble(prompt2);
		Rectangle rectangle = new Rectangle(width, height);
		return rectangle;
	}

}
