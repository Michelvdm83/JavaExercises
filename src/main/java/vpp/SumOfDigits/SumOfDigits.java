package vpp.SumOfDigits;

import java.util.Scanner;
public class SumOfDigits {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int number = input.nextInt();
        int result = 0;
        while(number != 0){
            result += (number%10);
            number /= 10;
        }
        System.out.println("The sum of the digits is: " + result);
    }
}
/*
Write a Java program and compute the sum of the digits of an integer.
Input Data:
Input an integer: 25
Expected Output

The sum of the digits is: 7
 */