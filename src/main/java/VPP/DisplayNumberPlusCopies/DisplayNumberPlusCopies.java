package VPP.DisplayNumberPlusCopies;

import java.util.Scanner;

public class DisplayNumberPlusCopies {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = in.nextInt();
        System.out.printf("%d + %<d%<d + %<d%<d%<d\n", number);
    }
}
/*
Write a Java program that accepts an integer (n) and displays n + nn + nnn.
Sample Output:

Input number: 5
5 + 55 + 555
 */
