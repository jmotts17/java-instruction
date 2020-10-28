package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.LineItem;

public class LineItemDb extends DbAbstract implements DbInterface<LineItem> {

	// Constructor
	public LineItemDb() {

	}

//	/**
//	 * Creates a connection with the database.
//	 * 
//	 * @return Connection
//	 * @throws SQLException
//	 */
//	private Connection getConnection() throws SQLException {
//		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
//		String username = "prs_user";
//		String password = "sesame";
//
//		Connection connection = DriverManager.getConnection(dbURL, username, password);
//
//		return connection;
//	}

	/**
	 * Creates and returns a line item based on the ResultSet.
	 * 
	 * @param rs
	 * @return LineItem
	 * @throws SQLException
	 */
	private LineItem getLineItemFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		int requestId = rs.getInt("RequestID");
		int productId = rs.getInt("ProductID");
		int quantity = rs.getInt("Quantity");

		return new LineItem(id, requestId, productId, quantity);
	}

	/**
	 * Returns a list of line item objects that stores all the line items from the
	 * database.
	 * 
	 * @return List of Line Items from Database
	 */
	@Override
	public List<LineItem> getAll() {
		String selectAll = "SELECT * FROM LineItem";

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet lineItems = statement.executeQuery(selectAll);) {

			List<LineItem> lineItemList = new ArrayList<>();

			while (lineItems.next()) {
				LineItem lineItem = getLineItemFromResultSet(lineItems);
				lineItemList.add(lineItem);
			}

			return lineItemList;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes a line item ID and returns the line item with that ID.
	 * 
	 * @param id
	 * @return LineItem based on ID
	 */
	@Override
	public LineItem get(int id) {
		String lineItemSelect = "SELECT * FROM LineItem WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemSelect);) {
			ps.setInt(1, id);
			ResultSet lineItems = ps.executeQuery();

			if (lineItems.next()) {
				LineItem lineItem = getLineItemFromResultSet(lineItems);
				lineItems.close();
				return lineItem;
			} else {
				lineItems.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes in a line item object and adds it to the database.
	 * 
	 * @param lineItem
	 * @return true if successful or false if unsuccessful
	 */
	@Override
	public boolean add(LineItem lineItem) {
		String lineItemInsert = "INSERT INTO LineItem(RequestID, ProductID, Quantity)" + " VALUES (?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemInsert);) {

			ps.setInt(1, lineItem.getRequestId());
			ps.setInt(2, lineItem.getProductId());
			ps.setInt(3, lineItem.getQuantity());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in an ID and deletes the line item that corresponds with that ID from
	 * the database.
	 * 
	 * @param id
	 * @return true if successful or false if unsuccessful
	 */
	@Override
	public boolean delete(int id) {
		String lineItemDelete = "DELETE FROM LineItem WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemDelete);) {
			ps.setInt(1, id);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in a new line item and updates a current line item based on the line
	 * item ID.
	 * 
	 * @param lineItem
	 * @return true if successful or false if unsuccessful
	 */
	@Override
	public boolean update(LineItem lineItem) {
		String lineItemUpdate = "UPDATE LineItem SET RequestID = ?, ProductID = ?, Quantity = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemUpdate);) {
			ps.setInt(1, lineItem.getRequestId());
			ps.setInt(2, lineItem.getProductId());
			ps.setInt(3, lineItem.getQuantity());
			ps.setInt(4, lineItem.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

}
