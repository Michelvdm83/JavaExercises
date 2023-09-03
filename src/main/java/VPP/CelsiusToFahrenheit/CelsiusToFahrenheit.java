package VPP.CelsiusToFahrenheit;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double temperatureInCelsius = input.nextDouble();
        double temperatureInFahrenheit = temperatureInCelsius * 1.8 + 32;
        System.out.println("\nTemperature in Fahrenheit is: " + temperatureInFahrenheit);
    }
}
/*
Make a program that converts temperatures in centigrade to temperatures in
Fahrenheit.
Input:
Enter temperature in Centigrade: 30

Temperature in Fahrenheit is: 86.0

Fahrenheit=(celsius*1.8)+32
 */