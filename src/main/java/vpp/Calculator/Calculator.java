package vpp.Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("""
        1. Addition
        2. Subtraction
        3. Multiplication
        4. Division
        
        """);
        System.out.print("Enter Your Choice : ");

        int choice = input.nextInt();
        switch(choice){
            case 1:
            case 2:
            case 3:
            case 4:
                calculate(choice, input);
                break;
            default: System.out.println(choice + " is not a valid choice!");
        }
    }

    private static void calculate(int operator, Scanner input){
        System.out.print("Please enter the first number: ");
        double firstNumber = input.nextDouble();
        System.out.print("Please enter the second number: ");
        double secondNumber = input.nextDouble();

        double result = switch(operator){
            case 1 -> firstNumber + secondNumber;
            case 2 -> firstNumber - secondNumber;
            case 3 -> firstNumber * secondNumber;
            case 4 -> firstNumber / secondNumber;
            default -> 0.0;
        };

        System.out.println("The result is: " + result);
    }
}
/*
Create a simple calculator, where the user can choose addition, subtraction,
multiplication and division.
After choosing an operation, the user should enter two numbers. The program
then displays the result.
Don't forget to handle errors: if the user types 0 or -5 or 7, no calculation
should take place!

HINT: Switch statements (or switch expressions) may be useful here.

Example run 1:

1. Addition
2. Subtraction
3. Multiplication
4. Division

Enter Your Choice : 2
Please enter the first number: 17.8
Please enter the second number: 4.5
The result is 13.3

Example run 2:
1. Addition
2. Subtraction
3. Multiplication
4. Division

Enter Your Choice : 5
5 is not a valid choice!
 */