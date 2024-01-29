package vpp.MultiplyTwoBinaryNumbers;

import java.util.Scanner;
public class MultiplyTwoBinaryNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input the first binary number: ");
        int firstNumber = Integer.parseInt(input.nextLine().trim(), 2);
        System.out.print("Input the second binary number: ");
        int secondNumber = Integer.parseInt(input.nextLine().trim(), 2);
        System.out.println("Product of two binary numbers: " + Integer.toBinaryString(firstNumber*secondNumber));
    }
}
/*
Input Data:
Input the first binary number: 10
Input the second binary number: 11
Expected Output

Product of two binary numbers: 110
** HINT: it can be fun to make your own method to convert a number or String to
a binary number. But one thing to
** learn on the road to becoming a professional is that Java has LOTS of useful
methods already inbuilt. Check
** the wrapper class of int, Integer! :)
 */