
public enum RoshamboEnum {

	ROCK, PAPER, SCISSORS;

	@Override
	public String toString() {

		if (this.ordinal() == 0) {
			return "rock";
		} else if (this.ordinal() == 1) {
			return "paper";
		} else if (this.ordinal() == 2) {
			return "scissors";
		} else {
			return "N/A";
		}
	}

}
