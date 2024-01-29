package vpp.SumOfTwoIntegersEqualToAThirdInteger;

import java.util.Scanner;
public class SumOfTwoIntegersEqualToAThirdInteger {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int firstNumber = input.nextInt();
        System.out.print("Input the second number: ");
        int secondNumber = input.nextInt();
        System.out.print("Input the third number: ");
        int thirdNumber = input.nextInt();
        System.out.println("The result is: " + sumCheck(firstNumber, secondNumber, thirdNumber));
    }

    private static boolean sumCheck(int first, int second, int third){
        if(Math.max(first, second) == Math.min(first, second) + third){
            return true;
        }
        if(third == first+second){
            return true;
        }
        return false;
        //above is to make the code better readable, but wanted to try something different from standard && / ||
        //can be simplified as:
        /*
        return (Math.max(first, second) == Math.min(first, second) + third) || (third == first+second);
         */
    }
}
/*
Write a Java program that asks for three integers, then prints "true" if the
sum of any two of the integers
is equal to the third integer.
Sample Output:

Input the first number : 5
Input the second number: 10
Input the third number : 15
The result is: true
 */