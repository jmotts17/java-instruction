import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalcApp {

	public static void main(String[] args) {

		// Create Scanner Object
		Scanner scanner = new Scanner(System.in);

		// Number Formatter
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

		// Variable Declaration
		String prompt = "";

		// Output welcome message
		System.out.println("Welcome to the Interest Calculator");

		do {
			// Prompt user for input
			System.out.print("\nEnter loan amount: ");
			String strLoanAmount = scanner.next();
			System.out.print("Enter interest rate: ");
			String strInterestRate = scanner.next();

			// Convert to BigDecimal & Calculate Results
			BigDecimal loanAmount = new BigDecimal(strLoanAmount);
			BigDecimal interestRate = new BigDecimal(strInterestRate);
			BigDecimal interest = loanAmount.multiply(interestRate).setScale(2, BigDecimal.ROUND_HALF_UP);
			interestRate = interestRate.movePointRight(2);

			// Output Results
			System.out.print("\nLoan amount: \t" + moneyFormat.format(loanAmount));
			System.out.print("\nInterest Rate: \t" + interestRate + "%");
			System.out.print("\nLoan amount: \t" + moneyFormat.format(interest));

			// Prompt user to continue
			System.out.print("\n\nContinue? (y/n): ");
			prompt = scanner.next();

		} while (prompt.equalsIgnoreCase("y"));
	}

}
