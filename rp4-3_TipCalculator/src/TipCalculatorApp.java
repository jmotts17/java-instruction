import java.text.DecimalFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("##.00");

		System.out.println("Tip Calculator");

		System.out.print("\nCost of meal: ");
		double mealCost = scanner.nextDouble();

		for (double i = .15; i < .30; i += .05) {
			System.out.println("\n" + (int) (i * 100) + "%");
			System.out.println("Tip Amount: $" + f.format((mealCost * i)));
			System.out.println("Total Amount: $" + f.format(((mealCost * i) + mealCost)));
		}

	}

}
