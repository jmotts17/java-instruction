
public class Die {

	// Field declaration
	private int dieValue;

	// Default constructor
	public Die() {
		dieValue = 0;
	}

	// Helper Method - Rolls the dice
	public void roll() {
		dieValue = (int) (Math.random() * 6) + 1;
	}

	// Getter - Gets the die value
	public int getValue() {
		return dieValue;
	}
}
