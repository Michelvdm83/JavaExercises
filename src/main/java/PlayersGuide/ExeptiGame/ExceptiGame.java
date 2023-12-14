package PlayersGuide.ExeptiGame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptiGame {
    private final List<Integer> guessedNumbers = new ArrayList<>();

    public static void main(String[] args) {
        ExceptiGame game = new ExceptiGame();
        game.run();
    }

    public ExceptiGame() {
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        String currentPlayer = "Player1";
        int winningNumber = (int) (Math.random() * 10);
        do {
            int numberGuessed = getNumber(currentPlayer + ", please guess a number: ", input);
            guessedNumbers.add(numberGuessed);
            if (numberGuessed == winningNumber)
                try {
                    //made own Exception for the message adding
                    //without the challenge demanding an Exception, I wouldn't use an Exception,
                    //because if someone reads this code, it would feel like it is something that's
                    //going wrong, while it is part of the game
                    throw new NumberGuessedException(currentPlayer + " guessed the number!");
                } catch (NumberGuessedException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            currentPlayer = currentPlayer.equals("Player1") ? "Player2" : "Player1";
        } while (guessedNumbers.size() != 10);
    }

    private int getNumber(String text, Scanner in) {
        int number;
        while (true) {
            System.out.print(text);
            try {
                number = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That's not a legal Integer value!");
                continue;
            }
            if (0 > number || number > 9) {
                System.out.println("Please guess a number 0-9");
                continue;
            }
            if (guessedNumbers.contains(number)) {
                System.out.println("Number has already be named!");
                continue;
            }
            return number;
        }
    }
}

