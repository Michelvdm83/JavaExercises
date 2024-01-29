package boek.murachmilespergallonapp;

import java.text.NumberFormat;
import java.util.Scanner;

public class MurachMilesPerGallonApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Miles Per Gallon calculator\n");
        //System.out.println();  // print a blank line

        Scanner sc = new Scanner(System.in);
        String input;

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter miles driven: ");
            input = sc.nextLine();
            double miles = Double.parseDouble(input);

            System.out.print("Enter gallons of gas used: ");
            input = sc.nextLine();
            double gallons = Double.parseDouble(input);

            //double mpg = (double)(Math.round(miles/gallons * 100)) / 100;
            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(2);
            double mpg = miles / gallons;
            String mpgString = formatter.format(mpg);
            System.out.println("Miles per gallon is " + mpgString + ".\n");
            //System.out.println();

            System.out.print("Calculate another MPG? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }

}