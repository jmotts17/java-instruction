import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueApp {

	public static void main(String[] args) {
		// Output welcome message
		System.out.println("The Future Value Calculator\n");

		// Create formatters
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(1);

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			System.out.print("Enter monthly investment:   ");
			double monthlyInvestment = sc.nextDouble();
			System.out.print("Enter number of years:      ");
			int years = sc.nextInt();

			// Create header and add to table string
			String table = "";
			String headerRow = "\nYear      ";

			for (double rate = 5.0; rate < 7; rate += .5) {
				headerRow += percent.format(rate / 100) + "          ";
			}

			table += headerRow + "\n";

			// Loop thru the years
			for (int year = 1; year <= years; year++) {
				// Add year to the start of the row
				String row = year + "         ";

				for (double rate = 5.0; rate < 7.0; rate += 0.5) {
					int months = year * 12;
					double monthlyInterestRate = rate / 12 / 100;

					double futureValue = 0.0;
					for (int i = 1; i <= months; i++) {
						futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
					}

					// System.out.println("Year " + year + " Rate " + rate + " FV " + futureValue);

					row += currency.format(futureValue) + "     ";
				}
				table += row + "\n";
			}

			System.out.print(table);

			// see if the user wants to continue
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		System.out.println("Bye!");
	}
}