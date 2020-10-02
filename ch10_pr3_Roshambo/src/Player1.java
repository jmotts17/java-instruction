
public class Player1 extends Player {

	// Constructors
	public Player1() {
		setName("");
	}

	public Player1(String name) {
		setName(name);
	}

	// Override of abstract method generateRoshambo
	@Override
	public void generateRoshambo() {
		setRoshVal(RoshamboEnum.ROCK);
	}

}
