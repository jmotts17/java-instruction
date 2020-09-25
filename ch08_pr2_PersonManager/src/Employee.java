
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
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// Override toString method
	@Override
	public String toString() {
		return super.toString() + "\nSSN: xxx-xx-" + this.ssn.substring(ssn.length() - 4);
	}

	// Override equals method
	@Override
	public boolean equals(Object object) {
		if (object instanceof Employee) {
			Employee employee1 = (Employee) object;
			if (ssn.equals(employee1.getSsn()) && super.firstName.equals(employee1.getFirstName())
					&& super.firstName.equals(employee1.getLastName())) {
				return true;
			}
		}
		return false;
	}

}
