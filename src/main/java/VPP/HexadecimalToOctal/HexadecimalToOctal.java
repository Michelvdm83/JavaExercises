package VPP.HexadecimalToOctal;

import java.util.Scanner;
import java.lang.Integer;
public class HexadecimalToOctal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a hexadecimal number: ");
        String hexadecimalAsString = input.next();
        int number = Integer.parseInt(hexadecimalAsString,16);
        System.out.println("\nEquivalent octal number: " + Integer.toOctalString(number));
    }
}

/*
Write a Java program to convert a hexadecimal to a octal number.
Input Data:
Input a hexadecimal number: 40
Expected Output

Equivalent octal number: 100
 */
