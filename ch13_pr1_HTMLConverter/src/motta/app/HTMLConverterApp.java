package motta.app;

public class HTMLConverterApp {

	public static void main(String[] args) {

		// Variable declaration
		String html = "<h1>Grocery List</h1>\n" + "<ul>\n" + " <li>Eggs</li>\n" + " <li>Milk</li>\n"
				+ " <li>Butter</li>\n" + "</ul>";

		// Output Welcome Message
		System.out.println("HTML Converter");

		// Output original String
		System.out.println("\nINPUT");
		System.out.println(html);

		// Output new string without html tags
		System.out.println("\nOUTPUT");
		String pattern = "\\<.*?\\>";
		String groceryList = html.replaceAll(pattern, "");
		String[] groceryListArr = groceryList.split("\n");

		for (int i = 0; i < groceryListArr.length; i++) {
			if (groceryListArr[i].trim().isEmpty()) {
				continue;
			} else if (groceryListArr[i].contains("List")) {
				System.out.println(groceryListArr[i]);
			} else {
				System.out.println("* " + groceryListArr[i].trim());
			}
		}

	}
}
