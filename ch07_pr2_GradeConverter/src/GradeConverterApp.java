
public class GradeConverterApp {

	public static void main(String[] args) {

		// Output welcome message
		System.out.println("Welcome to the Letter Grade Converter");

		// Variable declaration
		String choice;

		do {

			int numberGrade = Console.getInt("\nEnter numerical grade: ");
			Grade grade = new Grade(numberGrade);
			System.out.println("Letter Grade: " + grade.getLetter());

			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));
	}

}
