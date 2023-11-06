package VPP.Factorial;

import java.util.Scanner;
public class Factorial {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer greater than zero, smaller than 20: ");
        int number = input.nextInt();
        System.out.printf("The factorial of %d is %d",number,factorial(number));
    }

    private static int factorial(int start){
        if(start > 1) return start*factorial(start-1);
        return start;
    }
}
/*
Calculate the factorial of a number: the factorial is the number x number -1 x
number - 2 .. 1
So 1! = 1, 2! = 2x1 = 2, 3! = 3 x 2 x 1 = 6, 4! = 4 x 3 x 2 x 1 = 24 etc.
See also https://en.wikipedia.org/wiki/Factorial

Sample run:
Please enter an integer greater than zero: 5
The factorial of 5 is 120
 */