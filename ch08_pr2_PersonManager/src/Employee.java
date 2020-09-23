
public class Employee extends Person {

	// Fields
	private String ssn;

	// Constructors
	public Employee(String firstName, String lastName, String ssn) {
		super(firstName, lastName);
		this.ssn = ssn;
	}

	// Getters & Setters
	public String getSsn() {
		String lastFourDigits = this.ssn.substring(ssn.length() - 4);
		ssn = "xxx-xx-" + lastFourDigits;
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// Override toString method
	@Override
	public String toString() {
		return super.toString() + "\nSSN: " + this.getSsn();
	}

}
