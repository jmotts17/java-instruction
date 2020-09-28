
public class CheckingAccount extends Account {

	// Field
	private double monthlyFee;

	// Constructors
	public CheckingAccount() {
		monthlyFee = 0.0;
	}

	public CheckingAccount(double balance, double monthlyFee) {
		setBalance(balance);
		this.monthlyFee = monthlyFee;
	}

	// Getter method
	public double getMonthlyFee() {
		return monthlyFee;
	}

	// Helper method - withdraws monthly fee from checking account
	public void withdrawMonthlyFee() {
		withdraw(monthlyFee);
	}

}
