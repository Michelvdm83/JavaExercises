package vpp.MostlyAscendingTriple;

import java.util.Scanner;
public class MostlyAscendingTriple {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input the first number : ");
        int first = input.nextInt();
        System.out.print("Input the second number: ");
        int second = input.nextInt();
        System.out.print("Input the third number : ");
        int third = input.nextInt();
        System.out.print("Relax the ordering requirement for the first two numbers (true/false): ");
        boolean abc = input.nextBoolean();
        System.out.print("The result is: " + checkOrder(first, second, third, abc));
    }

    private static boolean checkOrder(int a, int b, int c, boolean ignoreFirst){
        return (c > b) && (ignoreFirst || b > a);
    }
}
/*
Write a Java program that accepts three integers from the user and return true
if the second number is greater than
the first number and the third number is greater than second number. If "abc"
is true second number does not need to be
 greater than first number.
Sample Output:

Input the first number : 5
Input the second number: 10
Input the third number : 15
Relax the ordering requirement for the first two numbers (true/false): true
The result is: true
 */