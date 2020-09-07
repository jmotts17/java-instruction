import java.text.NumberFormat;
import java.util.Scanner;

public class TestScoreApp {

	public static void main(String[] args) {
		// display operational messages
		System.out.println("Enter test scores that range from 0 to 100.");
		System.out.println("To end the program, enter 999.");
		System.out.println(); // print a blank line

		// initialize variables and create a Scanner object
		int scoreTotal = 0;
		int scoreCount = 0;
		int testScore = 0;
		int minTestScore = 100;
		int maxTestScore = 0;

		NumberFormat formatter = NumberFormat.getInstance();

		formatter.setMaximumFractionDigits(1);

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// get a series of test scores from the user
		while (testScore != 999) {
			// get the input from the user
			System.out.print("Enter score: ");
			testScore = sc.nextInt();

			// accumulate score count and score total
			if (testScore <= 100) {
				scoreCount++;
				scoreTotal += testScore;
				minTestScore = Math.min(minTestScore, testScore);
				maxTestScore = Math.max(maxTestScore, testScore);
			} else if (testScore != 999)
				System.out.println("Invalid entry, not counted");
		}

		// display the score count, score total, and average score
		String averageScore = formatter.format((double) scoreTotal / scoreCount);
		String message = "\n" + "Score count:   " + scoreCount + "\n" + "Score total:   " + scoreTotal + "\n"
				+ "Average score: " + averageScore + "\n" + "Minimum Test Score: " + minTestScore + "\n"
				+ "Maximum Test Score: " + maxTestScore;
		System.out.println(message);
	}
}