package motta.utils;

public class MathUtils {

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int sum(int... values) {
		if (values.length == 0) {
			throw new IllegalArgumentException("Must pass at least one value");
		}
		int result = 0;
		for (int value : values) {
			result += value;
		}
		return result;
	}

	public static int power(int value, int raiseTo) {
		int total = 1;

		for (int i = 0; i < raiseTo; i++) {
			total *= value;
		}

		return total;
	}

}
