package VPP.HexadecimalToBinary;

import java.util.Scanner;
import java.lang.Integer;
public class HexadecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input Hexadecimal Number: ");
        String hexadecimalString = input.next();
        int hexadecimalAsInt = Integer.parseInt(hexadecimalString,16);
        System.out.println("\nEquivalent Binary Number: " + Integer.toBinaryString(hexadecimalAsInt));
    }
}

/*
Write a Java program to convert a hexadecimal to a binary number.
Input Data:
Enter Hexadecimal Number: 37
Expected Output

Equivalent Binary Number is: 110111
 */