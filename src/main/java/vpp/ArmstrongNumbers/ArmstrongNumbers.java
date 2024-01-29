package vpp.ArmstrongNumbers;

import java.util.Scanner;
public class ArmstrongNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number which you want to check: ");
        int number = input.nextInt();
        int result = 0;
        int digits = String.valueOf(number).length();
        String numberAsString = String.valueOf(number);
        for(int i=0; i < digits; i++){
            int digit = Integer.parseInt(numberAsString.substring(i, i+1));
            result += (int)Math.pow(digit, digits);
        }
        if(result == number) System.out.println("This number is an Armstrong number.");
        else System.out.println("This number is not an Armstrong number.");
    }
}
/*
An Armstrong number is a number that is the sum of its own digits each raised
to the power of the number of digits
is equal to the number itself.

For example:
Three Digits Armstrong number is 153, 1 ^ 3 + 5 ^ 3 + 3 ^ 3 = 153

Four Digits Armstrong number is 1634, 1 ^ 4 + 6 ^ 4 + 3 ^ 4 + 4 ^ 4 + = 1634

and So on...

Example run 1:
Enter the number which you want to check: 1634
This number is an Armstrong number.

Example run 2:
Enter the number which you want to check: 1635
This number is not an Armstrong number.
 */