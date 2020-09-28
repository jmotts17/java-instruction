import java.text.NumberFormat;

public class AccountBalanceApp {

	public static void main(String[] args) {

		// Create formatter
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		// Create checking & savings account objects
		CheckingAccount checking = new CheckingAccount(1000, 1);
		SavingsAccount savings = new SavingsAccount(1000, 0.01);

		// Variable declaration
		String wd, cs, response;
		double amount;

		// Call bankWelcome method
		bankWelcome(checking, savings, formatter);

		do {
			// User prompts
			wd = Console.getString("\nWithdrawal or deposit? (w/d): ", "w", "d");
			cs = Console.getString("Checking or savings? (c/s): ", "c", "s");
			amount = Console.getDouble("Amount?: ");

			// If-Else determines if checking or savings
			if (cs.equalsIgnoreCase("c")) {
				accountTransaction(checking, wd, amount);
			} else if (cs.equalsIgnoreCase("s")) {
				accountTransaction(savings, wd, amount);
			}

			// Prompts user to continue
			response = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (response.equalsIgnoreCase("y"));

		// Call bankFinal method
		bankFinal(checking, savings, formatter);

	}

	/**
	 * Outputs all the bank application start up messages. Includes welcome message,
	 * starting balances, and transactions for the month
	 * 
	 * @param checking
	 * @param savings
	 * @param formatter
	 */
	public static void bankWelcome(CheckingAccount checking, SavingsAccount savings, NumberFormat formatter) {
		System.out.println("Welcome to the Account Application");

		System.out.println("\nStarting Balances");
		System.out.println("Checking: " + formatter.format(checking.getBalance()));
		System.out.println("Savings: " + formatter.format(savings.getBalance()));

		System.out.println("\nEnter transactions for the month");
	}

	/**
	 * Outputs all the bank applications closing messages. Includes checking fee,
	 * savings interest payment and the final balances for checking & savings
	 * account.
	 * 
	 * @param checking
	 * @param savings
	 * @param formatter
	 */
	public static void bankFinal(CheckingAccount checking, SavingsAccount savings, NumberFormat formatter) {
		System.out.println("\nMonthly Payments and Fees");
		System.out.println("Checking fee:             " + formatter.format(checking.getMonthlyFee()));
		System.out.println("Savings interest payment: " + formatter.format(savings.getMonthlyIntPayment()));

		// Calls the checking and savings helper methods
		checking.subtractMonthlyFee();
		savings.depositMonthlyPayment();

		System.out.println("\nFinal Balances");
		System.out.println("Checking: " + formatter.format(checking.getBalance()));
		System.out.println("Savings:  " + formatter.format(savings.getBalance()));
	}

	/**
	 * This method withdraws or deposits the amount to the type of account that is
	 * passed.
	 * 
	 * @param account
	 * @param wd
	 * @param amount
	 */
	public static void accountTransaction(Account account, String wd, double amount) {
		if (wd.equalsIgnoreCase("w")) {
			account.withdraw(amount);
		} else if (wd.equalsIgnoreCase("d")) {
			account.deposit(amount);
		}
	}

}