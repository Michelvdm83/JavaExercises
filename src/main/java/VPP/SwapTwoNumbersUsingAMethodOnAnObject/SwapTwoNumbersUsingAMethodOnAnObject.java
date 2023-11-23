package VPP.SwapTwoNumbersUsingAMethodOnAnObject;

import java.util.Scanner;
public class SwapTwoNumbersUsingAMethodOnAnObject {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Pair pair = new Pair(0, 0);
        System.out.print("Enter the value for a: ");
        pair.setFirst(input.nextInt());
        System.out.print("Enter the value for b: ");
        pair.setSecond(input.nextInt());
        pair.swap();
        System.out.println("a is now: " + pair.getFirst());
        System.out.println("b is now: " + pair.getSecond());
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
void swap(Pair pair).

However, in object-oriented programming you would try to not micromanage the
values of fields inside a class by
a method outside the class; so try to make a method void swap() in Pair that is
called by the main method!
And call pair.swap() in the main method...

HINT: try to make Pair a proper Java class, with private fields, a constructor,
and public getters and setters.
IntelliJ (Alt+Insert) can help a lot with that!

Sample run:
Enter the value for a: 2
Enter the value for b: 7
a is now: 7
b is now: 2
 */