package VPP.OctalToDecimal;

import java.util.Scanner;
import java.lang.Integer;
public class OctalToDecimal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input any octal number: ");
        String octalAsString = input.next();

        System.out.println("Equivalent decimal number: " + Integer.parseInt(octalAsString, 8));
    }
}

/*
Write a Java program to convert a octal number to a decimal number.
Input Data:
Input any octal number: 10
Expected Output

Equivalent decimal number: 8
 */