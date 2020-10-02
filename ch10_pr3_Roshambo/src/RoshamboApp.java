
public class RoshamboApp {

	public static void main(String[] args) {

		// Variable / Object Declaration
		String choice;
		Player player2;

		// Output welcome message
		System.out.println("Welcome to the game of Roshambo");

		// Prompt user for name for player1 object
		String name = Console.getString("\nEnter your name: ");
		Player1 player1 = new Player1(name);

		// Determines which opponent the user is going to play
		player2 = BartOrLisa();

		do {
			RockPaperScissors(player1);
			player2.generateRoshambo();
			OutputResults(player1, player2);

			// Prompts the user to see if he wants to play again
			choice = Console.getString("\nPlay again? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

		// Outputs the total points for each player
		System.out.println("\nFinal Score");
		System.out.println(player1.getName() + ": " + player1.getScore());
		System.out.println(player2.getName() + ": " + player2.getScore());

	}

	/**
	 * Prompts the user to pick which opponent they want to face.
	 * 
	 * @return Player object as Bart or Lisa
	 */
	public static Player BartOrLisa() {
		String bl = Console.getString("\nWould you like to play Bart or Lisa? (B/L): ", "B", "L");

		if (bl.equalsIgnoreCase("b")) {
			return new Bart();
		} else {
			return new Lisa();
		}
	}

	/**
	 * Prompts the user to pick rock, paper or scissors. No return value.
	 * 
	 * @param player1
	 */
	public static void RockPaperScissors(Player player1) {

		String rps = Console.getString("\nRock, paper or scissors? (R/P/S): ", "r", "p", "s");

		if (rps.equalsIgnoreCase("r")) {
			player1.setRoshVal(RoshamboEnum.ROCK);
		} else if (rps.equalsIgnoreCase("p")) {
			player1.setRoshVal(RoshamboEnum.PAPER);
		} else if (rps.equalsIgnoreCase("s")) {
			player1.setRoshVal(RoshamboEnum.SCISSORS);
		}

	}

	/**
	 * Outputs the results of the Roshambo round by comparing player1's choice
	 * against player2's choice.
	 * 
	 * @param player1
	 * @param player2
	 */
	public static void OutputResults(Player player1, Player player2) {

		System.out.println("\n" + player1.getName() + ": " + player1.getRoshVal().toString());
		System.out.println(player2.getName() + ": " + player2.getRoshVal().toString());

		if (player1.getRoshVal() == player2.getRoshVal()) {
			System.out.println("Draw!");
		} else if (player1.getRoshVal() == RoshamboEnum.PAPER && player2.getRoshVal() == RoshamboEnum.ROCK) {
			System.out.println(player1.getName() + " wins!");
			player1.score++;
		} else if (player1.getRoshVal() == RoshamboEnum.SCISSORS && player2.getRoshVal() == RoshamboEnum.PAPER) {
			System.out.println(player1.getName() + " wins!");
			player1.score++;
		} else if (player1.getRoshVal() == RoshamboEnum.ROCK && player2.getRoshVal() == RoshamboEnum.SCISSORS) {
			System.out.println(player1.getName() + " wins!");
			player1.score++;
		} else {
			System.out.println(player2.getName() + " wins!");
			player2.score++;
		}

	}

}
