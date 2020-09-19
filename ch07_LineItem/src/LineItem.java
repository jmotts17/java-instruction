import java.text.NumberFormat;

public class LineItem {

	// Fields
	private Product product;
	private int quantity;

	// Constructors
	public LineItem() {
		this.product = null;
		this.quantity = 0;
	}

	public LineItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	// Setters and Getters
	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	// Helper Methods
	public double getTotal() {
		double total = product.getPrice() * quantity;
		return total;
	}

	public String getTotalFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.getTotal());
	}
}