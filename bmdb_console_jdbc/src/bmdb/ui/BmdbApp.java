package bmdb.ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import bmdb.business.Actor;
import bmdb.business.Movie;
import bmdb.db.ActorDb;
import bmdb.db.MovieDb;

public class BmdbApp {

	// Create static ActorDb and MovieDb classes
	private static ActorDb actorDb = new ActorDb();
	private static MovieDb movieDb = new MovieDb();

	public static void main(String[] args) throws SQLException {
		// Output welcome message and menu
		System.out.println("Welcome to the Bootcamp Movie Database!\n");

		// Variable declaration
		String command = "";

		do {
			command = displayMenu();

			switch (command) {
			case "la":
				displayActors();
				break;
			case "lm":
				displayMovies();
				break;
			case "aa":
				addActor();
				break;
			case "da":
				deleteActor();
				break;
			case "ua":
				updateActor();
				break;
			case "am":
				addMovie();
				break;
			case "dm":
				deleteMovie();
				break;
			case "um":
				updateMovie();
				break;
			case "gabi":
				long actorId = Console.getInt("Actor's ID: ");
				displayActorById(actorId);
				break;
			case "gabn":
				String lastName = Console.getLine("Actor's last name: ");
				displayActorByLastName(lastName);
				break;
			case "gmbi":
				long movieId = Console.getInt("Movie's ID: ");
				displayMovieById(movieId);
				break;
			case "gmbt":
				String title = Console.getLine("Movie's ID: ");
				displayMovieByTitle(title);
				break;
			}

		} while (!command.equalsIgnoreCase("exit"));

		// Output end message
		System.out.println("\nBye!");
	}

	/**
	 * Outputs all the users options. Returns the users selection to the main
	 * method.
	 */
	public static String displayMenu() {
		System.out.println("\nCOMMAND MENU");
		System.out.println("ao - Actor options");
		System.out.println("mo - Movie options");
		System.out.println("exit - Exit the application");

		String select = Console.getString("\nEnter command: ");

		if (select.equals("ao")) {
			System.out.println("\nACTOR MENU");
			System.out.println("la - List actors");
			System.out.println("aa - Add actor");
			System.out.println("da - Delete actor");
			System.out.println("ua - Update actor");
			System.out.println("gabi - Get actor by ID");
			System.out.println("gabn - Get actor by last name");
			select = Console.getString("Enter Actor option: ");
			return select;
		} else if (select.equals("mo")) {
			System.out.println("\nMOVIE MENU");
			System.out.println("lm - List movies");
			System.out.println("am - Add movie");
			System.out.println("dm - Delete movie");
			System.out.println("um - Update movie");
			System.out.println("gmbi - Get movie by ID");
			System.out.println("gmbt - Get movie by title");
			select = Console.getString("\nEnter Movie option: ");
			return select;
		} else {
			return select;
		}
	}

	/**
	 * Outputs all the actors from the database.
	 */
	public static void displayActors() {
		List<Actor> actors = actorDb.getAll();
		System.out.println();

		for (Actor actor : actors) {
			System.out.println(actor);
		}
	}

	/**
	 * Outputs all the movies from the database.
	 */
	public static void displayMovies() {
		List<Movie> movies = movieDb.getAll();
		System.out.println();

		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	/**
	 * Prompts the user for the actors fields and then attempts to create a new
	 * actor and add to the database. An error message is output if it is not
	 * successful.
	 */
	public static void addActor() {
		String newFirstName = Console.getString("First Name: ");
		String newLastName = Console.getString("Last name: ");
		String newGender = Console.getString("Gender (m/f): ", "m", "f");
		String newBirthDateStr = Console.getString("Birthdate (YYYY-MM-DD): ");
		LocalDate newBirthDate = LocalDate.parse(newBirthDateStr);
		Actor newActor = new Actor(0, newFirstName, newLastName, newGender, newBirthDate);
		if (actorDb.add(newActor)) {
			System.out.println("Actor added successfully");
		} else {
			System.out.println("Error adding actor");
		}
	}

	/**
	 * Prompts the user for the actor ID they want to delete. An error message is
	 * output if it is not successful.
	 */
	public static void deleteActor() {
		int idToDelete = Console.getInt("Actor ID: ");
		if (actorDb.delete(idToDelete)) {
			System.out.println("Actor deleted successfully");
		} else {
			System.out.println("Error deleting actor");
		}
	}

	/**
	 * Prompts the user for the actor information to update. Outputs a success/error
	 * message once complete.
	 */
	public static void updateActor() {
		int updateId = Console.getInt("ID to update: ");
		String newFirstName = Console.getString("First Name: ");
		String newLastName = Console.getString("Last name: ");
		String newGender = Console.getString("Gender (m/f): ", "m", "f");
		String newBirthDateStr = Console.getString("Birthdate (YYYY-MM-DD): ");
		LocalDate newBirthDate = LocalDate.parse(newBirthDateStr);
		Actor newActor = new Actor(updateId, newFirstName, newLastName, newGender, newBirthDate);

		if (actorDb.update(newActor)) {
			System.out.println("Actor updated successfully");
		} else {
			System.out.println("Error updating actor");
		}
	}

	public static void addMovie() {
		String title = Console.getString("Movie title: ");
		int year = Console.getInt("Year released: ");
		String rating = Console.getString("Rating: ");
		String director = Console.getString("Director: ");
		Movie newMovie = new Movie(0, title, year, rating, director);
		if (movieDb.add(newMovie)) {
			System.out.println("Movie added successfully");
		} else {
			System.out.println("Error adding Movie");
		}
	}

	public static void deleteMovie() {
		int idToDelete = Console.getInt("Movie ID: ");
		if (movieDb.delete(idToDelete)) {
			System.out.println("Movie deleted successfully");
		} else {
			System.out.println("Error deleting actor");
		}
	}

	public static void updateMovie() {
		int updateId = Console.getInt("ID to update: ");
		String newTitle = Console.getString("Movie Title: ");
		int newYear = Console.getInt("Year released: ");
		String newRating = Console.getString("Rating: ");
		String newDirector = Console.getString("Director: ");
		Movie newMovie = new Movie(updateId, newTitle, newYear, newRating, newDirector);

		if (movieDb.update(newMovie)) {
			System.out.println("Movie updated successfully");
		} else {
			System.out.println("Error updating actor");
		}
	}

	/**
	 * Searches for an actor based on their ID. Outputs the actor if found or an
	 * error message.
	 * 
	 * @param id
	 */
	public static void displayActorById(long id) {
		Actor actor = actorDb.get(id);
		if (actor == null) {
			System.out.println("Actor not found.");
		} else {
			System.out.println();
			System.out.println(actor);
		}
	}

	/**
	 * Searches for an actor based on their last name. Outputs the actor if found or
	 * an error message.
	 * 
	 * @param lastName
	 */
	public static void displayActorByLastName(String lastName) {
		Actor actor = actorDb.getActorByLastName(lastName);
		if (actor == null) {
			System.out.println("Actor not found.");
		} else {
			System.out.println();
			System.out.println(actor);
		}
	}

	public static void displayMovieById(long id) {
		Movie movie = movieDb.get(id);
		if (movie == null) {
			System.out.println("Movie not found.");
		} else {
			System.out.println();
			System.out.println(movie);
		}
	}

	/**
	 * Searches for a movie based on the title. Outputs the movie if found or an
	 * error message.
	 * 
	 * @param title
	 */
	public static void displayMovieByTitle(String title) {
		Movie movie = movieDb.getMovieByTitle(title);
		if (movie == null) {
			System.out.println("Movie not found.");
		} else {
			System.out.println();
			System.out.println(movie);
		}
	}

}