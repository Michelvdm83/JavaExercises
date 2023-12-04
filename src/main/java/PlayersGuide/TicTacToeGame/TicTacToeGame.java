package PlayersGuide.TicTacToeGame;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Please enter the name for who plays 'X': ");
            game.setPlayerX(input.next());
            System.out.print("Please enter the name for who plays 'O': ");
            game.setPlayerO(input.next());
            //just to make it repeatable
            do {
                game.play();
                System.out.print("Do you want to play another game together, " + game.getPlayerX() + " and " + game.getPlayerO() + "?");

            } while (input.next().equalsIgnoreCase("yes"));

            System.out.print("Do you want to play again with other players? ");
        }while (input.next().equalsIgnoreCase("yes"));
    }
}
