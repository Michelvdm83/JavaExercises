package vpp.NFibonacci;

import java.util.Scanner;
public class NFibonacci {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many Fibonacci numbers do you want to generate? ");
        int count = input.nextInt();
        long previous = 0;
        long current = 1;
        for(int i = 1; i <= count; i++){
            System.out.print(current + " ");
            long last = previous;
            previous = current;
            current = previous + last;
        }
    }
}
/*
The Italian mathematician Fibonacci once devised a sequence to model the growth
of rabbit populations (one pair would
procreate after two months and then every subsequent month produce another pair
which would also procreate after two months

In fact, his sequence turned out to be very bad at modeling rabbit populations,
but it is very popular for introductory
computer science courses.

The logic in the sequence is simple: you start with 1 1, and every next number
is the sum of the previous two numbers.
So you get a series like 1 1 2 3 5 8 13 21 ... (1+1=2, 1+2=3, 2+3=5, 3+5=8,
5+8=13 etc.)

Create a program that asks for the number of Fibonacci numbers to calculate. So
if the user wants 10 Fibonacci
numbers, the program should produce 1 1 2 3 5 8 13 21 34 55

Note that if you try larger numbers than 10 (actually, more than 46 numbers),
the next Fibonacci numbers become
negative! Mathematically, that should be impossible, but
1134903170 + 1836311903 = 2971215073 (2_971_215_073), which is bigger than the
maximum number that fits into a Java
integer (Integer.MAX_VALUE == 2147483647, or 2_147_483_647, or a bit more than
2.1 billion). This phenomenon is called
integer overflow (https://en.wikipedia.org/wiki/Integer_overflow) and happens
because an int does not have space for
higher precision numbers (as it is 32 bits, only about 4 billion values can be
represented accurately, and half of them
are negative values).

Since there are numbers larger than 2.1 billion that are occasionally useful,
like the number of people on the planet,
Java also has a 'bigger int' called long. Try to adjust the program to use long
values instead
of int. What is the number of Fibonacci numbers that you can correctly produce
now (more than 46, hopefully)

Sample run:
How many Fibonacci numbers do you want to generate? 50
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711
28657 46368 75025 121393 196418 317811
514229 832040 1346269 2178309 3524578 5702887 9227465 14930352 24157817
39088169 63245986 102334155 165580141 267914296
433494437 701408733 1134903170 1836311903 2971215073 4807526976 7778742049
12586269025

 */