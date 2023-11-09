package VPP.CalculateAverage;

import java.util.Scanner;
public class CalculateAverage {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers do you want to average? ");
        int count = input.nextInt();
        double total = 0.0;
        for(int i = 0; i < count; i++){
            System.out.print("Enter a number: ");
            total += input.nextDouble();
        }
        double result = total/count;
        System.out.println("The average is: " + result);
    }
}
/*
Write a program that averages numbers.

Example of run.
How many numbers do you want to average? 3
Enter a number: 1.5
Enter a number: 2
Enter a number: 2.3

The average is: 1.9333333333333333
 */