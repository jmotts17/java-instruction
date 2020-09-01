import java.util.Scanner;

public class StringApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the String App!");
		
		String firstName = "Bob";
		String lastName = "Marley";
		
		System.out.println("Hello, " + firstName + " " + lastName);
		
		String fullName = firstName;
		System.out.println("fullName = " + fullName);
		fullName = fullName + " ";
		System.out.println("fullName = " + fullName);
		fullName += lastName;
		System.out.println("fullName = " + fullName);
		
		System.out.println("This is a sentance that\n" 
				+ " is on 2 lines");
		
		System.out.print("\nEnter a name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("You entered: " + name);
		
		sc.nextLine();
		
		System.out.print("\nEnter a sentence: ");
		String sentence = sc.nextLine();
		System.out.println("You entered: " + sentence);
				
		// Get numbers from the user
		System.out.print("\nEnter a whole number: ");
		int i = sc.nextInt();
		System.out.println("You entered: " + i);
		
		// Get numbers from the user
		System.out.print("\nEnter a decimal number: ");
		double d = sc.nextDouble();
		System.out.println("You entered: " + d);
		
		// Use relational operators
		if (i > 10) {
			System.out.println("\ni is greater than 10!");
		}
		
		// while loop
		System.out.println("\nDo you want to continune? (y/n)");
		String choice = sc.next();
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("continue? (y/n)");
			choice = sc.next();
		}
		
		System.out.println("Goodbye!");
		
	}

}
