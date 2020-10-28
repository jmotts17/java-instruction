package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbAbstract {

	/**
	 * Creates a connection with the database.
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	protected Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

}
