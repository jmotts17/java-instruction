package motta.app;

public class Student implements Comparable<Object> {

	// Field declarations
	private String firstName;
	private String lastName;
	private int score;

	public Student() {
		firstName = "";
		lastName = "";
		score = 0;
	}

	public Student(String firstName, String lastName, int score) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// Override of the toString method
	@Override
	public String toString() {
		return (lastName + ", " + firstName + ": " + score);
	}

	// Override of the compareTo method
	@Override
	public int compareTo(Object o) {
		Student student2 = (Student) o;

		if (this.getLastName().compareToIgnoreCase(student2.getLastName()) < 0) {
			return -1;
		} else if (this.getLastName().compareToIgnoreCase(student2.getLastName()) > 0) {
			return 1;
		} else if (this.getFirstName().compareToIgnoreCase(student2.getFirstName()) < 0) {
			return -1;
		} else if (this.getFirstName().compareToIgnoreCase(student2.getFirstName()) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
