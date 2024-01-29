package boek.murachinvoiceapp;

import java.util.Scanner;

public class MurachInvoiceApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the invoice Total Calculator\n\r");

        Scanner input = new Scanner(System.in);
/*
        String choice = "y";
        while (choice.equalsIgnoreCase("y")){
           choice = invoiceCalculator(input);
*/
        while (invoiceCalculator(input)) {
            System.out.println();
        }
    }

    private static /*String*/ Boolean invoiceCalculator(Scanner input) {
        System.out.print("Enter subtotal: ");
        String firstInput = input.nextLine();
        double subtotal = Double.parseDouble(firstInput);

        double discountPercent;
        if (subtotal >= 200.0) {
            discountPercent = 0.2;
        } else if (subtotal >= 100) {
            discountPercent = 0.1;
        } else {
            discountPercent = 0.0;
        }
        double discountAmount = subtotal * discountPercent;
        double total = subtotal - discountAmount;

        System.out.println("Discount percent: " + discountPercent + "\n\r"
                + "Discount amount: " + discountAmount + "\n\r"
                + "Invoice total: " + total + "\n\r");

        System.out.print("Continue? (y/n): ");
        return input.nextLine().equalsIgnoreCase("y");
        /*
        String choice = input.nextLine();
        System.out.println();
        return choice;
        */

    }
}
