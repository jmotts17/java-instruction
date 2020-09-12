public class InstructionApp {

	public static void main(String[] args) {

		/* --- IF/ELSE --- */
//
//		String productCode = "hm01";
//		String productDescription;
//
//		if (productCode.equals("hm01")) {
//			productDescription = "Hammer";
//		} else if (productCode.equals("bn01")) {
//			productDescription = "Box of Nails";
//		} else {
//			productDescription = "Product not found";
//		}
//
//		System.out.println("Product Description: " + productDescription);

		/* --- SWITCH STATEMENT --- */
//
//		String productCode = "hm02";
//		String productDescription;
//
//		switch (productCode) {
//		case "hm01":
//		case "hm02":
//			productDescription = "Hammer";
//			break;
//		case "bn03":
//			productDescription = "Box of Nails";
//			break;
//		default:
//			productDescription = "Product not found";
//			break;
//		}
//
//		System.out.println("Product Description: " + productDescription);

		/* --- INVOICE APP --- */
//		
//		String customerType = "";
//		double subtotal = 350.0;
//		double discountPercent = 0.0;
//
//		switch (customerType) {
//		case "r":
//		case "R":
//			if (subtotal < 100) {
//				discountPercent = 0.0;
//			} else if (subtotal >= 100 && subtotal < 250) {
//				discountPercent = .1;
//			} else if (subtotal >= 250) {
//				discountPercent = .2;
//			}
//			break;
//		case "c":
//		case "C":
//			if (subtotal < 250) {
//				discountPercent = .2;
//			} else if (subtotal >= 250) {
//				discountPercent = .3;
//			}
//			break;
//		default:
//			discountPercent = .1;
//			customerType = "N/A";
//			break;
//		}
//
//		System.out.println("Customer Type: " + customerType.toUpperCase());
//		System.out.println("Subtotal: " + subtotal);
//		System.out.println("Discount Percent: " + discountPercent);

		/* --- DO-WHILE LOOP --- */
//
//		Scanner sc = new Scanner(System.in);
//
//		String word;
//		String magicWord = "please";
//
//		do {
//			System.out.print("Say the magic word: ");
//			word = sc.next();
//		} while (!magicWord.equalsIgnoreCase(word));
//
//		System.out.println("You said the magic word: " + magicWord);

		/* --- FOR LOOP --- */

		int sum = 0;

		for (int i = 8; i > 0; i -= 2) {
			System.out.println("In loop with i = " + i + " and sum " + sum);
			sum += i;
		}

		System.out.println("sum = " + sum);

		int factorial = 1;

		for (int i = 1; i <= 5; ++i) {
			factorial = factorial * i;
		}

		System.out.println("\nFactorial of 5 is " + factorial);

	}

}
