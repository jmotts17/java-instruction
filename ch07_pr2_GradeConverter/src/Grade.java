
public class Grade {

	// Field Declaration
	private int numberGrade;

	// Default Constructor
	public Grade() {
		numberGrade = 0;
	}

	// Constructor with one parameter
	public Grade(int numberGrade) {
		this.numberGrade = numberGrade;
	}

	// Getter & Setter
	public int getNumber() {
		return this.numberGrade;
	}

	public void setNumber(int numberGrade) {
		this.numberGrade = numberGrade;
	}

	// Helper Method - Returns the Letter Grade
	public String getLetter() {
		if (this.getNumber() >= 88) {
			return "A";
		} else if (this.getNumber() >= 80) {
			return "B";
		} else if (this.getNumber() >= 67) {
			return "C";
		} else if (this.getNumber() >= 60) {
			return "D";
		} else {
			return "F";
		}
	}

}