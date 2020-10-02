
public abstract class Player {

	// Fields
	private String name;
	private RoshamboEnum roshVal;

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

}