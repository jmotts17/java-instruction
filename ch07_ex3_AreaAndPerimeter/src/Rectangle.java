import java.text.NumberFormat;

public class Rectangle {

	// Fields
	private double length;
	private double width;

	// Constructors
	public Rectangle() {
		length = 0.0;
		width = 0.0;
	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	// Setters & Getters
	// Public as we want people to be able to get them/access them.
	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return this.length;
	}

	public double getWidth() {
		return this.width;
	}

	// Helper Methods
	public double getArea() {
		return this.length * this.width;
	}

	public String getAreaString() {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(3);
		return formatter.format(this.getArea());
	}

	public double getPerimeter() {
		return (2 * this.width) + (2 * this.length);
	}

	public String getPerimeterString() {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(3);
		return formatter.format(this.getPerimeter());
	}
}
