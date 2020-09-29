public class CustomerTypeApp {

	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Customer Type Test application\n");

		CustomerType ct = CustomerType.TRADE;
		System.out.println(ct + " Discount Percent: " + getDiscountPercent(ct));
		System.out.println(ct.toString());
	}

	public static double getDiscountPercent(CustomerType custType) {
		switch (custType) {
		case RETAIL:
			return .10;
		case TRADE:
			return .30;
		case COLLEGE:
			return .20;
		default:
			return 0;
		}
	}
}
