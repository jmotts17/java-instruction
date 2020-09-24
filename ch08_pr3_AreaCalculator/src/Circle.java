
public class Circle extends Shape {

	// Field
	private double radius;

	// Constructor
	public Circle(double radius) {
		this.radius = radius;
	}

	// Getter & Setter for radius
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// Override of abstract method getArea
	@Override
	public double getArea() {
		return Math.PI * (radius * radius);
	}

}
