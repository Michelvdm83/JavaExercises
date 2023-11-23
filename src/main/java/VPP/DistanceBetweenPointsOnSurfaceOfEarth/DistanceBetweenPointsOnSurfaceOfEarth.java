package VPP.DistanceBetweenPointsOnSurfaceOfEarth;

import java.util.Scanner;
public class DistanceBetweenPointsOnSurfaceOfEarth {
    final static double RADIUS_EARTH = 6371.01;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input the latitude of coordinate 1: ");
        double lat1 = input.nextDouble();
        System.out.print("Input the longitude of coordinate 1: ");
        double long1 = input.nextDouble();
        System.out.print("Input the latitude of coordinate 2: ");
        double lat2 = input.nextDouble();
        System.out.print("Input the longitude of coordinate 2: ");
        double long2 = input.nextDouble();

        //from VPP answer, I was missing this step to come to the right solution
        double x1 = Math.toRadians(lat1);
        double y1 = Math.toRadians(long1);
        double x2 = Math.toRadians(lat2);
        double y2 = Math.toRadians(long2);

        double distance = RADIUS_EARTH * Math.acos(Math.sin(x1)*Math.sin(x2) + Math.cos(x1)*Math.cos(x2)*Math.cos(y1-y2));
        System.out.println("The distance between those points is: " + distance + " Kilometers");
    }
}
/*
Write a Java program to compute the distance between two points on the surface
of earth.
Distance between the two points [ (x1,y1) & (x2,y2)]
d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
Radius of the earth r = 6371.01 Kilometers
Input Data:
Input the latitude of coordinate 1: 25
Input the longitude of coordinate 1: 35
Input the latitude of coordinate 2: 35.5
Input the longitude of coordinate 2: 25.5
Expected Output

The distance between those points is: 1480.0848451069087 km
 */