package VPP.CheckIfNumberIsEvenOrOdd;

import java.util.Scanner;
public class CheckIfNumberIsEvenOrOdd {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a number: ");
        int number = input.nextInt();
        System.out.println((number+1)%2);
    }
}
/*
Write a Java program to accept a number and check the number is even or not.
Prints 1 if the number is even or 0 if the number is odd.
Sample Output:

Input a number: 20
1

 */