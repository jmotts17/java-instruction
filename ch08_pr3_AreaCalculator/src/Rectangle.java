
public class Rectangle extends Square {

	// Field
	private double height;

	// Constructor
	public Rectangle(double width, double height) {
		super(width);
		this.height = height;
	}

	// Getter & Setter
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// Override of abstract method getArea
	@Override
	public double getArea() {
		return (super.getWidth() * this.height);
	}

}
