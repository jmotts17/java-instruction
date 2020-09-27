
public class PersonManagerApp {

	public static void main(String[] args) {

		// Output Welcome Message
		System.out.println("Welcome to the Person Manager");

		// Variable/Object Declaration
		String choice, response;
		Person previous = null;
		Person current = null;
		Customer customer = null;
		Employee employee = null;

		do {
			response = Console.getString("\nCreate customer or employee? (c/e): ", "c", "e");

			// Calls correct method based on user input
			if (response.equalsIgnoreCase("c")) {
				customer = createCustomer();
				System.out.println(customer.toString());
				current = customer;
			} else {
				employee = createEmployee();
				System.out.println(employee.toString());
				current = employee;
			}

			// The below statements compare the previous & new entry to see if they are
			// equal
			if (previous == null) {
				if (response.equalsIgnoreCase("c")) {
					previous = customer;
				} else {
					previous = employee;
				}
			} else {
				if (current.equals(previous)) {
					System.out.println("This entry and the last entry are equal.");
				} else {
					System.out.println("This entry and the last entry are not equal.");
				}
				previous = current;
			}

			// Prompts user to continue
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

	}

	/**
	 * Prompts the user for a first name, last name and customer number to create a
	 * Customer object.
	 * 
	 * @return customer
	 */
	public static Customer createCustomer() {
		String firstName = Console.getString("\nFirst Name: ");
		String lastName = Console.getString("Last Name: ");
		String customerNumber = Console.getString("Customer Number: ");
		Customer customer = new Customer(firstName, lastName, customerNumber);
		System.out.println("\nYou entered a new Customer:");

		return customer;
	}

	/**
	 * Prompts the user for a first name, last name and SSN to create a Employee
	 * object.
	 * 
	 * @return employee
	 */
	public static Employee createEmployee() {
		String firstName = Console.getString("\nFirst Name: ");
		String lastName = Console.getString("Last Name: ");
		String ssn = Console.getString("SSN: ");
		Employee employee = new Employee(firstName, lastName, ssn);
		System.out.println("\nYou entered a new Employee:");

		return employee;
	}

}
