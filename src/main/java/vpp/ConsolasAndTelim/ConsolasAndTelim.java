package vpp.ConsolasAndTelim;

import java.util.Scanner;

public class ConsolasAndTelim {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Bread is ready.");
        System.out.println("Who is this bread for?");
        System.out.println("Noted: " + input.nextLine() + " got bread.");
    }
}
/*
A sample run of this program looks like this:
Bread is ready.
Who is the bread for?
RB
Noted: RB got bread.

Objectives:
Make a program that runs as shown above, including taking a name from the user

To study if you find this difficult yet:
W3 schools Java Scanner
 */