package VPP.DecimalToHexa;

import java.util.Scanner;

public class DecimalToHexa {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a decimal number:");
//        String input = in.next();
//        int decimal = Integer.parseInt(input);
        int decimal = in.nextInt();

        System.out.println("Hexadecimal number is : " + Integer.toHexString(decimal).toUpperCase());

    }
}
/*
Input Data:
Input a decimal number: 15
Expected Output

Hexadecimal number is : F
 */