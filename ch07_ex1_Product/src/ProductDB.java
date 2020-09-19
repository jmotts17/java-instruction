public class ProductDB {

	public Product getProduct(String productCode) {
		// In a more realistic application, this code would
		// get the data for the product from a file or database
		// For now, this code just uses if/else statements
		// to return the correct product data

		// create the Product object
		Product product;

//		if (productCode.equalsIgnoreCase("java")) {
//			product = new Product("java", "Murach's Java Programming", 57.50);
//		} else if (productCode.equalsIgnoreCase("jsp")) {
//			product = new Product("jsp", "Murach's Java Servlets and JSP", 57.50);
//		} else if (productCode.equalsIgnoreCase("mysql")) {
//			product = new Product("mysql", "Murach's MySQL", 54.50);
//		} else if (productCode.equalsIgnoreCase("html")) {
//			product = new Product("html", "Murach's HTML", 49.99);
//		} else {
//			product = new Product();
//			product.setCode(productCode);
//			product.setDescription("Unknown");
//		}

		// If-Else as a switch
		switch (productCode.toUpperCase()) {
		case "JAVA":
			product = new Product("java", "Murach's Java Programming", 57.50);
			break;
		case "JSP":
			product = new Product("jsp", "Murach's Java Servlets and JSP", 57.50);
			break;
		case "MYSQL":
			product = new Product("mysql", "Murach's MySQL", 54.50);
			break;
		case "HTML":
			product = new Product("html", "Murach's HTML", 49.99);
			break;
		default:
			product = new Product();
			product.setCode(productCode);
			product.setDescription("Unknown");
			break;
		}

		return product;
	}
}