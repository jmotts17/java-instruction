import java.text.NumberFormat;
import java.util.LinkedList;

public class FutureValueApp {

	public static void main(String[] args) {

		// display a welcome message
		System.out.println("Welcome to the Future Value Calculator");
		System.out.println();

		LinkedList<String> list = new LinkedList<>();

		// perform 1 or more calculations
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// get the input from the user
			System.out.println("DATA ENTRY");
			double monthlyInvestment = Console.getDouble("Enter monthly investment: ", 0, 1000);
			double interestRate = Console.getDouble("Enter yearly interest rate: ", 0, 30);
			int years = Console.getInt("Enter number of years: ", 0, 100);

			// calculate the future value
			double monthlyInterestRate = interestRate / 12 / 100;
			int months = years * 12;
			double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

			// get the currency and percent formatters
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMinimumFractionDigits(1);

			// format the result as a single string
			String results = "Monthly investment:\t" + currency.format(monthlyInvestment) + "\n"
					+ "Yearly interest rate:\t" + percent.format(interestRate / 100) + "\n" + "Number of years:\t"
					+ years + "\n" + "Future value:\t\t" + currency.format(futureValue) + "\n";

			// print the results
			System.out.println();
			System.out.println("FORMATTED RESULTS");
			System.out.println(results);

			list.add(currency.format(monthlyInvestment) + "\t" + percent.format(interestRate / 100) + "\t"
					+ Integer.toString(years) + "\t" + currency.format(futureValue));

			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();
		}

		System.out.println("Future Value Calculations");
		System.out.println("\nInv/Mo.\tRate\tYears\tFuture Value");

		for (int i = list.size(); i > 0; i--) {
			System.out.println(list.removeLast());
		}
	}

	public static double calculateFutureValue(double monthlyInvestment, double monthlyInterestRate, int months) {
		double futureValue = 0;
		for (int i = 1; i <= months; i++) {
			futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
		}
		return futureValue;
	}

}
