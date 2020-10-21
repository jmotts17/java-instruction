package bmdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bmdb.business.Actor;

public class ActorDb {

	/**
	 * Creates a connection with the database.
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "bmdb_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	/**
	 * Creates & Returns an actor object based on the result set.
	 * 
	 * @param rs
	 * @return Actor
	 * @throws SQLException
	 */
	private Actor getActorFromResultSet(ResultSet rs) throws SQLException {
		long id = rs.getLong("ID");
		String firstName = rs.getString("FirstName");
		String lastName = rs.getString("LastName");
		String gender = rs.getString("Gender");
		String birthDate = rs.getString("BirthDate");

		return new Actor(id, firstName, lastName, gender, LocalDate.parse(birthDate));
	}

	/**
	 * Outputs all the actors from the database.
	 * 
	 * @return List<Actor>
	 */
	public List<Actor> getAll() {
		List<Actor> actorList = new ArrayList<>();

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet actors = statement.executeQuery("SELECT * FROM Actor");) {

			while (actors.next()) {
				Actor actor = getActorFromResultSet(actors);
				actorList.add(actor);
			}
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

		return actorList;
	}

	/**
	 * Returns an actor based on their last name.
	 * 
	 * @param lastName
	 * @return Actor
	 */
	public Actor get(String lastName) {
		String actorSelect = "SELECT * FROM Actor WHERE LastName ='" + lastName + "'";

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet actors = statement.executeQuery(actorSelect);) {

			if (actors.next()) {
				Actor actor = getActorFromResultSet(actors);
				return actor;
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

}