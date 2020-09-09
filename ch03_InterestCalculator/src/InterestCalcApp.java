import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalcApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Number Formatter
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMaximumFractionDigits(3);

		// Variable Declaration
		String prompt = "";

		// Output welcome message
		System.out.println("Welcome to the Interest Calculator");

		do {
			// Prompt user for input
			System.out.print("\nEnter loan amount: ");
			BigDecimal loanAmount = scanner.nextBigDecimal();
			System.out.print("Enter interest rate: ");
			BigDecimal interestRate = scanner.nextBigDecimal();

			// Calculate Results
			BigDecimal interest = loanAmount.multiply(interestRate).setScale(2, BigDecimal.ROUND_HALF_UP);

			// Output Results
			System.out.println("\nLoan amount: \t" + moneyFormat.format(loanAmount));
			System.out.println("Interest Rate: \t" + percentFormat.format(interestRate));
			System.out.println("Interest: \t" + moneyFormat.format(interest));

			// Prompt user to continue
			System.out.print("\nContinue? (y/n): ");
			prompt = scanner.next();

		} while (prompt.equalsIgnoreCase("y"));
	}

}
