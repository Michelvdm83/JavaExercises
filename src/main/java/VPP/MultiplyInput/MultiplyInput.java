package VPP.MultiplyInput;

import java.util.Scanner;
public class MultiplyInput {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input first number: ");
        int firstNumber = input.nextInt();
        System.out.print("Input second number: ");
        int secondNumber = input.nextInt();
        System.out.printf("%d x %d = %d",firstNumber,secondNumber,firstNumber*secondNumber);
    }
}
/*
Write a Java program that takes two numbers as input and display the product of
two numbers.
Test Data:
Input first number: 25
Input second number: 5
Expected Output :
25 x 5 = 125
 */