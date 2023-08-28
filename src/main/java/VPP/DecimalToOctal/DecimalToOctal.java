package VPP.DecimalToOctal;

import java.util.Scanner;

public class DecimalToOctal {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input decimal number: ");
        int decimal = in.nextInt();
        System.out.println("Octal number is: " + Integer.toOctalString(decimal));
    }
}
/*
Input Data:
Input a Decimal Number: 15
Expected Output

Octal number is: 17
 */
