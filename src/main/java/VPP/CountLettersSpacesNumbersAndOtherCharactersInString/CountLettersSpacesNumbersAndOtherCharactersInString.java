package VPP.CountLettersSpacesNumbersAndOtherCharactersInString;

import java.util.Scanner;
public class CountLettersSpacesNumbersAndOtherCharactersInString {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("The string is : ");
        String sentence = input.nextLine();

        int letterCount = 0;
        int spaceCount  = 0;
        int numberCount = 0;
        int otherCount  = 0;

        for(int i = 0; i < sentence.length(); i++){
            char current = sentence.charAt(i);
            if(Character.isLetter(current)){
                letterCount++;
            }
            else if(Character.isDigit(current)){
                numberCount++;
            }
            else if(Character.isWhitespace(current)){
                spaceCount++;
            }
            else otherCount++;
        }

        System.out.println("letters: " + letterCount);
        System.out.println("spaces: " + spaceCount);
        System.out.println("digits: " + numberCount);
        System.out.println("other: " + otherCount);
    }
}
/*
Write a Java program to count the letters, spaces, digits and other characters
of an input string.
Expected Output

The string is :  Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33
letters: 23
spaces: 9
digits: 10
other: 6
 */