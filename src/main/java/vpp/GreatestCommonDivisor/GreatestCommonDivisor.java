package vpp.GreatestCommonDivisor;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        int first = input.nextInt();
        System.out.print("Please enter the second number: ");
        int second = input.nextInt();
        System.out.printf("The GCD of %d and %d is %d", first, second, gcd(first, second));
    }

    private static int gcd(int a, int b){
        if(a%b == 0) return b;
        return gcd(b, a%b);
    }
}
/*
https://en.wikipedia.org/wiki/Greatest_common_divisor

How to find the GCD? Wikipedia has some links, including to one to the
Euclidian algorithm:
A more efficient method is the Euclidean algorithm, a variant in which the
difference of the two numbers a and b is replaced by the remainder of the
Euclidean division (also called division with remainder) of a by b.

Denoting this remainder as a mod b, the algorithm replaces (a, b) by (b, a mod
b) repeatedly until the pair is (d, 0),
where d is the greatest common divisor.

This can be done in several ways, either by swapping values as you'd do for a
Fibonacci, or by recursion

Example run:
Please enter the first number: 45
Please enter the second number: 30
The GCD of 45 and 30 is 15

 */