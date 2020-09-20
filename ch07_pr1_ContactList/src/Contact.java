
public class Contact {

	// Fields
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	// Default constructor
	public Contact() {
		firstName = "";
		lastName = "";
		email = "";
		phoneNumber = "";
	}

	// Constructor with parameters
	public Contact(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	// Getters & Setters
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phoneNumber;
	}

	public void setPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Helper method for displaying current contact
	public String displayContact() {
		String message = "\n--------------------------------------------"
				+ "\n---- Current Contact -----------------------" + "\n--------------------------------------------"
				+ "\nName:           " + this.getFirstName() + " " + this.getLastName() + "\nEmail Address:  "
				+ this.getEmail() + "\nPhone Number:   " + this.getPhone()
				+ "\n--------------------------------------------";

		return message;
	}

}
