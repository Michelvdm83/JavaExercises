package vpp.AddTwoNumbers;

import java.util.Scanner;
public class AddTwoNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNumber = input.nextInt();
        System.out.print("Enter the second number: ");
        int secondNumber = input.nextInt();
        System.out.printf("The sum is: %d", firstNumber+secondNumber);
    }
}
/*
Make a program that lets the user input two numbers, and then shows the result
of adding them.

Example run:
Enter the first number: 3
Enter the second number: 5
The sum is: 8
 */