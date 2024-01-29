package vpp.MultipleOfBoth5And7;

import java.util.Scanner;
public class MultipleOfBoth5And7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        String negative = "";
        boolean check = ((number%5 == 0) && (number%7 == 0));
        if(!check) negative = " not";
        System.out.printf("%d is%s a multiple of both 5 and 7",number,negative);
    }
}
/*
Check whether a given integer is a multiple of both 5 and 7.

Example:
Enter an integer: 35
35 is a multiple of both 5 and 7

Another example:
Enter an integer: 42
42 is not a multiple of both 5 and 7
 */