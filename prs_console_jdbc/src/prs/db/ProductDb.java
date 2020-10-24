package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.exception.PrsDataException;

public class ProductDb {

	// Constructor
	public ProductDb() {

	}

	/**
	 * Creates a connection with the database.
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	/**
	 * Creates and returns a product object based on the ResultSet.
	 * 
	 * @param rs
	 * @return Product
	 * @throws SQLException
	 */
	private Product getProductFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		int vendorId = rs.getInt("VendorID");
		String partNumber = rs.getString("PartNumber");
		String name = rs.getString("Name");
		double price = rs.getDouble("Price");
		String unit = rs.getString("Unit");
		String photoPath = rs.getString("PhotoPath");
		return new Product(id, vendorId, partNumber, name, price, unit, photoPath);
	}

	/**
	 * Returns a list of product objects that stores all the products from the
	 * database.
	 * 
	 * @return List of Products from Database
	 */
	public List<Product> getAll() {
		String selectAll = "SELECT * FROM Product";

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet products = statement.executeQuery(selectAll);) {

			List<Product> productList = new ArrayList<>();

			while (products.next()) {
				Product product = getProductFromResultSet(products);
				productList.add(product);
			}

			return productList;
		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products. Msg: " + e.getMessage());
		}
	}

	/**
	 * Takes a product ID and returns the product with that ID.
	 * 
	 * @param id
	 * @return Product based on ID
	 */
	public Product get(int id) {
		String productSelect = "SELECT * FROM Product WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productSelect);) {

			ps.setInt(1, id);
			ResultSet products = ps.executeQuery();

			if (products.next()) {
				Product product = getProductFromResultSet(products);
				products.close();
				return product;
			} else {
				products.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes in a product object and adds it to the database.
	 * 
	 * @param product
	 * @return true if successful or false if unsuccessful
	 */
	public boolean add(Product product) {
		String productInsert = "INSERT INTO Product(VendorID, PartNumber, Name, Price, Unit, PhotoPath)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productInsert);) {
			ps.setInt(1, product.getVendorId());
			ps.setString(2, product.getPartNumber());
			ps.setString(3, product.getName());
			ps.setDouble(4, product.getPrice());
			ps.setString(5, product.getUnit());
			ps.setString(6, product.getPhotoPath());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in an ID and deletes the product that corresponds with that ID from the
	 * database.
	 * 
	 * @param id
	 * @return true if successful or false if unsuccessful
	 */
	public boolean delete(int id) {
		String productDelete = "DELETE FROM Product WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productDelete);) {
			ps.setInt(1, id);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in a new product and updates a current product based on the product ID.
	 * 
	 * @param product
	 * @return true if successful or false if unsuccessful
	 */
	public boolean update(Product product) {
		String productUpdate = "UPDATE product SET VendorId = ?, PartNumber = ?, Name = ?, Price = ?, Unit = ?, PhotoPath = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productUpdate);) {
			ps.setInt(1, product.getVendorId());
			ps.setString(2, product.getPartNumber());
			ps.setString(3, product.getName());
			ps.setDouble(4, product.getPrice());
			ps.setString(5, product.getUnit());
			ps.setString(6, product.getPhotoPath());
			ps.setInt(7, product.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

}
