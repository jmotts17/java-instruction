import java.io.IOException;

public class CustomTesterApp {

	public static void main(String[] args) {
		method1();
	}

	public static void method1() {
		method2();
	}

	public static void method2() {
		try {
			method3();
		} catch (TestException e) {
			System.err.println("Caught a TestException. Msg: " + e.getMessage());
		}
	}

	public static void method3() throws TestException {
//		throw new TestException("Error.. Error.. Error!!!!!");

		try {
			throw new IOException("Test Exception");
		} catch (IOException e) {
			throw new TestException(e);
		}
	}
}