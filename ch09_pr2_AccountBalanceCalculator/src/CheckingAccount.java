
public class CheckingAccount extends Account {

	// Field
	private double monthlyFee;

	// Constructor
	public CheckingAccount(double balance, double monthlyFee) {
		setBalance(balance);
		this.monthlyFee = monthlyFee;
	}

	// Getter method
	public double getMonthlyFee() {
		return monthlyFee;
	}

	// Helper method - withdraws monthly fee from checking account
	public void subtractMonthlyFee() {
		withdraw(monthlyFee);
	}

}
