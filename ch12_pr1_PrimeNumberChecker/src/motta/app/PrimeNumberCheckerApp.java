package motta.app;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberCheckerApp {

	public static void main(String[] args) {

		// Variable declaration
		String choice;

		// Output welcome message
		System.out.println("Prime Number Checker");

		do {

			// Prompt user for a value between 1 and 5000
			int number = Console.getInt("\nPlease enter an integer between 1 and 5000: ", 0, 5001);

			// flag & for loop check if a number is prime or not
			boolean flag = false;
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					flag = true;
					break;
				}
			}

			// if handles if the number is not prime
			if (flag) {
				// Creates a factors list, calls the get factors and output factors method
				List<Integer> factors = new ArrayList<>();
				getFactors(factors, number);
				System.out.println(number + " is NOT a prime number.");
				System.out.print("It has " + factors.size() + " factors: ");
				outputFactors(factors);

				// Creates a prime factors list, calls the get prime factors and output prime
				// factors method
				List<Integer> primeFactors = new ArrayList<>();
				getPrimeFactors(factors, primeFactors);
				System.out.print("It has " + primeFactors.size() + " prime factors: ");
				outputPrimeFactors(primeFactors);
			} else {
				// Outputs that the number is prime
				System.out.println(number + " is a prime number.");
			}

			// Prompts the user to continue
			choice = Console.getString("\nTry again? (y/n): ", "y", "n");
		} while (choice.equalsIgnoreCase("y"));

		// Outputs goodbye message
		System.out.println("\nBye!");

	}

	/**
	 * This method takes in the factors arraylist and the number the user entered
	 * and stores all the factors in the arraylist.
	 * 
	 * @param factors
	 * @param number
	 */
	private static void getFactors(List<Integer> factors, int number) {
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				factors.add(i);
			}
		}
	}

	/**
	 * This method outputs all the factors from the factors arraylist.
	 * 
	 * @param factors
	 */
	private static void outputFactors(List<Integer> factors) {
		for (int factor : factors) {
			System.out.print(factor + " ");
		}
		System.out.println();
	}

	/**
	 * This method takes in the factors arraylist and stores all the prime factors
	 * from the factors arraylist in the primeFactors arraylist.
	 * 
	 * @param factors
	 * @param primeFactors
	 */
	private static void getPrimeFactors(List<Integer> factors, List<Integer> primeFactors) {

		for (int factor : factors) {
			Boolean flag = false;
			for (int i = 2; i <= factor / 2; i++) {
				if (factor % i == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				primeFactors.add(factor);
			}
		}
	}

	/**
	 * This method outputs all the prime factors from the prime factors arraylist.
	 * 
	 * @param primeFactors
	 */
	private static void outputPrimeFactors(List<Integer> primeFactors) {
		for (int primeFactor : primeFactors) {
			System.out.print(primeFactor + " ");
		}
		System.out.println();
	}

}
