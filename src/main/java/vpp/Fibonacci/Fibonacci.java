package vpp.Fibonacci;

import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Up to which number do you want to generate Fibonacci numbers? ");
        int endNumber = input.nextInt();
        int pre2 = 1;
        int pre1 = 1;
        int current = 2;

        System.out.print(pre1 + " " + pre2);
        while(current < endNumber){
            pre2 = pre1;
            pre1 = current;
            current += pre2;
            System.out.print(" " + current);
        }
    }
}
/*
The logic in the sequence is simple: you start with 1 1, and every next number
is the sum of the previous two numbers.
So you get a series like 1 1 2 3 5 8 13 21 ... (1+1=2, 1+2=3, 2+3=5, 3+5=8,
5+8=13 etc.)

Create a program that asks for the number up to which to calculate Fibonacci
numbers. So if the user wants Fibonacci
numbers up to 1000, the program should produce 1 1 2 3 5 8 13 21 34 55 89 144
233 377 610 987

Sample run:
Up to which number do you want to generate Fibonacci numbers? 610
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
 */