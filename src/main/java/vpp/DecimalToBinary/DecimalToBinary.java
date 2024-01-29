package vpp.DecimalToBinary;

import java.util.Scanner;
public class DecimalToBinary {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a Decimal Number: ");
        int decimal = input.nextInt();
        int decimal2 = decimal;
        System.out.println(Integer.toBinaryString(decimal));
        System.out.println(decimalToBinaryString(decimal));
        //teacher's solution
        StringBuilder binaryString = new StringBuilder();
        while (decimal > 0) {
            binaryString.insert(0, decimal % 2);
            decimal /= 2;
        }
        System.out.println("Binary number is: " + binaryString);
        //rewriting this solution as a recursive function for self-study
        System.out.println(recursiveSolution(decimal2));
    }

    private static String decimalToBinaryString(int decimal){
        String result = "";
        int binaryCount = 0;
        for(int i = 2; i <= decimal; i*=2){
            if(i*2 > decimal){
                binaryCount = i;
            }
        }
        for(int i = binaryCount; i > 0; i/=2){
            if(decimal >= i){
                result = result + 1;
                decimal = decimal - i;
            }
            else result = result + 0;
        }
        return result;
    }

    private static String recursiveSolution(int decimal){
        //if(decimal > 0)return recursiveSolution(decimal/2).concat("" + decimal%2);
        //return "";
        return decimal>0 ? recursiveSolution(decimal/2).concat("" + decimal%2) : "";

    }
}
//eigen eerste idee was met %, maar ipv "decimal" te halveren,
//zaten mijn gedachten vast op het verhogen v/d noemer v/d breuk.
//Hierdoor kwam ik uit met extra regels code om hetzelfde te realiseren
//Tip voor zelf: geef jezelf wat extra tijd


/*
Write a Java program to convert a decimal number to binary number.
Input Data:
Input a Decimal Number : 5
Expected Output

Binary number is: 101

**Challenge: it is really easy to do this with the Integer class in Java, but
it is kind of a rite of passage to write
  your own routine. So if you dare: try both routes
 */
