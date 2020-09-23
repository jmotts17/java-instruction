
public class Person {

	// Fields
	private String firstName;
	private String lastName;

	// Constructor
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters & Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Override toString method
	@Override
	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName;
	}

}
