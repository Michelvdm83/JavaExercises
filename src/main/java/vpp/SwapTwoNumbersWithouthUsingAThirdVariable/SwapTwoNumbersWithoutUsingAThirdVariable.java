package vpp.SwapTwoNumbersWithouthUsingAThirdVariable;

import java.util.Scanner;
public class SwapTwoNumbersWithoutUsingAThirdVariable {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value for a: ");
        int a = input.nextInt();
        System.out.print("Enter the value for b: ");
        int b = input.nextInt();

        a = a-b;
        b = b+a;
        a = b-a;
        System.out.println("a is now: " + a);
        System.out.println("b is now: " + b);

    }
}
/*
Ask the user for two numbers, assign them to variables, then swap those
variables (so if firstNumber starts at 2 and
secondNumber starts at 7, then after the swap firstNumber should be 7 and
secondNumber should be 2.

To make this extra difficult, do NOT use a third variable to store the value (
so no int temp = firstNumber;
firstNumber = secondNumber, secondNumber =temp;)

NOTE: This is more a mathematics puzzle than a programming assignment. I am
mostly including it here because it is
a classic programming puzzle, like FizzBuzz, so you may encounter it sooner or
later. If you can't solve it in 5
minutes, do not worry, just try again in a week ;)

Sample run:
Enter the value for a: 2
Enter the value for b: 7
a is now: 7
b is now: 2

 */