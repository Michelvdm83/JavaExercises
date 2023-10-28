package VPP.OctalToBinary;

import java.util.Scanner;
import java.lang.Integer;
public class OctalToBinary {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input any octal number: ");
        String octalAsString = input.next();

        int octalAsDecimal = Integer.parseInt(octalAsString, 8);
        System.out.println("Equivalent binary number: " + Integer.toBinaryString(octalAsDecimal));
    }
}

/*
Write a Java program to convert a octal number to a binary number.
Input Data:
Input any octal number: 7
Expected Output

Equivalent binary number: 111
 */