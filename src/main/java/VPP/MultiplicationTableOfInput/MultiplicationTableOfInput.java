package VPP.MultiplicationTableOfInput;

import java.util.Scanner;

public class MultiplicationTableOfInput {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a number: ");
        int number = input.nextInt();

        for(int i=1; i <= 10; i++){
            System.out.printf("%d x %2d = %d%n",number,i,number*i);
        }
    }
}

/*
Write a Java program that takes a number as input and prints its multiplication
table upto 10. Go to the editor
Test Data:
Input a number: 8
Expected Output :
8 x 1 = 8
8 x 2 = 16
8 x 3 = 24
...
8 x 10 = 80
 */