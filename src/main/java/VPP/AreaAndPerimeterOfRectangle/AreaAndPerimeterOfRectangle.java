package VPP.AreaAndPerimeterOfRectangle;

public class AreaAndPerimeterOfRectangle {
    public static void main(String[] args){
        double width = 5.6;
        double height = 8.5;

        System.out.printf("Area is %.1f * %.1f = %.2f\n",width,height,(width*height));
        System.out.printf("Perimeter is 2 * (%.1f + %.1f) = %.2f",width,height,2*(width+height));
    }
}
/*
Write a Java program to print the area and perimeter of a rectangle.
Test Data:
Width = 5.6 Height = 8.5

Expected Output
Area is 5.6 * 8.5 = 47.60
Perimeter is 2 * (5.6 + 8.5) = 28.20
 */