package VPP.IsPrime;

import java.util.Scanner;
public class IsPrime {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        /*for(int i = 2; i < Math.sqrt((double)number); i++){
            if(number%i == 0){
                System.out.printf("%d is not a prime number%n", number);
                System.exit(0);
            }
        }
        System.out.printf("%d is a prime number%n", number);*/
        //another possibility is:

        String noPrime = "";
        for(int i = 2; i < Math.sqrt(number); i++){
            if(number%i == 0){
                noPrime = " not";
                break;
            }
         }
        if(number <= 1) noPrime = " not"; //from VPP solution idea
        System.out.println(number + " is" + noPrime + " a prime");

    }
}
/*
Check whether a given number is a prime number.

Example run 1:
Enter an integer: 79
79 is a prime number

Example run 2:
Enter an integer: 21
21 is not a prime number
 */