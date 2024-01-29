package vpp.AreaOfHexagon;

import java.text.NumberFormat;
import java.util.Scanner;

public class AreaOfHexagon {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        NumberFormat twoDecimal = NumberFormat.getNumberInstance();
        twoDecimal.setMaximumFractionDigits(2);
        System.out.print("Input the length of a side: ");
        double hexagonSide = input.nextDouble();
        double hexagonArea = (6 * Math.pow(hexagonSide, 2)/(4 * Math.tan(Math.PI/6)));
        System.out.println("The area of the hexagon is: " + twoDecimal.format(hexagonArea));
    }
}
/*
Write a Java program to compute the area of a hexagon.
Area of a hexagon = (6 * s^2)/(4*tan(π/6))
where s is the length of a side
Input Data:
Input the length of a side of the hexagon: 6.0
Expected Output

The area of the hexagon is: 93.53074360871938

 */