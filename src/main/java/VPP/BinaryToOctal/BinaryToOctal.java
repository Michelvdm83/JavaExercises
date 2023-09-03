package VPP.BinaryToOctal;

import java.util.Scanner;
public class BinaryToOctal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a Binary Number: ");
 //       int binaryNumberAsString = Integer.parseInt(input.nextLine(), 2);
 //       System.out.println("\nOctal number: " + Integer.toOctalString(binaryNumberAsString));
        System.out.println("\nOctal number: " + Integer.toOctalString(Integer.parseInt(input.nextLine(), 2)));
    }
}
/*
Input Data:
Input a Binary Number: 111
Expected Output

Octal number: 7
 */
