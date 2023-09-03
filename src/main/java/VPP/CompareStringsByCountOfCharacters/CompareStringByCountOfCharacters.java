package VPP.CompareStringsByCountOfCharacters;

import java.util.Scanner;
public class CompareStringByCountOfCharacters {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Compare 2 strings on the number of Characters");

        System.out.print("Input first string: ");
        String firstString = input.nextLine();
        System.out.print("Input second string: ");
        String secondString = input.nextLine();
        System.out.println("\nEquality: " + CompareByCount(firstString, secondString));
    }

    private static boolean CompareByCount(String firstString, String secondString){
        return firstString.length()==secondString.length();
    }
}
/*
Compare Strings by Count of Characters
Create a function that takes two strings as arguments and return either true or
false depending on whether the
total number of characters in the first string is equal to the total number of
characters in the second string.

Examples
comp("AB", "CD") ➞ true
comp("ABC", "DE") ➞ false
comp("hello", "edabit") ➞ false
Notes
Don't forget to return the result.
 */