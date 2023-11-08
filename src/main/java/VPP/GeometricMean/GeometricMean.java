package VPP.GeometricMean;

import java.util.Scanner;
public class GeometricMean {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int count = input.nextInt();
        double[] numbers = new double[count];
        double subResult = 1.0;
        for(int i = 0; i < count; i++){
            System.out.print("Enter a real number: ");
            numbers[i] = input.nextDouble();
            subResult *= numbers[i];
        }
        double result = Math.pow(subResult,((double) 1 /count));
        System.out.println("The geometric mean is: " + result);
    }
}
/*
Write a program to calculate the geometric mean of a set of numbers.
Hint:
The geometric mean is calculated using n√(a1 × a2 × ... × an)
(the nth power root of (a1 × a2 × ... × an))

Example:
Enter the number of values: 5
Enter a real number: 4.31
Enter a real number: 3.98
Enter a real number: 1.90
Enter a real number: 4.42
Enter a real number: 9.19
The geometric mean is: 4.210855561928519
 */