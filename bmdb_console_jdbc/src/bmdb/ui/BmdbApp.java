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
		displayMenu();

		// Prompt user for a menu selection
		String command = Console.getString("\nEnter command: ");
		while (!command.equalsIgnoreCase("exit")) {

			// Calls method based on menu selection
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
			case "gabi":
				long id = Console.getInt("Actor's ID: ");
				displayActorById(id);
				break;
			case "gabn":
				String lastName = Console.getLine("Actor's last name: ");
				displayActorByLastName(lastName);
				break;
			case "gmbt":
				String title = Console.getLine("Movie title: ");
				displayMovieByTitle(title);
				break;
			}

			// Prompt user for a menu selection
			command = Console.getString("\nEnter command: ");
		}

		// Output end message
		System.out.println("\nBye!");
	}

	/**
	 * Outputs the menu options.
	 */
	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("la - List actors");
		System.out.println("lm - List movies");
		System.out.println("aa - Add actor");
		System.out.println("da - Delete actor");
		System.out.println("ua - Update actor");
		System.out.println("gabi - Get actor by ID");
		System.out.println("gabn - Get an actor by last name");
		System.out.println("gmbt - Get a movie by title");
		System.out.println("exit - Exit the application");
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

	/**
	 * Searches for a movie based on the title. Outputs the movie if found or an
	 * error message.
	 * 
	 * @param title
	 */
	public static void displayMovieByTitle(String title) {
		Movie movie = movieDb.get(title);
		if (movie == null) {
			System.out.println("Movie not found.");
		} else {
			System.out.println();
			System.out.println(movie);
		}
	}

}