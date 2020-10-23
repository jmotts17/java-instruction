package bmdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public Movie getMovieByTitle(String title) {
		String movieSelect = "SELECT * FROM Movie WHERE Title = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieSelect);) {

			ps.setString(1, title);
			ResultSet movies = ps.executeQuery();

			if (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);
				movies.close();
				return movie;
			} else {
				movies.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	public Movie get(long id) {
		String movieSelect = "SELECT * FROM Movie WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieSelect);) {

			ps.setLong(1, id);
			ResultSet movies = ps.executeQuery();

			if (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);
				movies.close();
				return movie;
			} else {
				movies.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	public boolean add(Movie movie) {
		String movieInsert = "INSERT INTO movie(Title, Year, Rating, Director) VALUES (?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieInsert);) {
			ps.setString(1, movie.getTitle());
			ps.setLong(2, movie.getYear());
			ps.setString(3, movie.getRating());
			ps.setString(4, movie.getDirector());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean delete(long id) {
		String movieDelete = "DELETE FROM movie WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieDelete);) {
			ps.setLong(1, id);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean update(Movie movie) {
		String movieUpdate = "UPDATE movie SET Title = ?, Year = ?, Rating = ?, Director = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieUpdate);) {
			ps.setString(1, movie.getTitle());
			ps.setLong(2, movie.getYear());
			ps.setString(3, movie.getRating());
			ps.setString(4, movie.getDirector());
			ps.setLong(5, movie.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

}