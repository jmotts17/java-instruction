import java.text.NumberFormat;

public class MonthSelectorApp {

	public static void main(String[] args) {
		System.out.println("Monthly Sales\n");

		// declare monthNames and monthSales arrays
		String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		double[] monthSales = { 10000, 15000, 12500, 14000, 17000, 20000, 18500, 25000, 30000, 27000, 32000, 31500 };

		// get currency formatting
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// get one or more months
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			int monthNumber = Console.getInt("Enter month number: ");
			monthNumber--;

			// validate input
			if (monthNumber < 0 || monthNumber > monthNames.length) {
				Console.displayLine("Invalid month number. Try again.");
				continue;
			}

			// get the index number for the month
			// and display the month name and sales
			System.out
					.println("Sales for " + monthNames[monthNumber] + ": " + currency.format(monthSales[monthNumber]));

			// check if the user wants to continue
			choice = Console.getString("\nContinue? (y/n): ");
			Console.displayLine();
		}

		double totalSales = 0;
		for (double sales : monthSales) {
			totalSales += sales;
		}
		System.out.println("Total sales: " + currency.format(totalSales));

		// display the total sales for the year

		Console.displayLine();
	}

}
