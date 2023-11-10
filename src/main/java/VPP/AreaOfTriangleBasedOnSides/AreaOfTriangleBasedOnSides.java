package VPP.AreaOfTriangleBasedOnSides;

import java.util.Scanner;

public class AreaOfTriangleBasedOnSides {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the first side: ");
        double side1 = input.nextDouble();
        System.out.print("Enter the length of the second side: ");
        double side2 = input.nextDouble();
        System.out.print("Enter the length of the third side: ");
        double side3 = input.nextDouble();

        if(side1 > side2+side3 || side2 > side3+side1 || side3 > side1+side2){
            System.out.println("Such a triangle does not exist!");
        }
        else{
            double s = (side1+side2+side3)/2;
            double area = Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
            System.out.println("The area of the triangle is: " + area);
        }
    }
}
/*
Calculate the area of a triangle based on the length of its sides (you can find
the formula after some googling).
If the triangle cannot exist (one side is longer that the other two combined)
report so.

Input 1:
Enter the length of the first side: 2
Enter the length of the second side: 3
Enter the length of the third side: 4
Output 1:
The area of the triangle is: 2.9047375096555625

Input 2:
Enter the length of the first side: 2
Enter the length of the second side: 3
Enter the length of the third side: 6

Output 2:
Such a triangle does not exist!

HINT: if you can't easily find the formula, try https://www.cuemath.com/
measurement/area-of-triangle-with-3-sides/
 */