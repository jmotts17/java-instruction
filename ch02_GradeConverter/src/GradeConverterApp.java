import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		
		// Create Scanner object
		Scanner scanner = new Scanner(System.in);
		
		// Variable Declaration
		int grade;
		String prompt = "y";
		
		// Display Welcome Message
		System.out.println("Welcome to the Letter Grade Converter");
		
		while(prompt.equalsIgnoreCase("y")) {
			// Prompt user for a grade
			System.out.print("\nEnter a numerical grade: ");
			grade = scanner.nextInt();
			
			// Output letter grade
			if(grade >= 88) {
				System.out.println("Letter grade: A");
			} else if (grade >= 80) {
				System.out.println("Letter grade: B");
			} else if (grade >= 67) {
				System.out.println("Letter grade: C");
			} else if (grade >= 60) {
				System.out.println("Letter grade: D");
			} else {
				System.out.println("Letter grade: F");
			}
			
			// Prompt user to continue
			System.out.print("\nContinue? (y/n): ");
			prompt = scanner.next();
		}		

	}

}
