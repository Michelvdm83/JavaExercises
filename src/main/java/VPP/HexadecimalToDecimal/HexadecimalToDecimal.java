package VPP.HexadecimalToDecimal;

import java.util.Scanner;
import java.lang.Integer;
public class HexadecimalToDecimal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a hexadecimal number: ");
        String hexadecimalAsString = input.next();
        System.out.println("\nEquivalent decimal number is: " + Integer.parseInt(hexadecimalAsString,16));
    }
}

/*
Write a Java program to convert a hexadecimal to a decimal number.
Input Data:
Input a hexadecimal number: 25
Expected Output

Equivalent decimal number is: 37
 */
