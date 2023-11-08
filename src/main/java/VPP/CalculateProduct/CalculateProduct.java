package VPP.CalculateProduct;

import java.util.Scanner;
public class CalculateProduct {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers do you want to multiply together? ");
        int times = input.nextInt();
        double result = 1.0;
        for(int i = 0; i < times; i++){
            System.out.print("Enter a number: ");
            result = result * input.nextDouble();
        }
        System.out.println("The product is: " + result);
    }
}
/*
Write a program that calculates the product of a given number of numbers

Example of run.
How many numbers do you want to multiply together? 3
Enter a number: 2
Enter a number: 3.5
Enter a number: 5

The product is: 35.0
 */