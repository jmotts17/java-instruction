
public abstract class Player {

	// Fields
	private String name;
	private RoshamboEnum roshVal;
	protected int score;

	// Constructors
	public Player() {
		name = "";
	}

	public Player(String name) {
		this.name = name;
	}

	// Abstract Method
	public abstract void generateRoshambo();

	// Getters & Setters
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoshamboEnum getRoshVal() {
		return this.roshVal;
	}

	public void setRoshVal(RoshamboEnum roshVal) {
		this.roshVal = roshVal;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}