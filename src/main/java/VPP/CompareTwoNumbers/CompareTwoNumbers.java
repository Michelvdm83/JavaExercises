package VPP.CompareTwoNumbers;

import java.util.Scanner;
public class CompareTwoNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input first integer: ");
        int first = input.nextInt();
        System.out.print("Input second integer: ");
        int second = input.nextInt();
        if(first == second)System.out.printf("%d == %d\n",first,second);
        if(first != second)System.out.printf("%d != %d\n",first,second);
        if(first >  second)System.out.printf("%d > %d\n",first,second);
        if(first >= second)System.out.printf("%d >= %d\n",first,second);
        if(first <  second)System.out.printf("%d < %d\n",first,second);
        if(first <= second)System.out.printf("%d <= %d\n",first,second);
    }
}
/*
Write a Java program to compare two numbers.
(test for ==, !=, >, >=, <, <=; only show those relationships that are TRUE)

Input Data:
Input first integer: 25
Input second integer: 39
Expected Output

25 != 39
25 < 39
25 <= 39
 */