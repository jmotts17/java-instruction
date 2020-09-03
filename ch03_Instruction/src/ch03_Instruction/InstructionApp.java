package ch03_Instruction;

public class InstructionApp {

	public static void main(String[] args) {

		// Constant - Does not change. Variable name in all caps.
		final int DAYS_IN_NOV = 30;

		// Modulus - Remainder
		int x = 7;
		int y = 3;
		int remainder = x % 3;
		// System.out.println(remainder);

		// Division - Using doubles
		double db1X = 7.0;
		double db1Y = 3.0;
		double divResult = db1X / db1Y;
		// System.out.println(divResult);

		// Arithmetic Unary Operators
		x = 10;
		x++;
		// System.out.println(x);
		y = x++;
		// System.out.println("x = " + x);
		// System.out.println("y = " + y);
		char letter1 = 'C';
		letter1++;
		// System.out.println(letter1);

		// Order of Operations
		double curVal = 5000.00;
		double monthInv = 100;
		double yearlyIntRate = 0.12;
		curVal = (curVal + monthInv) * (1 + (yearlyIntRate / 12));
		// System.out.println(curVal);

		// Explicit Casting
		int i = 86, j = 91;
		double result = (double) i / (double) j;
		// System.out.println(result);

		// Java Classes - Integer & Double
		int parsedInt = Integer.parseInt("123");
		parsedInt++;
		// System.out.println(parsedInt);

		// Math Class
		double x1 = 10.315;
		x1 = (double) Math.round(x1 * 100) / 100.0;
		System.out.println(x1);

	}

}
