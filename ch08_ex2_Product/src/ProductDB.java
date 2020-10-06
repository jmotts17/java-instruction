import java.util.HashMap;
import java.util.Map;

public class ProductDB {

	public static Product getProductFromMap(String productCode) {

		Map<String, Product> items = new HashMap<>();

		Book javaBook = new Book();
		javaBook.setCode("java");
		javaBook.setDescription("Murach's Java Programming");
		javaBook.setPrice(57.50);
		javaBook.setAuthor("Joel Murach");
		items.put("java", javaBook);

		Book jspBook = new Book();
		jspBook.setCode("jsp");
		jspBook.setDescription("Murach's Java Servlets and JSP");
		jspBook.setPrice(57.50);
		jspBook.setAuthor("Mike Urban");
		items.put("jsp", jspBook);

		Book mysqlBook = new Book();
		mysqlBook.setCode("mysql");
		mysqlBook.setDescription("Murach's MySQL");
		mysqlBook.setPrice(54.50);
		mysqlBook.setAuthor("Joel Murach");
		items.put("mysql", mysqlBook);

		Software netbeans = new Software();
		netbeans.setCode("netbeans");
		netbeans.setDescription("NetBeans");
		netbeans.setPrice(0.00);
		netbeans.setVersion("8.2");
		items.put("netbeans", netbeans);

		return items.get(productCode);

	}

	public static Product getProduct(String productCode) {
		// In a more realistic application, this code would
		// get the data for the product from a file or database
		// For now, this code just uses if/else statements
		// to return the correct product data

		Product p = null;

		if (productCode.equalsIgnoreCase("java") || productCode.equalsIgnoreCase("jsp")
				|| productCode.equalsIgnoreCase("mysql")) {
			Book b = new Book();
			if (productCode.equalsIgnoreCase("java")) {
				b.setCode(productCode);
				b.setDescription("Murach's Java Programming");
				b.setPrice(57.50);
				b.setAuthor("Joel Murach");
			} else if (productCode.equalsIgnoreCase("jsp")) {
				b.setCode(productCode);
				b.setDescription("Murach's Java Servlets and JSP");
				b.setPrice(57.50);
				b.setAuthor("Mike Urban");
			} else if (productCode.equalsIgnoreCase("mysql")) {
				b.setCode(productCode);
				b.setDescription("Murach's MySQL");
				b.setPrice(54.50);
				b.setAuthor("Joel Murach");
			}
			p = b; // set Product object equal to the Book object
		} else if (productCode.equalsIgnoreCase("netbeans")) {
			Software s = new Software();
			s.setCode("netbeans");
			s.setDescription("NetBeans");
			s.setPrice(0.00);
			s.setVersion("8.2");
			p = s; // set Product object equal to the Software object
		}
		return p;
	}
}
