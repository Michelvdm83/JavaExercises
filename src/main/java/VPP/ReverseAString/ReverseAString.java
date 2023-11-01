package VPP.ReverseAString;

import java.lang.StringBuilder;
import java.util.Scanner;
public class ReverseAString {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("input a string: ");
        String sentence = input.nextLine();
        StringBuilder build = new StringBuilder(sentence);
        System.out.println("Reverse string: " + build.reverse());
    }
}
/*
Write a Java program to reverse a string.
Input Data:
Input a string: The quick brown fox
Expected Output

Reverse string: xof nworb kciuq ehT
HINT: To work with Strings, the StringBuilder class can also be handy...

 */