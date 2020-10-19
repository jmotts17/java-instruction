package motta.app;

import java.io.IOException;
import java.util.List;

import motta.business.Customer;
import motta.business.CustomerTextFile;
import motta.business.DAO;
import motta.business.NoSuchCustomerException;
import motta.business.StringUtils;
import motta.ui.Console;

public class CustomerManagerApp {

	// declare class variables
	private static DAO<Customer> customerDAO = null;

	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Customer Manager\n");

		// set the class variables
		try {
			customerDAO = new CustomerTextFile();
		} catch (IOException e) {
			System.err.println("Error reading data file! Exiting application");
			System.err.println(e.getMessage());
			System.exit(0);
		}

		// display the command menu
		displayMenu();

		// perform 1 or more actions
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get the input from the user
			action = Console.getString("\nEnter a command: ");
			System.out.println();

			if (action.equalsIgnoreCase("list")) {
				displayAllCustomers();
			} else if (action.equalsIgnoreCase("add")) {
				addCustomer();
			} else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete")) {
				deleteCustomer();
			} else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu")) {
				displayMenu();
			} else if (action.equalsIgnoreCase("exit")) {
				System.out.println("Bye.\n");
			} else {
				System.out.println("Error! Not a valid command.\n");
			}
		}
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("list    - List all customers");
		System.out.println("add     - Add a customer");
		System.out.println("del     - Delete a customer");
		System.out.println("help    - Show this menu");
		System.out.println("exit    - Exit this application");
	}

	public static void displayAllCustomers() {
		System.out.println("CUSTOMER LIST");

		List<Customer> customers = null;

		try {
			customers = customerDAO.getAll();
		} catch (IOException e) {
			System.out.println("Error displaying customers.");
			return;
		}

		Customer c;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < customers.size(); i++) {
			c = customers.get(i);
			sb.append(StringUtils.padWithSpaces(c.getName(), 27));
			sb.append(c.getEmail());
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void addCustomer() {
		String firstName = Console.getLine("Enter first name: ");
		String lastName = Console.getString("Enter last name: ");
		String email = Console.getString("Enter customer email: ");

		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);

		try {
			customerDAO.add(customer);
		} catch (IOException e) {
			System.out.println("Error adding customer.");
			return;
		}

		System.out.println();
		System.out.println(firstName + " " + lastName + " has been added.");
	}

	public static void deleteCustomer() {
		String email = Console.getString("Enter email to delete: ");

		Customer c = null;

		try {
			c = customerDAO.get(email);
		} catch (NoSuchCustomerException e) {
			System.out.println("Customer doesn't exist.");
		} catch (IOException e) {
			System.out.println("Error retrieving customer.");
			return;
		}

//		System.out.println();
		if (c != null) {
			try {
				customerDAO.delete(c);
			} catch (IOException e) {
				System.out.println("Error deleting customer.");
				return;
			}
			System.out.println(c.getName() + " has been deleted.");
		}
	}
}