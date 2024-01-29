package vpp.StringToInt;

import java.util.Scanner;
public class StringToInt {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a number(string): ");
        String numberAsString = input.nextLine();
        int number = Integer.parseInt(numberAsString);
        System.out.println("The integer value is: " + number);
    }
}
/*
Write a Java program to convert a string to an integer in Java.
Sample Output:

Input a number(string): 25
The integer value is: 25

 */