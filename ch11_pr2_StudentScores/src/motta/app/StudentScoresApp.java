package motta.app;

import java.util.Arrays;

public class StudentScoresApp {

	public static void main(String[] args) {

		// Output welcome message
		System.out.println("The Student Scores Application");

		// Prompt user for the number of students
		int numOfStudents = Console.getInt("\nNumber of students: ", 0, 501);

		// Create an array that stores student objects
		Student[] students = new Student[numOfStudents];

		// For loop iterates for the number of students
		for (int i = 0; i < students.length; ++i) {
			// Creates a new student based on promptForStudent method
			Student student = promptForStudent(i);
			// Adds the student to the students array
			students[i] = student;
		}

		// Displays the student summary
		outputStudentSummary(students);

	}

	/**
	 * Prompts user for the last name, first name and score of the student.
	 * 
	 * @param i
	 * @return a student based on user input
	 */
	private static Student promptForStudent(int i) {
		i++;
		System.out.println("\nSTUDENT " + i);
		String lastName = Console.getString("Last name: ");
		String firstName = Console.getString("First name: ");
		int score = Console.getInt("Score: ", -1, 101);

		return new Student(firstName, lastName, score);
	}

	/**
	 * Outputs the student summary based on the students array. Calls the arrays
	 * sort method to sort by last name.
	 * 
	 * @param students
	 */
	private static void outputStudentSummary(Student[] students) {
		Arrays.sort(students);
		System.out.println("\nSUMMARY");
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
