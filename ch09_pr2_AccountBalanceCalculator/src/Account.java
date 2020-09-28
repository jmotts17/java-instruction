
public class Account implements Depositable, Withdrawable, Balanceable {

	// Field
	private double balance;

	// Constructor
	public Account() {
		balance = 0.0;
	}

	public Account(double balance) {
		this.balance = balance;
	}

	// Override deposit method
	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	// Override withdraw method
	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

	// Override getter method
	@Override
	public double getBalance() {
		return balance;
	}

	// Override setter method
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
