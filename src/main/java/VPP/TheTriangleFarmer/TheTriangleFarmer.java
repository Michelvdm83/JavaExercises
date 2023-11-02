package VPP.TheTriangleFarmer;

import java.util.Scanner;

public class TheTriangleFarmer {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("input triangle base size: ");
        double base = input.nextDouble();
        System.out.print("input triangle height: ");
        double height = input.nextDouble();
        double area = base*height / 2;
        System.out.println("The area of your triangle is: " + area);
    }
}
/*
Area = base x height / 2

Objectives:

- Write a program that lets you input the triangle’s base size and height.
- Compute the area of a triangle by turning the above equation into code.
- Write the result of the computation.
 */