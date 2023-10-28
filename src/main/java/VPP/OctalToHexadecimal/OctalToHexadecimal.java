package VPP.OctalToHexadecimal;

import java.util.Scanner;
import java.lang.Integer;
public class OctalToHexadecimal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input an octal number: ");
        String octalAsString = input.next();

        int number = Integer.parseInt(octalAsString, 8);
        System.out.println("Equivalent hexadecimal number: " + Integer.toHexString(number));
    }
}

/*
Write a Java program to convert a octal number to a hexadecimal number.
Input Data:
Input a octal number : 100
Expected Output

Equivalent hexadecimal number: 40
 */