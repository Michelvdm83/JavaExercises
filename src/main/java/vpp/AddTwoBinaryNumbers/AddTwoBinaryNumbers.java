package vpp.AddTwoBinaryNumbers;

import java.util.Scanner;
public class AddTwoBinaryNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input first binary number: ");
        int firstBinary = Integer.parseInt(input.next(), 2);
        System.out.print("Input second binary number: ");
        int secondBinary = Integer.parseInt(input.next(), 2);
        System.out.println("Sum of two binary numbers: " + Integer.toBinaryString(firstBinary+secondBinary));
    }
}
/*
Write a Java program to add two binary numbers.
Input Data:
Input first binary number: 10
Input second binary number: 11
Expected Output

Sum of two binary numbers: 101

** HINT: it can be fun to make your own method to convert a number or String to
a binary number. But one thing to
** learn on the road to becoming a professional is that Java has LOTS of useful
methods already inbuilt. Check
** the wrapper class of int, Integer! :)
 */