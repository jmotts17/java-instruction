
public class SavingsAccount extends Account {

	// Field
	private double monthlyIntRate;

	// Constructors
	public SavingsAccount() {
		monthlyIntRate = 0.0;
	}

	public SavingsAccount(double balance, double monthlyIntRate) {
		setBalance(balance);
		this.monthlyIntRate = monthlyIntRate;
	}

	// Getter method
	public double getMonthlyIntPayment() {
		return getBalance() * monthlyIntRate;
	}

	// Helper method - deposits monthly payment to savings account
	public void depositMonthlyPayment() {
		deposit(getMonthlyIntPayment());
	}

}
