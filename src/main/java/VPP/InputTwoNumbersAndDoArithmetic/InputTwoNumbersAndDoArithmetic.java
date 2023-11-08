package VPP.InputTwoNumbersAndDoArithmetic;

import java.util.Scanner;
public class InputTwoNumbersAndDoArithmetic {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input first number: ");
        int first = input.nextInt();
        System.out.print("Input second number: ");
        int second = input.nextInt();
        String format = "%d %s %d = %d\n";
        System.out.printf(format, first, "+", second, first+second);
        System.out.printf(format, first, "-", second, first-second);
        System.out.printf(format, first, "x", second, first*second);
        System.out.printf(format, first, "/", second, first/second);
        System.out.printf(format, first, "mod", second, first%second);
    }
}
/*
Write a Java program to print the sum (addition), multiply, subtract, divide
and remainder of two numbers. Go to the editor
Test Data:
Input first number: 125
Input second number: 24
Expected Output :
125 + 24 = 149
125 - 24 = 101
125 x 24 = 3000
125 / 24 = 5
125 mod 24 = 5
 */