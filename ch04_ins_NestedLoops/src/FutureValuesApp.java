import java.text.NumberFormat;

public class FutureValuesApp {

	public static void main(String[] args) {

		// Get the formatters
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(1);

		// Set and display monthly payment
		int monthlyInvestment = 100;
		System.out.println("Enter monthly investment: " + currency.format(monthlyInvestment) + "\n");

		// Create header and add to table string
		String table = "";
		String headerRow = "Year      ";

		for (double rate = 5.0; rate < 7; rate += .5) {
			headerRow += percent.format(rate / 100) + "          ";
		}

		table += headerRow + "\n";

		// Loop thru the years
		for (int year = 1; year < 7; year++) {
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

	}

}
