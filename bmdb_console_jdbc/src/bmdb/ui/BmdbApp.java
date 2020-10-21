package bmdb.ui;

import java.sql.SQLException;
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
	 * Searches for an actor based on their last name. Outputs the actor if found or
	 * an error message.
	 * 
	 * @param lastName
	 */
	public static void displayActorByLastName(String lastName) {
		Actor actor = actorDb.get(lastName);
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