package PlayersGuide.BossBattleClass;

import java.util.Scanner;

public class BossBattleClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BattleManticore game = new BattleManticore(15, 10, input);
        game.startGame();
    }
}