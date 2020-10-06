package motta.app;

public class StringApp {

	public static void main(String[] args) {
		String productCode = "java";
		System.out.println("Length of " + productCode + " is " + productCode.length());

		String name = "Martin Van Buren";
		int firstSpace = name.indexOf(" ");
		System.out.println("The index of the first space is index " + firstSpace);
		int secondSpace = name.indexOf(" ", firstSpace + 1);
		System.out.println("The index of the first space is index " + secondSpace);
		int thirdSpace = name.indexOf(" ", secondSpace + 1);
		System.out.println("The index of the first space is index " + thirdSpace);

		char fifthChar = name.charAt(4);
		System.out.println("The fifth character is " + fifthChar);

		String strWithSpaces = "     a  b c ";
		String trimmed = strWithSpaces.trim();
		System.out.println("Trimmed = [" + trimmed + "]");

		String fullName = "Mike Murach";
		int spaceIndex = fullName.indexOf(" ");
		String fName = fullName.substring(0, spaceIndex);
		String lName = fullName.substring(spaceIndex + 1);

		System.out.println("First Name = [" + fName + "] Last Name = [" + lName + "]");

		String phoneNumber = "937-123-4567";
		String dotPhoneNumber = phoneNumber.replace("-", ".");
		System.out.println("dotPhoneNumber = " + dotPhoneNumber);

		String firstNames = "Dave Michael John Carl";
		String[] firstNamesArray = firstNames.split(" ");
		System.out.println("firstNamesArray length " + firstNamesArray.length);
		for (String firstName : firstNamesArray) {
			System.out.println("[" + firstName + "]");
		}

	}

}
