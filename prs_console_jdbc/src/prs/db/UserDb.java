package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.User;

public class UserDb {

	// Constructor
	public UserDb() {

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
	 * Creates and returns a user object based on the ResultSet.
	 * 
	 * @param rs
	 * @return User
	 * @throws SQLException
	 */
	private User getUserFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		String userName = rs.getString("UserName");
		String password = rs.getString("Password");
		String firstName = rs.getString("FirstName");
		String lastName = rs.getString("LastName");
		String phoneNumber = rs.getString("PhoneNumber");
		String email = rs.getString("Email");
		boolean isReviewer = rs.getBoolean("IsReviewer");
		boolean isAdmin = rs.getBoolean("isAdmin");
		return new User(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
	}

	/**
	 * Returns a list of user objects that stores all the users from the database.
	 * 
	 * @return List of Users from Database
	 */
	public List<User> getAll() {
		String selectAll = "SELECT * FROM User";

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet users = statement.executeQuery(selectAll);) {

			List<User> userList = new ArrayList<>();

			while (users.next()) {
				User user = getUserFromResultSet(users);
				userList.add(user);
			}

			return userList;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes a user ID and returns the user with that ID.
	 * 
	 * @param id
	 * @return User based on ID
	 */
	public User get(int id) {
		String userSelect = "SELECT * FROM User WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userSelect);) {
			ps.setInt(1, id);
			ResultSet users = ps.executeQuery();

			if (users.next()) {
				User user = getUserFromResultSet(users);
				users.close();
				return user;
			} else {
				users.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes in a user object and adds it to the database.
	 * 
	 * @param user
	 * @return true if successful or false if unsuccessful
	 */
	public boolean add(User user) {
		String userInsert = "INSERT INTO User(UserName, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userInsert);) {
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setBoolean(7, user.isReviewer());
			ps.setBoolean(8, user.isAdmin());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in an ID and deletes the user that corresponds with that ID from the
	 * database.
	 * 
	 * @param id
	 * @return true if successful or false if unsuccessful
	 */
	public boolean delete(int id) {
		String userDelete = "DELETE FROM User WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userDelete);) {
			ps.setInt(1, id);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in a new user and updates a current user based on the user ID.
	 * 
	 * @param user
	 * @return true if successful or false if unsuccessful
	 */
	public boolean update(User user) {
		String userUpdate = "UPDATE user SET UserName = ?, Password = ?, FirstName = ?, LastName = ?, PhoneNumber = ?, Email = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userUpdate);) {
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

}
