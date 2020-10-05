import java.util.ArrayList;

public class WizardInventoryApp {

	public static void main(String[] args) {

		// Variable declaration
		String choice;

		// Create a Wizard Inventory and add 3 items
		ArrayList<String> inventory = new ArrayList<>();
		inventory.add("wooden staff");
		inventory.add("wizard hat");
		inventory.add("cloth shoes");

		// Output welcome message
		System.out.println("The Wizard Inventory Game");

		do {
			displayMenu();
			choice = Console.getString("\nCommand: ");

			switch (choice.toLowerCase()) {
			case "show":
				showInventory(inventory);
				break;
			case "grab":
				grabItem(inventory);
				break;
			case "edit":
				editItem(inventory);
				break;
			case "drop":
				dropItem(inventory);
				break;
			case "exit":
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Invalid option");
				break;
			}

		} while (!choice.equalsIgnoreCase("exit"));

	}

	/**
	 * Outputs the menu to the user.
	 */
	private static void displayMenu() {
		System.out.println("\nCOMMAND MENU");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit Program");
	}

	/**
	 * Shows the current inventory of items.
	 * 
	 * @param inventory
	 */
	private static void showInventory(ArrayList<String> inventory) {
		for (int i = 0; i <= inventory.size() - 1; i++) {
			int count = i + 1;
			System.out.println(count + ". " + inventory.get(i));
		}
	}

	/**
	 * Prompts the user to enter an item for the wizard to grab. Displays an error
	 * if the inventory already has 4 items.
	 * 
	 * @param inventory
	 * @return
	 */
	private static ArrayList<String> grabItem(ArrayList<String> inventory) {
		if (inventory.size() >= 4) {
			System.out.println("You can't carry any more items. Drop something first.");
		} else {
			String newItem = Console.getString("Name: ");
			inventory.add(newItem);
			System.out.println(newItem + " was added.");
		}
		return inventory;
	}

	/**
	 * Prompts the user to enter a number of an item that they want to edit. Outputs
	 * a confirmation if the item is successfully edited.
	 * 
	 * @param inventory
	 * @return
	 */
	private static ArrayList<String> editItem(ArrayList<String> inventory) {
		int itemIndex = Console.getInt("Number: ", 0, 5);
		int itemNumber = itemIndex--;
		String updatedItem = Console.getString("Updated name: ");
		inventory.set(itemIndex, updatedItem);
		System.out.println("Item number " + itemNumber + " was updated.");
		return inventory;
	}

	/**
	 * Prompts the user to enter a number of an itme they want to drop. Outputs a
	 * confirmation message letting the user know their item was successfully
	 * dropped.
	 * 
	 * @param inventory
	 * @return
	 */
	private static ArrayList<String> dropItem(ArrayList<String> inventory) {
		int itemIndex = Console.getInt("Number: ", 0, 5);
		itemIndex--;
		String itemRemoved = inventory.remove(itemIndex);
		System.out.println(itemRemoved + " was dropped.");
		return inventory;
	}

}
