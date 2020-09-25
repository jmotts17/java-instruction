
public class Customer extends Person {

	// Fields
	private String customerNumber;

	// Constructors
	public Customer(String firstName, String lastName, String customerNumber) {
		super(firstName, lastName);
		this.customerNumber = customerNumber;
	}

	// Getters & Setters
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	// Override toString method
	@Override
	public String toString() {
		return super.toString() + "\nCustomer Number: " + this.customerNumber;
	}

	// Override equals method
	@Override
	public boolean equals(Object object) {
		if (object instanceof Customer) {
			Customer customer1 = (Customer) object;
			if (customerNumber.equals(customer1.getCustomerNumber())
					&& (super.firstName.equals(customer1.getFirstName())
							&& (super.lastName.equals(customer1.getLastName())))) {
				return true;
			}
		}
		return false;
	}
}
