
public class RoshamboApp {

	public static void main(String[] args) {

		String choice, rps;
		Lisa lisa = new Lisa();

		System.out.println("Welcome to the game of Roshambo");

		String name = Console.getString("\nEnter your name: ");
		Player1 player1 = new Player1(name);

		do {

			rps = Console.getString("\nRock, paper or scissors? (R/P/S): ", "r", "p", "s");

			if (rps.equalsIgnoreCase("r")) {
				player1.setRoshVal(RoshamboEnum.ROCK);
			} else if (rps.equalsIgnoreCase("p")) {
				player1.setRoshVal(RoshamboEnum.PAPER);
			} else if (rps.equalsIgnoreCase("s")) {
				player1.setRoshVal(RoshamboEnum.SCISSORS);
			}

			lisa.generateRoshambo();

			System.out.println("\n" + player1.getName() + ": " + player1.getRoshVal().toString());
			System.out.println(lisa.getName() + ": " + lisa.getRoshVal().toString());

			if (player1.getRoshVal() == lisa.getRoshVal()) {
				System.out.println("Draw!");
			} else if (player1.getRoshVal() == RoshamboEnum.PAPER && lisa.getRoshVal() == RoshamboEnum.ROCK) {
				System.out.println(player1.getName() + " wins!");
			} else if (player1.getRoshVal() == RoshamboEnum.SCISSORS && lisa.getRoshVal() == RoshamboEnum.PAPER) {
				System.out.println(player1.getName() + " wins!");
			} else if (player1.getRoshVal() == RoshamboEnum.ROCK && lisa.getRoshVal() == RoshamboEnum.SCISSORS) {
				System.out.println(player1.getName() + " wins!");
			} else {
				System.out.println(lisa.getName() + " wins!");
			}

			choice = Console.getString("\nPlay again? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

	}

}
