package VPP.AverageOfThreeNumbers;

import java.util.Scanner;
public class AverageOfThreeNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("input first number: ");
        int first = input.nextInt();
        System.out.print("input second number: ");
        int second = input.nextInt();
        System.out.print("input third number: ");
        int third = input.nextInt();
        double average = (double)(first+second+third)/3;
        System.out.println("the average is: " + average);
    }
}
/*
Write a Java program that takes three numbers as input to calculate and print
the average of the numbers
 */