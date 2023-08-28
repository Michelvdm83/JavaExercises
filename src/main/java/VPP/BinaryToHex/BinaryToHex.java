package VPP.BinaryToHex;

import java.util.Scanner;

public class BinaryToHex {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Input binary number: ");
        String BinaryAsString = scan.next();

        int number = Integer.parseInt(BinaryAsString,2);
        System.out.println("/hexadecimal value :" + Integer.toHexString(number).toUpperCase());
    }
}

/*
Input Data:
Input a Binary Number: 1101
Expected Output

Hexadecimal value: D
** HINT: Check the Java standard library. You're working with whole numbers
here, so Integer (the wrapper class of int,
   as int is a primitive and therefore cannot have any methods) may be of use :)
 */
