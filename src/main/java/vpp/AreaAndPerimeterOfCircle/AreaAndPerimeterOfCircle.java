package vpp.AreaAndPerimeterOfCircle;

public class AreaAndPerimeterOfCircle {
    public static void main(String[] args){
        double Radius = 7.5;
        double Area = Math.PI * Radius * Radius;
        double Perimeter = 2 * Math.PI * Radius;
        System.out.println("Perimeter is : " + Perimeter);
        System.out.println("Area is : " + Area);
    }
}
/*Radius = 7.5
Expected Output
Perimeter is = 47.12388980384689
Area is = 176.71458676442586*/