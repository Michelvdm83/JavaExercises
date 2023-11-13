package VPP.CapitalizeEachWordInASentence;

import java.util.Scanner;
public class CapitalizeEachWordInASentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a Sentence: ");
        String sentence = input.nextLine();
        String newSentence = "";
        int index = 0;
        int nextSpace = 0;
        while(sentence.indexOf(" ") > 0){
            nextSpace = sentence.indexOf(" ");
            String word = sentence.substring(index, nextSpace);
            newSentence += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
            sentence = sentence.substring(nextSpace+1);
        }
        newSentence += sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
        System.out.println(newSentence);
    }

}
/*
Write a Java program to capitalize the first letter of each word in a sentence.
Sample Output:

Input a Sentence: the quick brown fox jumps over the lazy dog.
The Quick Brown Fox Jumps Over The Lazy Dog.
 */