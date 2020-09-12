import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String choice;

		System.out.println("Welcome to the Method Calculator!");

		do {

			System.out.print("\nEnter first operand: ");
			int operand1 = scanner.nextInt();
			System.out.print("Enter second operand: ");
			int operand2 = scanner.nextInt();
			System.out.print("Enter operation (+ - * /): ");
			String operation = scanner.next();

			int answer = 0;

			switch (operation) {
			case "+":
				answer = sum(operand1, operand2);
				break;
			case "-":
				answer = difference(operand1, operand2);
				break;
			case "*":
				answer = product(operand1, operand2);
				break;
			case "/":
				answer = quotient(operand1, operand2);
				break;
			default:
				System.out.println("Unknown operation");
			}

			System.out.println(operand1 + " " + operation + " " + operand2 + " = " + answer);

			System.out.print("\nContinue? (y/n): ");
			choice = scanner.next();
		} while (choice.equalsIgnoreCase("y"));

	}

	// Sum Method
	private static int sum(int op1, int op2) {
		System.out.println("In sum method");
		int result = op1 + op2;
		return result;
		// return op1 + op2;
	}

	// Difference Method
	private static int difference(int op1, int op2) {
		System.out.println("In difference method");
		return op1 - op2;
	}

	// Product Method
	private static int product(int op1, int op2) {
		System.out.println("In product method");
		return op1 * op2;
	}

	// Quotient Method
	private static int quotient(int op1, int op2) {
		System.out.println("In quotient method");
		return op1 / op2;
	}

}
