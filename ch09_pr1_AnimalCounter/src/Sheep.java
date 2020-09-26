
public class Sheep extends Animal implements Cloneable {

	// Field
	private String name;

	// Constructors
	public Sheep() {
		name = "";
	}

	public Sheep(String name) {
		this.name = name;
	}

	// Getter & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Override clone
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// Override getCountString
	@Override
	public String getCountString() {
		return super.getCount() + " " + name;
	}

}
