package VPP.SameRightmostDigits;

import java.util.Scanner;
public class SameRightmostDigits {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input the first number : ");
        int number1 = input.nextInt();
        System.out.print("Input the second number: ");
        int number2 = input.nextInt();
        System.out.print("Input the third number : ");
        int number3 = input.nextInt();
        System.out.print("The result is: " + checkRightmostDigits(number1, number2, number3));
    }

    private static boolean checkRightmostDigits(int first, int second, int third){
        int digitFirst = first%10, digitSecond = second%10, digitThird = third%10;
        if(digitFirst == digitSecond || digitFirst == digitThird || digitSecond == digitThird){
            return true;
        }
        return false;
    }
}
/*
Write a Java program that accepts three integers from the user and return true
if two or more of them (integers )
  have the same rightmost digit. The integers are non-negative.
Sample Output:

Input the first number : 5
Input the second number: 10
Input the third number : 15
The result is: true
 */