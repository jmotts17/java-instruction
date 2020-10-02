
public class Lisa extends Player {

	// Constructor
	public Lisa() {
		setName("Lisa");
		setRoshVal(RoshamboEnum.ROCK);
	}

	// Override of abstract method generateRoshambo
	@Override
	public void generateRoshambo() {

		RoshamboEnum roshEnum = RoshamboEnum.ROCK;
		int randomNum = 1 + (int) (Math.random() * 3);

		if (randomNum == 1) {
			roshEnum = RoshamboEnum.ROCK;
		} else if (randomNum == 2) {
			roshEnum = RoshamboEnum.PAPER;
		} else if (randomNum == 3) {
			roshEnum = RoshamboEnum.SCISSORS;
		}

		setRoshVal(roshEnum);
	}

}
