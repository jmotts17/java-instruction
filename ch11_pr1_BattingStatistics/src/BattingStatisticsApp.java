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
			int timesAtBat = Console.getInt("\nEnter number of times at bat: ", 1, 30);
			System.out.println("\n0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");

			int[] atBatResults = new int[timesAtBat];

			for (int i = 0; i < timesAtBat; i++) {
				int atBatCount = 1;
				int atBatResult = Console.getInt("Result for at-bat " + atBatCount + ": ", -1, 5);
				atBatResults[i] = atBatResult;
				atBatCount++;
			}

			CalculateBattingAverage(atBatResults, formatter);
			CalculateSluggingPercentage(atBatResults, formatter);

			response = Console.getString("\nAnother player? (y/n): ", "y", "n");
		} while (response.equalsIgnoreCase("y"));

		System.out.println("Bye");
	}

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

	public static void CalculateSluggingPercentage(int[] atBatResults, NumberFormat formatter) {
		int totalBases = 0;

		for (int atBat : atBatResults) {
			totalBases += atBat;
		}

		String sluggingPercentage = formatter.format((double) totalBases / atBatResults.length);
		System.out.println("Slugging Percentage: " + sluggingPercentage);
	}
}
