package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Vendor;

public class VendorDb extends DbAbstract implements DbInterface<Vendor> {

	// Constructor
	public VendorDb() {

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
	 * Creates and returns a vendor based on the ResultSet.
	 * 
	 * @param rs
	 * @return Vendor
	 * @throws SQLException
	 */
	private Vendor getVendorFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		String code = rs.getString("Code");
		String name = rs.getString("Name");
		String address = rs.getString("Address");
		String city = rs.getString("City");
		String state = rs.getString("State");
		String zip = rs.getString("Zip");
		String phoneNumber = rs.getString("PhoneNumber");
		String email = rs.getString("Email");
		return new Vendor(id, code, name, address, city, state, zip, phoneNumber, email);
	}

	/**
	 * Returns a list of vendor objects that stores all the vendors from the
	 * database.
	 * 
	 * @return List of Vendors from Database
	 */
	@Override
	public List<Vendor> getAll() {
		String selectAll = "SELECT * FROM Vendor";

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet vendors = statement.executeQuery(selectAll);) {

			List<Vendor> vendorList = new ArrayList<>();

			while (vendors.next()) {
				Vendor vendor = getVendorFromResultSet(vendors);
				vendorList.add(vendor);
			}

			return vendorList;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes a vendor ID and returns the vendor with that ID.
	 * 
	 * @param id
	 * @return Vendor based on ID
	 */
	@Override
	public Vendor get(int id) {
		String vendorSelect = "SELECT * FROM Vendor WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorSelect);) {
			ps.setInt(1, id);
			ResultSet vendors = ps.executeQuery();

			if (vendors.next()) {
				Vendor vendor = getVendorFromResultSet(vendors);
				vendors.close();
				return vendor;
			} else {
				vendors.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes in a vendor object and adds it to the database.
	 * 
	 * @param vendor
	 * @return true if successful or false if unsuccessful
	 */
	@Override
	public boolean add(Vendor vendor) {
		String vendorInsert = "INSERT INTO Vendor(Code, Name, Address, City, State, Zip, PhoneNumber, Email)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorInsert);) {

			ps.setString(1, vendor.getCode());
			ps.setString(2, vendor.getName());
			ps.setString(3, vendor.getAddress());
			ps.setString(4, vendor.getCity());
			ps.setString(5, vendor.getState());
			ps.setString(6, vendor.getZip());
			ps.setString(7, vendor.getPhoneNumber());
			ps.setString(8, vendor.getEmail());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in an ID and deletes the vendor that corresponds with that ID from the
	 * database.
	 * 
	 * @param id
	 * @return true if successful or false if unsuccessful
	 */
	@Override
	public boolean delete(int id) {
		String vendorDelete = "DELETE FROM Vendor WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorDelete);) {
			ps.setInt(1, id);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in a new vendor and updates a current vendor based on the vendor ID.
	 * 
	 * @param vendor
	 * @return true if successful or false if unsuccessful
	 */
	@Override
	public boolean update(Vendor vendor) {
		String vendorUpdate = "UPDATE Vendor SET Code = ?, Name = ?, Address = ?, City = ?, State = ?,"
				+ " Zip = ?, PhoneNumber = ?, Email = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorUpdate);) {
			ps.setString(1, vendor.getCode());
			ps.setString(2, vendor.getName());
			ps.setString(3, vendor.getAddress());
			ps.setString(4, vendor.getCity());
			ps.setString(5, vendor.getState());
			ps.setString(6, vendor.getZip());
			ps.setString(7, vendor.getPhoneNumber());
			ps.setString(8, vendor.getEmail());
			ps.setInt(9, vendor.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

}
