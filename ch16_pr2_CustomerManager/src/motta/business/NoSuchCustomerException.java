package motta.business;

public class NoSuchCustomerException extends Exception {

	NoSuchCustomerException() {
	}

	NoSuchCustomerException(String message) {
		super(message);
	}

}
