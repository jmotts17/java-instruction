package motta.app;

public class HTMLConverterApp {

	public static void main(String[] args) {

		String html = "<h1>Grocery List</h1>\n" + "<ul>\n" + " <li>Eggs</li>\n" + " <li>Milk</li>\n"
				+ " <li>Butter</li>\n" + "</ul>";

		System.out.println("HTML Converter\n");
		System.out.println("INPUT\n" + html);

		System.out.println("\nOUTPUT");
		int openingTag = html.indexOf(">");
		int closingTag = html.indexOf("</");
		String title = html.substring(openingTag + 1, closingTag);

	}
}
