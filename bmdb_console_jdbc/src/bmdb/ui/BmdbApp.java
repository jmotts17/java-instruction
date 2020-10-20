package bmdb.ui;

import java.sql.SQLException;
import java.util.List;

import bmdb.business.Actor;
import bmdb.db.ActorDb;

public class BmdbApp {

	private static ActorDb actorDb = new ActorDb();

	public static void main(String[] args) throws SQLException {
		System.out.println("Welcome to the Bootcamp Movie Database!\n");
		displayMenu();

		String command = Console.getString("\nEnter command: ");
		while (!command.equalsIgnoreCase("exit")) {

			switch (command) {
			case "la":
				displayActors();
				break;
			case "gabn":
				String lastName = Console.getLine("Actor's last name: ");
				displayActorByLastName(lastName);
				break;
			}

			command = Console.getString("\nEnter command: ");
		}

		System.out.println("\nBye!");
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("la - List actors");
		System.out.println("gabn - Get an actor by last name");
		System.out.println("exit - Exit the application");
	}

	public static void displayActors() {

		List<Actor> actors = actorDb.getAll();

		System.out.println();

		for (Actor actor : actors) {
			System.out.println(actor);
		}
	}

	public static void displayActorByLastName(String lastName) {
		Actor actor = actorDb.get(lastName);
		if (actor == null) {
			System.out.println("No actor found");
		} else {
			System.out.println(actor);
		}
	}

}