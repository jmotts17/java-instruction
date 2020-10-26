package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import prs.business.Request;

public class RequestDb {

	// Constructor
	public RequestDb() {

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
	 * Creates and returns a request based on the ResultSet.
	 * 
	 * @param rs
	 * @return Request
	 * @throws SQLException
	 */
	private Request getRequestFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		int userId = rs.getInt("UserID");
		String description = rs.getString("Description");
		String justification = rs.getString("Justification");
		String date = rs.getString("DateNeeded");
		LocalDate dateNeeded = LocalDate.parse(date);
		String deliveryMode = rs.getString("DeliveryMode");
		String status = rs.getString("Status");
		Double total = rs.getDouble("Total");
		LocalDateTime submittedDate = rs.getObject("SubmittedDate", LocalDateTime.class);
		String rejectionReason = rs.getString("ReasonForRejection");

		return new Request(id, userId, description, justification, dateNeeded, deliveryMode, status, total,
				submittedDate, rejectionReason);
	}

	/**
	 * Returns a list of request objects that stores all the requests from the
	 * database.
	 * 
	 * @return List of Requests from Database
	 */
	public List<Request> getAll() {
		String selectAll = "SELECT * FROM Request";

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet requests = statement.executeQuery(selectAll);) {

			List<Request> requestList = new ArrayList<>();

			while (requests.next()) {
				Request request = getRequestFromResultSet(requests);
				requestList.add(request);
			}

			return requestList;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes a request ID and returns the request with that ID.
	 * 
	 * @param id
	 * @return Request based on ID
	 */
	public Request get(int id) {
		String requestSelect = "SELECT * FROM Request WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestSelect);) {
			ps.setInt(1, id);
			ResultSet requests = ps.executeQuery();

			if (requests.next()) {
				Request request = getRequestFromResultSet(requests);
				requests.close();
				return request;
			} else {
				requests.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	/**
	 * Takes in a request object and adds it to the database.
	 * 
	 * @param request
	 * @return true if successful or false if unsuccessful
	 */
	public boolean add(Request request) {
		String requestInsert = "INSERT INTO Request(UserId, Description, Justification, DateNeeded, DeliveryMode, Status, Total,"
				+ " SubmittedDate, ReasonForRejection)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestInsert);) {

			ps.setInt(1, request.getUserId());
			ps.setString(2, request.getDescription());
			ps.setString(3, request.getJustification());
			ps.setDate(4, java.sql.Date.valueOf(request.getDateNeeded()));
			ps.setString(5, request.getDeliveryMode());
			ps.setString(6, request.getStatus());
			ps.setDouble(7, request.getTotal());
			ps.setTimestamp(8, java.sql.Timestamp.valueOf(request.getSubmittedDate()));
			ps.setString(9, request.getRejectionReason());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in an ID and deletes the request that corresponds with that ID from the
	 * database.
	 * 
	 * @param id
	 * @return true if successful or false if unsuccessful
	 */
	public boolean delete(int id) {
		String requestDelete = "DELETE FROM Request WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestDelete);) {
			ps.setInt(1, id);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	/**
	 * Takes in a new request and updates a current request based on the request ID.
	 * 
	 * @param request
	 * @return true if successful or false if unsuccessful
	 */
	public boolean update(Request request) {
		String requestUpdate = "UPDATE Request SET UserId = ?, Description = ?, Justification = ?, DateNeeded = ?, DeliveryMode = ?,"
				+ "Status = ?, Total = ?, SubmittedDate = ?, ReasonForRejection = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestUpdate);) {
			ps.setInt(1, request.getUserId());
			ps.setString(2, request.getDescription());
			ps.setString(3, request.getJustification());
			ps.setDate(4, java.sql.Date.valueOf(request.getDateNeeded()));
			ps.setString(5, request.getDeliveryMode());
			ps.setString(6, request.getStatus());
			ps.setDouble(7, request.getTotal());
			ps.setTimestamp(8, java.sql.Timestamp.valueOf(request.getSubmittedDate()));
			ps.setString(9, request.getRejectionReason());
			ps.setInt(10, request.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

}
