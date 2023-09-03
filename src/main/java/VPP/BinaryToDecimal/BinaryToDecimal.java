package VPP.BinaryToDecimal;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a binary number: ");
//        String binaryString = input.nextLine();
//        System.out.println("\nDecimal Number: " + Integer.parseInt(binaryString, 2));
        System.out.println("Decimal Number: " + Integer.parseInt(input.nextLine(), 2));
    }
}
/*
Input Data:
Input a binary number: 100
Expected Output

Decimal Number: 4
 */