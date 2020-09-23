
public class PersonManagerApp {

	public static void main(String[] args) {

		// Output Welcome Message
		System.out.println("Welcome to the Person Manager");

		// Variable Declaration
		String choice, response;

		do {
			response = Console.getString("\nCreate customer or employee? (c/e): ", "c", "e");

			// Calls correct method basedo n user input
			if (response.equalsIgnoreCase("c")) {
				Customer customer = createCustomer();
				System.out.println(customer.toString());
			} else {
				Employee employee = createEmployee();
				System.out.println(employee.toString());
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
