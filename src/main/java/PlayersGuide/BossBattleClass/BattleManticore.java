package PlayersGuide.BossBattleClass;

import java.util.Scanner;

public class BattleManticore {
    private final int CITY_MAX_HP;
    private final int MANTICORE_MAX_HP;
    private int cityHP;
    private int manticoreHP;
    private final Scanner input;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public BattleManticore(int cityMaxHP, int manticoreMaxHP, Scanner input){
        CITY_MAX_HP = cityMaxHP;
        MANTICORE_MAX_HP = manticoreMaxHP;
        cityHP = CITY_MAX_HP;
        manticoreHP = MANTICORE_MAX_HP;
        this.input = input;
    }

    public void startGame(){
        int distanceOfManticore = setDistance();
        battle(distanceOfManticore);
    }

    private int setDistance(){
        System.out.print("Player 1, how far away from the city do you want to station the Manticore?(0-100) ");
        int distance = input.nextInt();
        while(distance < 0 || distance > 100){
            System.out.println("that is not within range");
            System.out.print("Please enter a new range (0-100): ");
            distance = input.nextInt();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        return distance;
    }

    private void battle(int distanceOfManticore){
        int round = 1;
        int damage;

        System.out.println("Player 2, it is your turn.");
        while(cityHP > 0){
            if(round%3 == 0 && round%5 == 0)damage = 10;
            else if(round%3 == 0 || round%5 == 0)damage = 3;
            else damage = 1;

            System.out.println("-----------------------------------------------------------");
            System.out.printf("STATUS: Round: %d City: %d/%d Manticore: %d/%d%n"
                    , round, cityHP, CITY_MAX_HP, manticoreHP, MANTICORE_MAX_HP);
            System.out.printf("The cannon is expected to deal %d damage this round.%n", damage);
            System.out.print("Enter desired cannon range: ");
            int range = input.nextInt();
            if(range > distanceOfManticore){
                System.out.println("That round " + ANSI_BLUE + "OVERSHOT" + ANSI_RESET + " the target.");
            }
            else if(range < distanceOfManticore){
                System.out.println("That round " + ANSI_YELLOW + "FELL SHORT" + ANSI_RESET + " of the target.");
            }
            else{
                System.out.println("That round was a " + ANSI_RED + "DIRECT HIT!" + ANSI_RESET);
                manticoreHP -= damage;
            }
            if(manticoreHP <= 0){
                System.out.println("The Manticore has been " + ANSI_PURPLE + "destroyed!" + ANSI_RESET + " The city of Consolas has been " + ANSI_GREEN + "saved!" + ANSI_RESET);
                return;
            }
            else{
                cityHP--;
            }
            round++;
        }
        System.out.println("The Manticore destroyed the city!");
    }
}