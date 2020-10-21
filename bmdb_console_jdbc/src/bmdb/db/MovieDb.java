package bmdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bmdb.business.Movie;

public class MovieDb {

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
	 * Creates & Returns a movie object based on the result set.
	 * 
	 * @param rs
	 * @return Movie
	 * @throws SQLException
	 */
	private Movie getMovieFromResultSet(ResultSet rs) throws SQLException {
		long id = rs.getLong("ID");
		String title = rs.getString("Title");
		int year = rs.getInt("Year");
		String rating = rs.getString("Rating");
		String director = rs.getString("Director");

		return new Movie(id, title, year, rating, director);
	}

	/**
	 * Outputs all the movies from the database.
	 * 
	 * @return List<Movie>
	 */
	public List<Movie> getAll() {
		List<Movie> movieList = new ArrayList<>();

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet movies = statement.executeQuery("SELECT * FROM Movie");) {

			while (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);
				movieList.add(movie);
			}
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

		return movieList;
	}

	/**
	 * Outputs a movie based on its title.
	 * 
	 * @param title
	 * @return Movie
	 */
	public Movie get(String title) {
		String movieSelect = "SELECT * FROM Movie WHERE Title ='" + title + "'";

		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet movies = statement.executeQuery(movieSelect);) {

			if (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);
				return movie;
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

}