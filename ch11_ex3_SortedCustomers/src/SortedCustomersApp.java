import java.util.Arrays;

public class SortedCustomersApp {

	public static void main(String[] args) {

		Customer[] customers = new Customer[3];
		customers[0] = new Customer("JoshMotta@email.com", "Josh", "Motta");
		customers[1] = new Customer("JoannaLang@email.com", "Joanna", "Motta");
		customers[2] = new Customer("FinnMan@email.com", "Finn", "Man");

		System.out.println("Unsorted array\n");
		for (Customer customer : customers) {
			System.out.println(customer.toString());
			System.out.println();
		}

		Arrays.sort(customers);

		System.out.println("\nSorted array\n");
		for (Customer customer : customers) {
			System.out.println(customer.toString());
			System.out.println();
		}

	}
}
