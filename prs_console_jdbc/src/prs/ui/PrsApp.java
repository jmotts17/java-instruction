package prs.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import prs.business.LineItem;
import prs.business.Product;
import prs.business.Request;
import prs.business.User;
import prs.business.Vendor;
import prs.db.LineItemDb;
import prs.db.ProductDb;
import prs.db.RequestDb;
import prs.db.UserDb;
import prs.db.VendorDb;
import prs.exception.PrsDataException;

public class PrsApp {

	private static UserDb userDb = new UserDb();
	private static VendorDb vendorDb = new VendorDb();
	private static RequestDb requestDb = new RequestDb();
	private static ProductDb productDb = new ProductDb();
	private static LineItemDb lineItemDb = new LineItemDb();

	public static void main(String[] args) {
		// Output welcome message
		System.out.println("Welcome to the PRS App");

		// Variable declaration
		String command = "";
		User authenticatedUser = null;

		do {
			command = displayMenu(authenticatedUser);

			switch (command.toLowerCase()) {
			// USER CASES *****************
			case "user_la":
				listUsers();
				break;
			case "user_id":
				getUserById();
				break;
			case "user_au":
				addUser();
				break;
			case "user_du":
				deleteUser();
				break;
			case "user_uu":
				updateUser();
				break;
			// VENDOR CASES *****************
			case "vend_la":
				listVendors();
				break;
			case "vend_id":
				getVendorById();
				break;
			case "vend_av":
				addVendor();
				break;
			case "vend_dv":
				deleteVendor();
				break;
			case "vend_uv":
				updateVendor();
				break;
			// REQUEST CASES *****************
			case "req_la":
				listRequests();
				break;
			case "req_id":
				getRequestById();
				break;
			case "req_ar":
				addRequest();
				break;
			case "req_dr":
				deleteRequest();
				break;
			case "req_ur":
				updateRequest();
				break;
			// PRODUCT CASES *****************
			case "prod_la":
				listProducts();
				break;
			case "prod_id":
				getProductById();
				break;
			case "prod_ap":
				addProduct();
				break;
			case "prod_dp":
				deleteProduct();
				break;
			case "prod_up":
				updateProduct();
				break;
			// LINE ITEM CASES *****************
			case "li_la":
				listLineItems();
				break;
			case "li_id":
				getLineItemById();
				break;
			case "li_al":
				addLineItem();
				break;
			case "li_dl":
				deleteLineItem();
				break;
			case "li_ul":
				updateLineItem();
				break;
			case "login":
				if (authenticatedUser == null) {
					authenticatedUser = userLogin();
				} else {
					System.out.println("Already logged in.");
				}
				break;
			case "logout":
				authenticatedUser = null;
				System.out.println("Logout successful.");
				break;
			case "exit":
				// Nothing to do
				break;
			case "escape":
				// Nothing to do
				break;
			default:
				System.out.println("Invalid command");
				break;
			}

		} while (!command.equalsIgnoreCase("exit"));

		System.out.println("\nBye");
	}

	/**
	 * Outputs the command menu and each subsequent menu.
	 * 
	 * @return command
	 */
	private static String displayMenu(User authenticatedUser) {
		System.out.println("\nCOMMAND MENU");
		System.out.println("user - User command list");
		System.out.println("vendor - vendor command list");
		System.out.println("request - request command list");
		System.out.println("product - product command list");
		System.out.println("lineitem - line item command list");
		System.out.println("login");
		System.out.println("logout");
		System.out.println("exit - exit the application");
		String command = Console.getString("Enter command: ");

		if (command.equalsIgnoreCase("login") && authenticatedUser == null) {
			return command;
		} else if (authenticatedUser != null) {
			switch (command.toLowerCase()) {
			case "user":
				System.out.println("\nUSER COMMAND MENU");
				System.out.println("user_la - List all users");
				System.out.println("user_id - List user by ID");
				System.out.println("user_au - Add user");
				System.out.println("user_du - Delete user");
				System.out.println("user_uu - Update user");
				command = Console.getString("Enter command: ");
				break;
			case "vendor":
				System.out.println("\nVENDOR COMMAND MENU");
				System.out.println("vend_la - List all vendors");
				System.out.println("vend_id - List vendor by ID");
				System.out.println("vend_av - Add vendor");
				System.out.println("vend_dv - Delete vendor");
				System.out.println("vend_uv - Update vendor");
				command = Console.getString("Enter command: ");
				break;
			case "request":
				System.out.println("\nREQUEST COMMAND MENU");
				System.out.println("req_la - List all requests");
				System.out.println("req_id - List request by ID");
				System.out.println("req_ar - Add request");
				System.out.println("req_dr - Delete request");
				System.out.println("req_ur - Update request");
				command = Console.getString("Enter command: ");
				break;
			case "product":
				System.out.println("\nPRODUCT COMMAND MENU");
				System.out.println("prod_la - List all products");
				System.out.println("prod_id - List product by ID");
				System.out.println("prod_ap - Add product");
				System.out.println("prod_dp - Delete product");
				System.out.println("prod_up - Update product");
				command = Console.getString("Enter command: ");
				break;
			case "lineitem":
				System.out.println("\nLINE ITEM COMMAND MENU");
				System.out.println("li_la - List all line items");
				System.out.println("li_id - List line item by ID");
				System.out.println("li_al - Add line item");
				System.out.println("li_dl - Delete line item");
				System.out.println("li_ul - Update line item");
				command = Console.getString("Enter command: ");
				break;
			case "login":
			case "logout":
			case "exit":
				// Nothing to do
				break;
			default:
				command = "";
				break;
			}

			return command;
		} else {
			if (command.equals("exit")) {
				return command;
			}
			System.out.println("Please login.");
			return "escape";
		}
	}

	// ************************************************
	// *************** LOGIN METHODS ******************
	// ************************************************
	/**
	 * Authenticates a User
	 *
	 * @param userName The user's userName
	 * @param password The user's password
	 * @returns The matching User or null if no matching User found
	 */
	public static User authenticateUser(String userName, String password) {
		List<User> userList = userDb.getAll();

		for (User user : userList) {
			if (user.getUserName().equals(userName)) {
				if (user.getPassword().equals(password)) {
					System.out.println("Login successful.");
					return user;
				} else {
					System.out.println("Wrong password.");
					return null;
				}
			}
		}
		System.out.println("User not found");
		return null;
	}

	/**
	 * Prompts the user for a user name and password and passes the data to the
	 * authenticateUser method.
	 * 
	 * @return user
	 */
	public static User userLogin() {
		String userName = Console.getString("Username: ");
		String password = Console.getString("Password: ");
		return authenticateUser(userName, password);
	}

	// ***********************************************
	// *************** USER METHODS ******************
	// ***********************************************
	/**
	 * Outputs all of the users from the database.
	 */
	private static void listUsers() {
		List<User> users = userDb.getAll();

		System.out.println("\nUsers: ");
		for (User user : users) {
			System.out.println(user);
		}
	}

	/**
	 * Outputs a user based on a the user ID.
	 */
	private static void getUserById() {
		int id = Console.getInt("User ID: ");
		User user = userDb.get(id);

		if (user == null) {
			System.out.println("User not found.");
		} else {
			System.out.println("\n" + user);
		}
	}

	/**
	 * Prompts the user for the values of a user, creates a new user and adds it to
	 * the database.
	 */
	private static void addUser() {
		String userName = Console.getString("Username: ");
		String password = Console.getString("Password: ");
		String firstName = Console.getString("First Name: ");
		String lastName = Console.getString("Last Name: ");
		String phoneNumber = Console.getString("Phone Number: ");
		String email = Console.getString("Email: ");
		User newUser = new User(0, userName, password, firstName, lastName, phoneNumber, email, false, false);

		if (userDb.add(newUser)) {
			System.out.println("User added successfully.");
		} else {
			System.out.println("Error adding user.");
		}
	}

	/**
	 * Prompts the user for a user ID to delete and deletes the user from the
	 * database.
	 */
	private static void deleteUser() {
		int id = Console.getInt("User ID: ");
		if (userDb.delete(id)) {
			System.out.println("User deleted successfully.");
		} else {
			System.out.println("Error deleting user.");
		}
	}

	/**
	 * Prompts the user for the values of a user and updates the user at the user
	 * entered ID with the new user values.
	 */
	private static void updateUser() {
		int updateId = Console.getInt("ID to update: ");
		String newUserName = Console.getString("Username: ");
		String newPassword = Console.getString("Password: ");
		String newFirstName = Console.getString("First Name: ");
		String newLastName = Console.getString("Last Name: ");
		String newPhoneNumber = Console.getString("Phone Number: ");
		String newEmail = Console.getString("Email: ");
		String reviewer = Console.getString("Reviewer (true/false): ", "true", "false");
		Boolean isReviewer = Boolean.parseBoolean(reviewer);
		String admin = Console.getString("Admin (true/false): ", "true", "false");
		Boolean isAdmin = Boolean.parseBoolean(admin);
		User newUser = new User(updateId, newUserName, newPassword, newFirstName, newLastName, newPhoneNumber, newEmail,
				isReviewer, isAdmin);

		if (userDb.update(newUser)) {
			System.out.println("User updated successfully.");
		} else {
			System.out.println("Error updating user.");
		}
	}

	// ***********************************************
	// *************** VENDOR METHODS ****************
	// ***********************************************
	/**
	 * Outputs all of the vendors from the database.
	 */
	private static void listVendors() {
		List<Vendor> vendors = vendorDb.getAll();

		System.out.println("\nVendors: ");
		for (Vendor vendor : vendors) {
			System.out.println(vendor);
		}
	}

	/**
	 * Outputs a vendor based on the vendor ID.
	 */
	private static void getVendorById() {
		int id = Console.getInt("Vendor ID: ");
		Vendor vendor = vendorDb.get(id);

		if (vendor == null) {
			System.out.println("Vendor not found.");
		} else {
			System.out.println("\n" + vendor);
		}
	}

	/**
	 * Prompts the user for the values of a vendor, creates a new vendor and adds it
	 * to the database.
	 */
	private static void addVendor() {
		String code = Console.getString("Code: ");
		String name = Console.getString("Name: ");
		String address = Console.getString("Address: ");
		String city = Console.getString("City: ");
		String state = Console.getString("State: ");
		String zip = Console.getString("Zip: ");
		String phoneNumber = Console.getString("Phone Number: ");
		String email = Console.getString("Email: ");
		Vendor newVendor = new Vendor(0, code, name, address, city, state, zip, phoneNumber, email);

		if (vendorDb.add(newVendor)) {
			System.out.println("Vendor added successfully.");
		} else {
			System.out.println("Error adding vendor.");
		}
	}

	/**
	 * Prompts the user for a vendor ID to delete and deletes the vendor from the
	 * database.
	 */
	private static void deleteVendor() {
		int id = Console.getInt("Vendor ID: ");
		if (vendorDb.delete(id)) {
			System.out.println("Vendor deleted successfully.");
		} else {
			System.out.println("Error deleting vendor.");
		}
	}

	/**
	 * Prompts the user for the values of a vendor and updates the vendor at the
	 * vendor entered ID with the new vendor values.
	 */
	private static void updateVendor() {
		int updateId = Console.getInt("ID to update: ");
		String newCode = Console.getString("Code: ");
		String newName = Console.getString("Name: ");
		String newAddress = Console.getString("Address: ");
		String newCity = Console.getString("City: ");
		String newState = Console.getString("State: ");
		String newZip = Console.getString("Zip: ");
		String newPhoneNumber = Console.getString("Phone Number: ");
		String newEmail = Console.getString("Email: ");
		Vendor newVendor = new Vendor(updateId, newCode, newName, newAddress, newCity, newState, newZip, newPhoneNumber,
				newEmail);

		if (vendorDb.update(newVendor)) {
			System.out.println("Vendor updated successfully.");
		} else {
			System.out.println("Error updating vendor.");
		}
	}

	// ************************************************
	// *************** REQUEST METHODS ****************
	// ************************************************
	/**
	 * Outputs all of the requests from the database.
	 */
	private static void listRequests() {
		List<Request> requests = requestDb.getAll();

		System.out.println("\nRequests: ");
		for (Request request : requests) {
			System.out.println(request);
		}
	}

	/**
	 * Outputs a request based on the request ID.
	 */
	private static void getRequestById() {
		int id = Console.getInt("Request ID: ");
		Request request = requestDb.get(id);

		if (request == null) {
			System.out.println("Request not found.");
		} else {
			System.out.println("\n" + request);
		}
	}

	/**
	 * Prompts the user for the values of a request, creates a new request and adds
	 * it to the database.
	 */
	private static void addRequest() {
		int userId = Console.getInt("User ID: ");
		String description = Console.getString("Description: ");
		String justification = Console.getString("Justification: ");
		String date = Console.getString("Date Needed (YYYY-MM-DD): ");
		LocalDate dateNeeded = LocalDate.parse(date);
		String deliveryMode = Console.getString("Delivery Mode: ");
		String status = Console.getString("Status: ");
		Double total = Console.getDouble("Total: ");
//		String dateTime = Console.getString("Submitted Date (YYYY-MM-DDTHH:MM): ");
//		LocalDateTime submittedDate = LocalDateTime.parse(dateTime);
		LocalDateTime submittedDate = LocalDateTime.now();
		String rejectionReason = Console.getString("Rejection reason: ");
		Request newRequest = new Request(0, userId, description, justification, dateNeeded, deliveryMode, status, total,
				submittedDate, rejectionReason);

		if (requestDb.add(newRequest)) {
			System.out.println("Request added successfully.");
		} else {
			System.out.println("Error adding request.");
		}
	}

	/**
	 * Prompts the user for a request ID to delete and deletes the request from the
	 * database.
	 */
	private static void deleteRequest() {
		int id = Console.getInt("Request ID: ");
		if (requestDb.delete(id)) {
			System.out.println("Request deleted successfully.");
		} else {
			System.out.println("Error deleting request.");
		}
	}

	/**
	 * Prompts the user for the values of a product and updates the product at the
	 * user entered ID with the new product values.
	 */
	private static void updateRequest() {
		int updateId = Console.getInt("ID to update: ");
		int userId = Console.getInt("User ID: ");
		String description = Console.getString("Description: ");
		String justification = Console.getString("Justification: ");
		String date = Console.getString("Date Needed (YYYY-MM-DD): ");
		LocalDate dateNeeded = LocalDate.parse(date);
		String deliveryMode = Console.getString("Delivery Mode: ");
		String status = Console.getString("Status: ");
		Double total = Console.getDouble("Total: ");
//		String dateTime = Console.getString("Submitted Date (YYYY-MM-DDTHH:MM): ");
//		LocalDateTime submittedDate = LocalDateTime.parse(dateTime);
		LocalDateTime submittedDate = LocalDateTime.now();
		String rejectionReason = Console.getString("Rejection reason: ");
		Request newRequest = new Request(updateId, userId, description, justification, dateNeeded, deliveryMode, status,
				total, submittedDate, rejectionReason);

		if (requestDb.update(newRequest)) {
			System.out.println("Request updated successfully.");
		} else {
			System.out.println("Error updating request.");
		}
	}

	// ***********************************************
	// *************** PRODUCT METHODS ***************
	// ***********************************************
	/**
	 * Outputs all of the products from the database.
	 */
	private static void listProducts() {
		try {
			List<Product> products = productDb.getAll();

			System.out.println("\nProducts: ");
			for (Product product : products) {
				System.out.println(product);
			}
		} catch (PrsDataException e) {
			System.err.println("Couldn't retrieve products. Msg: " + e.getMessage());
		}
	}

	/**
	 * Outputs a product based on the product ID.
	 */
	private static void getProductById() {
		int id = Console.getInt("Product ID: ");
		Product product = productDb.get(id);

		if (product == null) {
			System.out.println("Product not found.");
		} else {
			System.out.println("\n" + product);
		}
	}

	/**
	 * Prompts the user for the values of a product, creates a new product and adds
	 * it to the database.
	 */
	private static void addProduct() {
		int vendorId = Console.getInt("Vendor ID: ");
		String partNumber = Console.getString("Part Number: ");
		String name = Console.getString("Product Name: ");
		Double price = Console.getDouble("Price: ");
		String unit = Console.getString("Unit: ");
		String photoPath = Console.getString("PhotoPath: ");
		Product newProduct = new Product(0, vendorId, partNumber, name, price, unit, photoPath);

		if (productDb.add(newProduct)) {
			System.out.println("Product added successfully.");
		} else {
			System.out.println("Error adding product");
		}
	}

	/**
	 * Prompts the user for a product ID to delete and deletes the product from the
	 * database.
	 */
	private static void deleteProduct() {
		int id = Console.getInt("Product ID: ");
		if (productDb.delete(id)) {
			System.out.println("Product deleted successfully.");
		} else {
			System.out.println("Error deleting product.");
		}
	}

	/**
	 * Prompts the user for the values of a product and updates the product at the
	 * user entered ID with the new product values.
	 */
	private static void updateProduct() {
		int updateId = Console.getInt("ID to update: ");
		int newVendorId = Console.getInt("Vendor ID: ");
		String newPartNumber = Console.getString("Part Number: ");
		String newName = Console.getString("Part Name: ");
		Double newPrice = Console.getDouble("Price: ");
		String newUnit = Console.getString("Unit: ");
		String newPhotoPath = Console.getString("PhotoPath: ");
		Product newProduct = new Product(updateId, newVendorId, newPartNumber, newName, newPrice, newUnit,
				newPhotoPath);

		if (productDb.update(newProduct)) {
			System.out.println("Product updated successfully.");
		} else {
			System.out.println("Error updating product.");
		}
	}

	// ****************************************************
	// *************** LINE ITEM METHODS ******************
	// ****************************************************
	/**
	 * Outputs all of the line items from the database.
	 */
	private static void listLineItems() {
		List<LineItem> lineItems = lineItemDb.getAll();

		System.out.println("\nLine Items: ");
		for (LineItem lineItem : lineItems) {
			System.out.println(lineItem);
		}
	}

	/**
	 * Outputs a line item based on the line item ID.
	 */
	private static void getLineItemById() {
		int id = Console.getInt("Line Item ID: ");
		LineItem lineItem = lineItemDb.get(id);

		if (lineItem == null) {
			System.out.println("Line Item not found.");
		} else {
			System.out.println("\n" + lineItem);
		}
	}

	/**
	 * Prompts the user for the values of a line item, creates a new line item and
	 * adds it to the database.
	 */
	private static void addLineItem() {
		int requestId = Console.getInt("Request ID: ");
		int productId = Console.getInt("Product ID: ");
		int quantity = Console.getInt("Quantity: ");
		LineItem lineItem = new LineItem(0, requestId, productId, quantity);

		if (lineItemDb.add(lineItem)) {
			System.out.println("Line item added successfully.");
		} else {
			System.out.println("Error adding line item");
		}
	}

	/**
	 * Prompts the user for a line item ID to delete and deletes the line item from
	 * the database.
	 */
	private static void deleteLineItem() {
		int id = Console.getInt("Line Item ID: ");
		if (lineItemDb.delete(id)) {
			System.out.println("Line item deleted successfully.");
		} else {
			System.out.println("Error deleting line item.");
		}
	}

	/**
	 * Prompts the user for the values of a line item and updates the line item at
	 * the user entered ID with the new line item values.
	 */
	private static void updateLineItem() {
		int updateId = Console.getInt("ID to update: ");
		int newRequestId = Console.getInt("Request ID: ");
		int newProductId = Console.getInt("Product ID: ");
		int newQuantity = Console.getInt("Quantity: ");
		LineItem lineItem = new LineItem(updateId, newRequestId, newProductId, newQuantity);

		if (lineItemDb.update(lineItem)) {
			System.out.println("Line item updated successfully.");
		} else {
			System.out.println("Error updating line item.");
		}
	}
}
