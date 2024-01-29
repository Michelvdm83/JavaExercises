package vpp.QuadraticEquationRoots;

import java.util.Scanner;
public class QuadraticEquationRoots {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first coefficient: ");
        int a = input.nextInt();
        System.out.print("Enter the second coefficient: ");
        int b = input.nextInt();
        System.out.print("Enter the third coefficient: ");
        int c = input.nextInt();

        if(a == 0){
            System.out.println("This is not a quadratic equation");
            System.exit(0);
        }
        if(Math.pow(b, 2) - (4 * a * c) < 0){//b2 - 4ac
            //here should be the calculations for imaginary roots
            System.out.println("These coefficients don't have real roots");
        }
        //if the calculation results in 0 there is actually only 1 root
        else{
            System.out.println("The roots are real and distinct.");
            // -b (+/-) sqrt(pow(b)-4ac / 2a
            double rootPart = Math.sqrt(Math.pow(b, 2.0) - (4*a*c));
            double root1 = (-b + rootPart) / (2*a);
            double root2 = (-b - rootPart) / (2*a);
            System.out.println("The root1 is: " + root1);
            System.out.println("The root2 is: " + root2);
        }
        //oops, forgot about the imaginary roots
    }
}
/*
Find the roots of a quadratic equation, given its coefficients.

Example:
Enter the first coefficient: 4
Enter the second coefficient: 7
Enter the third coefficient: 2
The roots are real and distinct.
The root1 is: -0.3596117967977924
The root2 is: -1.3903882032022077
 */