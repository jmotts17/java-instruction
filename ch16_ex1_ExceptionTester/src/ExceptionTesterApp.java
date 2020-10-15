import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTesterApp {

	public static void main(String[] args) {
		System.err.println("In main: calling method1.");
		method1();
		System.err.println("In main: returned from method1.");
	}

	public static void method1() {
		System.err.println("\tIn method1: calling method2.");
		try {
			method2();
		} catch (IOException e) {
			System.err.println("Caught FileNotFoundException. Msg: " + e.getMessage());
		}
		System.err.println("\tIn method1: returned from method2.");
	}

	public static void method2() throws FileNotFoundException {
		System.err.println("\t\tIn method2: calling method3.");
		method3();
		System.err.println("\t\tIn method2: returned from method3.");
	}

	public static void method3() throws FileNotFoundException {
		System.err.println("\t\t\tIn method3: Entering.");

		// Add code to throw an exception here.
		BufferedReader in = new BufferedReader(new FileReader("products.ran"));
		System.err.println("\t\t\tIn method3: Exiting.");
	}
}