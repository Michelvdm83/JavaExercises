package vpp.SwapTwoNumbersUsingAMethod;

import java.util.Scanner;
public class SwapTwoNumbersUsingAMethod {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] pair = new int[2];
        System.out.print("Enter the value for a: ");
        pair[0] = input.nextInt();
        System.out.print("Enter the value for b: ");
        pair[1] = input.nextInt();
        pair = swap(pair);
        System.out.println("a is now: " + pair[0]);
        System.out.println("b is now: " + pair[1]);
    }

    private static int[] swap(int[] original){
        int[] swapped = new int[2];
        swapped[0] = original[1];
        swapped[1] = original[0];
        return swapped;
    }
}
/*
Ask the user for two numbers, assign them to variables, then swap those
variables (so if firstNumber starts at 2 and
secondNumber starts at 7, then after the swap firstNumber should be 7 and
secondNumber should be 2).

To make this extra difficult, swap them via a method!

Of course, a method static void swap(int a, int b) { int temp = a; a =b; b
=temp; } would NOT work because
you cannot change the value of parameters. So you should make a kind of Pair
object that houses the a and b; since
you can modify the _contents_ of an object given as parameter to a method.

So the easiest would be to make a separate Pair class to contain the a and b
values, and create a method
void swap(Pair pair)

HINT: try to make Pair a proper Java class, with private fields, a constructor,
and public getters and setters.
IntelliJ (Alt+Insert) can help a lot with that!

Sample run:
Enter the value for a: 2
Enter the value for b: 7
a is now: 7
b is now: 2
 */