import java.text.NumberFormat;

public class BattingStatisticsApp {

	public static void main(String[] args) {

		// Number formatter
		NumberFormat formatter = NumberFormat.getInstance();
		formatter.setMinimumFractionDigits(3);

		// Variable declaration
		String response;

		// Output welcome message
		System.out.println("Welcome to the Batting Average Calculator");

		do {
			// Prompts user for the number of at bats
			int timesAtBat = Console.getInt("\nEnter number of times at bat: ", 1, 30);

			// Outputs the user menu
			System.out.println("\n0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");

			// Creates an atBatResults Array and an atBat counter
			int[] atBatResults = new int[timesAtBat];
			int atBatCount = 1;

			// Prompts user for their batting results for every time at bat
			for (int i = 0; i < timesAtBat; i++) {
				int atBatResult = Console.getInt("Result for at-bat " + atBatCount + ": ", -1, 5);
				atBatResults[i] = atBatResult;
				atBatCount++;
			}

			// Calls batting average and slugging percentage method
			CalculateBattingAverage(atBatResults, formatter);
			CalculateSluggingPercentage(atBatResults, formatter);

			// Prompts user to continue
			response = Console.getString("\nAnother player? (y/n): ", "y", "n");
		} while (response.equalsIgnoreCase("y"));

		System.out.println("\nBye");
	}

	/**
	 * This method takes in the atBatResults array and then goes through the array
	 * tracking the total hits. It then calculates the batting average by dividing
	 * the total hits by the total at bats and outputting the results.
	 * 
	 * @param atBatResults
	 * @param formatter
	 */
	public static void CalculateBattingAverage(int[] atBatResults, NumberFormat formatter) {
		int totalHits = 0;

		for (int atBat : atBatResults) {
			if (atBat > 0) {
				totalHits++;
			}
		}

		String battingAverage = formatter.format((double) totalHits / atBatResults.length);
		System.out.println("\nBatting average: " + battingAverage);
	}

	/**
	 * This method takes in the atBatResults array and then goes through the array
	 * tracking the total bases. It then calculates the slugging percentage by
	 * dividing the total bases by the total at bats and outputting the results.
	 * 
	 * @param atBatResults
	 * @param formatter
	 */
	public static void CalculateSluggingPercentage(int[] atBatResults, NumberFormat formatter) {
		int totalBases = 0;

		for (int atBat : atBatResults) {
			totalBases += atBat;
		}

		String sluggingPercentage = formatter.format((double) totalBases / atBatResults.length);
		System.out.println("Slugging Percentage: " + sluggingPercentage);
	}
}
