import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {

		// Create Scanner object
		Scanner scanner = new Scanner(System.in);

		// Variable declaration
		String choice;
		final BigDecimal PERC_15 = new BigDecimal(Double.toString(.15));
		final BigDecimal PERC_20 = new BigDecimal(Double.toString(.20));
		final BigDecimal PERC_25 = new BigDecimal(Double.toString(.25));

		// NumberFormat declaration
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// Output welcome message
		System.out.println("Tip Calculator");

		do {
			// Prompt user for input
			System.out.print("\nCost of Meal: ");
			BigDecimal mealCost = scanner.nextBigDecimal();

			// Calculate & Output 15%
			BigDecimal tip = mealCost.multiply(PERC_15).setScale(2, RoundingMode.HALF_UP);
			BigDecimal total = mealCost.add(tip).setScale(2, RoundingMode.HALF_UP);
			System.out.println("\n15%");
			System.out.println("Tip Amount: \t" + currency.format(tip));
			System.out.println("Total Amount: \t" + currency.format(total));

			// Calculate & Output 20%
			tip = mealCost.multiply(PERC_20).setScale(2, RoundingMode.HALF_UP);
			total = mealCost.add(tip).setScale(2, RoundingMode.HALF_UP);
			System.out.println("\n20%");
			System.out.println("Tip Amount: \t" + currency.format(tip));
			System.out.println("Total Amount: \t" + currency.format(total));

			// Calculate & Output 25%
			tip = mealCost.multiply(PERC_25).setScale(2, RoundingMode.HALF_UP);
			total = mealCost.add(tip).setScale(2, RoundingMode.HALF_UP);
			System.out.println("\n25%");
			System.out.println("Tip Amount: \t" + currency.format(tip));
			System.out.println("Total Amount: \t" + currency.format(total));

			// Prompt user to continue
			System.out.print("\nContinue? (y/n): ");
			choice = scanner.next();
		} while (choice.equalsIgnoreCase("y"));

	}

}
