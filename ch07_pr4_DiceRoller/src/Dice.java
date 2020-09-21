
public class Dice {

	// Field declaration
	private Die die1;
	private Die die2;

	// Default constructor
	public Dice() {
		die1 = new Die();
		die2 = new Die();
	}

	// Getters - Returns die1 & die 2 value
	public int getDie1Value() {
		return die1.getValue();
	}

	public int getDie2Value() {
		return die2.getValue();
	}

	// Helper method - Returns the sum of die1 & die2
	public int getSum() {
		return (die1.getValue() + die2.getValue());
	}

	// Helper method - Rolls die1 & die2
	public void roll() {
		die1.roll();
		die2.roll();
	}

	// Outputs the results of the rolls
	public void printRoll() {
		System.out.println("\nDie1: " + die1.getValue() + "\nDie2: " + die2.getValue() + "\nTotal: " + getSum());

		if (die1.getValue() == 1 && die2.getValue() == 1) {
			System.out.println("Snake Eyes!");
		} else if (die1.getValue() == 6 && die2.getValue() == 6) {
			System.out.println("Box Cars!");
		} else if (die1.getValue() + die2.getValue() == 7) {
			System.out.println("Craps!");
		}

	}
}
