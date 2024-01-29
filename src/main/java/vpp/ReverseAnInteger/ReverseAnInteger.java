package vpp.ReverseAnInteger;

import java.util.Scanner;
public class ReverseAnInteger {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int integer = input.nextInt();
        StringBuilder integerString = new StringBuilder("" + integer).reverse();
        System.out.println(integerString);
    }
}
/*
Write a program that displays a given integer in the reverse order.
Example:
Enter an integer: 4235
5324

 */