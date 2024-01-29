package vpp.CountFactors;

import java.util.Scanner;
public class CountFactors {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int number = input.nextInt();
        //below statement is
        int count = (number <= 0) ? 0:1;
        for(int i = 1; i <= number/2; i++){
            if(number%i == 0)count++;
        }
        System.out.println(count);
        System.out.println(numberOfFactors(number));


    }

    //solution VPP
    public static int numberOfFactors(int number) {
        int factorCount = 0;
        int i = 1;
        for (; i * i < number; i++) {
            if (number % i == 0) factorCount += 2;
        }
        if (i * i == number) factorCount++;
        return factorCount;
    }
}
/*
Write a Java program to accepts an integer and count the factors of the number.
Sample Output:

Input an integer: 25
3
 */