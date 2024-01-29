package vpp.ReturnSomethingToMe;

import java.util.Scanner;
public class ReturnSomethingToMe {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("what follows after something?");
        System.out.println(giveMeSomething(input.nextLine()));
    }

    private static String giveMeSomething(String attachment){
        return "something " + attachment;
    }
}

/*
Write a function that returns the string "something" joined with a space " "
and the given argument a.

Examples
giveMeSomething("is better than nothing") ➞ "something is better than nothing"
giveMeSomething("Bob Jane") ➞ "something Bob Jane"
giveMeSomething("something") ➞ "something something"

Notes: Assume an input is given.
 */