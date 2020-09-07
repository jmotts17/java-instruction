import java.math.BigDecimal;
import java.util.Scanner;

public class MPGApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Miles Per Gallon calculator");
		System.out.println(); // print a blank line

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles driven: ");
			double miles = sc.nextDouble();

			System.out.print("Enter gallons of gas used: ");
			double gallons = sc.nextDouble();

			// Round using Math.round
			// double mpg = (double) Math.round((miles / gallons) * 100) / 100;

			// Round using NumberFormat
			// NumberFormat formatter = NumberFormat.getInstance();
			// formatter.setMaximumFractionDigits(2);
			// String mpg = formatter.format(miles / gallons);

			// Round using Big Decimal
			BigDecimal bdMiles = new BigDecimal(miles);
			BigDecimal bdGallons = new BigDecimal(gallons);
			BigDecimal mpg = bdMiles.divide(bdGallons, 2, BigDecimal.ROUND_HALF_UP);

			System.out.println("Miles per gallon is " + mpg + ".");
			System.out.println();

			System.out.print("Calculate another MPG? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}

}
