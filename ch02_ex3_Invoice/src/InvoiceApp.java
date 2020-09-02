import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        // Variable Declaration
        String choice = "y";
        int invoiceCount = 0;
        double invoiceTotal = 0;
        double discountTotal = 0;
        
        // Program runs until user enters n or N
        while (!choice.equalsIgnoreCase("n")) {
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent;
            if (subtotal >= 500) {
            	discountPercent = .25;
            } else if (subtotal >= 200) {
                discountPercent = .2;
            } else if (subtotal >= 100) {
                discountPercent = .1;
            } else {
                discountPercent = 0.0;
            }
            
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;
            
            // Track invoice count, invoice total, and discount total
            invoiceCount++;
            invoiceTotal += subtotal;
            discountTotal += discountPercent;
            
            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + total + "\n";
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
        
        // Calculate average invoice and average discount amount
        double avgInvoice = invoiceTotal / invoiceCount;
        double avgDiscount = discountTotal / invoiceCount;
        
        System.out.println(
        		"Number of Invoices: " + invoiceCount + "\n"
        		+ "Average Invoice Amount: " + avgInvoice + "\n"
        		+ "Average Discount Amount: " + avgDiscount
        		);
    }
}