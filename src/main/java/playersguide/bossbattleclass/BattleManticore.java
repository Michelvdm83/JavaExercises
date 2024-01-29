package playersguide.bossbattleclass;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static playersguide.ansicolors.AnsiColors.*;

//if I would make a class inherit BattleManticore (like BattleManticoreSinglePlayer,
//I could override the setDistance method,
//while keeping the other methods

public class BattleManticore {
    private final int CITY_MAX_HP;
    private final int MANTICORE_MAX_HP;
    private int cityHP;
    private int manticoreHP;
    private final Scanner input;
    private boolean singlePlayer;

    public BattleManticore(int cityMaxHP, int manticoreMaxHP, Scanner input) {
        CITY_MAX_HP = cityMaxHP;
        MANTICORE_MAX_HP = manticoreMaxHP;
        cityHP = CITY_MAX_HP;
        manticoreHP = MANTICORE_MAX_HP;
        this.input = input;
    }

    public void startGame() {
        System.out.print("Do you want to play single player?(yes/no)");
        String choice = input.next().toLowerCase();
        singlePlayer = choice.equals("yes");
        int distanceOfManticore = setDistance();
        battle(distanceOfManticore);
    }

    private int setDistance() {
        if (singlePlayer) {
            System.out.println("Distance will be set randomly (0-100)");
            Random random = new Random();
            return random.nextInt(100);
        }
        System.out.print("Player 1, how far away from the city do you want to station the Manticore?(0-100) ");
        do {
            int distance = input.nextInt();
            if (0 < distance && distance <= 100) {
                for (int i = 0; i < Toolkit.getDefaultToolkit().getScreenSize().height; i++) {
                    System.out.println();
                }
                return distance;
            }
            System.out.println("that is not within range");
            System.out.print("Please enter a new range (0-100): ");
        } while (true);
    }

    private void battle(int distanceOfManticore) {
        int round = 1;
        int damage;

        if (singlePlayer) {
            System.out.println("Player, are you ready?");
        } else {
            System.out.println("Player 2, it is your turn.");
        }
        do {
            if (round % 3 == 0 && round % 5 == 0) damage = 10;
            else if (round % 3 == 0 || round % 5 == 0) damage = 3;
            else damage = 1;

            System.out.println("-----------------------------------------------------------");
            System.out.printf("STATUS: Round: %d City: %d/%d Manticore: %d/%d%n"
                    , round, cityHP, CITY_MAX_HP, manticoreHP, MANTICORE_MAX_HP);
            System.out.printf("The cannon is expected to deal %d damage this round.%n", damage);
            System.out.print("Enter desired cannon range: ");
            int range = input.nextInt();
            if (range > distanceOfManticore) {
                System.out.println("That round " + ANSI_BLUE + "OVERSHOT" + ANSI_RESET + " the target.");
            } else if (range < distanceOfManticore) {
                System.out.println("That round " + ANSI_YELLOW + "FELL SHORT" + ANSI_RESET + " of the target.");
            } else {
                System.out.println("That round was a " + ANSI_RED + "DIRECT HIT!" + ANSI_RESET);
                manticoreHP -= damage;
            }
            if (manticoreHP <= 0) {
                System.out.println("The Manticore has been " + ANSI_PURPLE + "destroyed!" + ANSI_RESET + " The city of Consolas has been " + ANSI_GREEN + "saved!" + ANSI_RESET);
                return;
            } else {
                cityHP--;
            }
            round++;
        } while (cityHP > 0);
        System.out.println("The Manticore destroyed the city!");
    }
}