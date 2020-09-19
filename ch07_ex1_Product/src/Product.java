import java.text.NumberFormat;

public class Product {

	// Fields, aka member varaibles, aka instance variables
	private String code;
	private String description;
	private double price;

	// Static variables
	private static int instanceCount = 0;

	// Default Constructor
	public Product() {
		code = "";
		description = "";
		price = 0;

		instanceCount++;
	}

	// Constructor with 3 params
	public Product(String code, String description, double price) {
		this.code = code;
		this.description = description;
		this.price = price;

		instanceCount++;
	}

	// Getters and Setters
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	// Helper methods
	public String getPriceFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}

	public String getPriceNumberFormat() {
		NumberFormat decimal = NumberFormat.getNumberInstance();
		decimal.setMinimumFractionDigits(2);
		decimal.setMaximumFractionDigits(2);
		return decimal.format(price);
	}

	// Static methods
	public static int getInstanceCount() {
		return instanceCount;
	}
}