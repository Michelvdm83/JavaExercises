package playersguide.bossbattleclass;

import java.awt.*;
import java.util.Random;

import static generic.CommandLine.*;

public class BattleManticore {
    private final int CITY_MAX_HP;
    private final int MANTICORE_MAX_HP;
    private final int MAX_DISTANCE = 100;
    private final int MIN_DISTANCE = 1;
    private int cityHP;
    private int manticoreHP;
    private boolean singlePlayer;

    public BattleManticore(int cityMaxHP, int manticoreMaxHP) {
        CITY_MAX_HP = cityMaxHP;
        MANTICORE_MAX_HP = manticoreMaxHP;
        cityHP = CITY_MAX_HP;
        manticoreHP = MANTICORE_MAX_HP;
    }

    public void startGame() {
        System.out.println("Do you want to play single player?");
        String choice = askForStringFromMenu("yes", "no");
        singlePlayer = choice.equals("yes");
        int distanceOfManticore = askDistance();
        battle(distanceOfManticore);
    }

    private int askDistance() {
        if (singlePlayer) {
            System.out.printf("Distance will be set randomly (%d-%d)%n", MIN_DISTANCE, MAX_DISTANCE);
            Random random = new Random();
            return random.nextInt(100) + 1;
        }

        String question = String.format("Player 1, how far away from the city do you want to station the Manticore?(%d-%d)%n", MIN_DISTANCE, MAX_DISTANCE);
        int distance = askForInt(question, MIN_DISTANCE, MAX_DISTANCE);
        for (int i = 0; i < Toolkit.getDefaultToolkit().getScreenSize().height; i++) {
            System.out.println();
        }
        return distance;
    }

    private void battle(int distanceOfManticore) {

        System.out.println(singlePlayer ? "Player, are you ready?" : "Player 2, it is your turn.");

        for (int round = 1; cityHP > 0; round++) {
            int damage;
            if (round % 3 == 0 && round % 5 == 0) damage = 10;
            else if (round % 3 == 0 || round % 5 == 0) damage = 3;
            else damage = 1;

            showCurrentState(round, damage);
            int range = askForInt("Enter desired cannon range: ", MIN_DISTANCE, MAX_DISTANCE);
            if (hasShotHit(range, distanceOfManticore)) {
                manticoreHP -= damage;
            }
            if (manticoreHP <= 0) {
                System.out.println("The Manticore has been " + purple.apply("destroyed!") +
                        " The city of Consolas has been " + green.apply("saved!"));
                return;
            } else {
                cityHP--;
            }
        }
        System.out.println(red.apply("The Manticore destroyed the city!"));
    }

    private void showCurrentState(int currentRound, int expectedDamage) {
        System.out.print("-".repeat(Toolkit.getDefaultToolkit().getScreenSize().width));
        System.out.println();
        System.out.printf("STATUS: Round: %d City: %d/%d Manticore: %d/%d%n"
                , currentRound, cityHP, CITY_MAX_HP, manticoreHP, MANTICORE_MAX_HP);
        System.out.printf("The cannon is expected to deal %d damage this round.%n", expectedDamage);
    }

    private boolean hasShotHit(int range, int distanceOfManticore) {
        if (range > distanceOfManticore) {
            System.out.println("That round " + blue.apply("OVERSHOT") + " the target.");
        } else if (range < distanceOfManticore) {
            System.out.println("That round " + yellow.apply("FELL SHORT") + " of the target.");
        } else {
            System.out.println("That round was a " + red.apply("DIRECT HIT!"));
            return true;
        }
        return false;
    }
}