
public class Bart extends Player {

	// Constructor
	public Bart() {
		setName("Bart");
		setRoshVal(RoshamboEnum.ROCK);
	}

	// Override of abstract method generateRoshambo
	@Override
	public void generateRoshambo() {
		setRoshVal(RoshamboEnum.ROCK);
	}

}
