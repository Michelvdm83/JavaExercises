package vpp.Hangman;

import java.util.ArrayList;
import java.util.Arrays;

import static generic.CommandLine.askForString;

public class Hangman {
    private final StringBuilder hangman = new StringBuilder("""
            ___________
            |  /   ccc
            | /     c
            |/      c
            |      ccc
            |\\     c c
            | \\
            ============""");
    private final ArrayList<Character> theMan = new ArrayList<>(Arrays.asList(
            '\\', '|', '/',
            '|',
            'o',
            '/', '0', '\\',
            '/', '\\'
    ));
    private final int TOTAL_GUESSES;

    public Hangman() {
        TOTAL_GUESSES = theMan.size();
    }

    private char askLetter() {
        do {
            String input = askForString("Guess a letter: ").toUpperCase().trim();
            char letter = input.charAt(0);
            if (input.length() == 1 && Character.isLetter(letter)) {
                System.out.println();
                return input.charAt(0);
            }
            System.out.println("Please enter a single letter");
        } while (true);
    }

    private String askTheWord() {
        do {
            String word = askForString("user 1 please enter the word: ").trim().toUpperCase();
            if (word.contains(" ")) {
                System.out.println("Please enter a single word");
            } else if (!word.chars().allMatch(Character::isLetter)) {
                System.out.println("Please use only letters");
            } else {
                System.out.println("\n".repeat(50));
                return word;
            }

        } while (true);
    }

    public void play() {
        String word = askTheWord().trim();
        ArrayList<String> guessedWord = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            guessedWord.add("_");
        }
        ArrayList<Character> guessedLetters = new ArrayList<>();

        do {
            char letter = askLetter();
            if (guessedLetters.contains(letter)) {
                System.out.println("You already tried this!");
                continue;
            }
            guessedLetters.add(letter);
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == letter) {
                    guessedWord.set(j, "" + letter);
                }
            }
            System.out.println(guessedWord);
            if (String.join("", guessedWord).equals(word)) {
                System.out.println("You guessedLetters it!");
                return;
            }
            hangman.setCharAt(hangman.indexOf("c"), theMan.remove(0));
            System.out.println(hangman.toString().replace("c", " "));
        } while (guessedLetters.size() != TOTAL_GUESSES);

        System.out.println("You didn't find the word within 10 guesses");
        System.out.println("the word was: " + word);
    }

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.play();
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
___________
|  /  \|/
| /    |
|/     o
|     /0\
|\    / \
| \
============
 */