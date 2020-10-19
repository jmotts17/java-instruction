package motta.business;

public class NoSuchCustomerException extends Exception {

	NoSuchCustomerException() {
	}

	NoSuchCustomerException(Exception e) {
		super(e);
	}

}
