package vpp.Hangman;

import java.util.ArrayList;
import java.util.Scanner;
public class Hangman {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("user 1 please enter the word: ");
        String word = input.next().toUpperCase();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        ArrayList<Character> guessed = new ArrayList<>();
        ArrayList<Character> guessedWord = new ArrayList<>();

        for(int i = 0; i <word.length(); i++){
            guessedWord.add('_');
        }

        for(int i = 1; i < 10; i++){
            System.out.print("Guess a letter: ");
            String letter = input.next().toUpperCase();
            System.out.println();
            char letterChar = letter.charAt(0);
            if(guessed.contains(letterChar)){
                System.out.println("You already tried this!");
                i--;
            }else{
                guessed.add(letterChar);
                for(int j = 0; j < word.length(); j++){
                    if(word.charAt(j) == letterChar){
                        guessedWord.set(j, letterChar);
                    }
                }
            }
            StringBuilder result = new StringBuilder(word.length());
            guessedWord.forEach(result::append);
            System.out.println(result);
            if(result.toString().equals(word)){
                System.out.println("You guessed it!");
                break;
            }
            if(i == 9){
                System.out.println("You didn't find the word within 10 guesses");
                System.out.println("the word was: " + word);
                break;
            }
        }

    }
}
/*
Make a Hangman game
user 1 should enter a word
user 2 should see only underscores for each letter in the word, and should
guess a letter
if a letter is correct, the underscore in the displayed word is replaced by the
correct letter
if the word has been filled in completely, display the message that the user
has won
if the word has not been filled in completely after a number of turns (say 10),
display that the user has lost,
and show the word.
 */