package PlayersGuide.BossBattle;

import java.util.Scanner;
public class BossBattle {
    private static final int CITY_MAX_HP = 15;
    private static final int MANTICORE_MAX_HP = 10;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Player 1, how far away from the city do you want to station the Manticore?(0-100) ");
        int distanceOfManticore = input.nextInt();
        while(distanceOfManticore < 0 || distanceOfManticore > 100){
            System.out.println("that is not within range");
            System.out.print("Please enter a new range (0-100): ");
            distanceOfManticore = input.nextInt();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Player 2, it is your turn.");

        int cityHP = CITY_MAX_HP;
        int manticoreHP = MANTICORE_MAX_HP;
        int round = 1;
        int damage;
        boolean gameWon = false;
        while(true){
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
                System.out.println("That round OVERSHOT the target.");
            }
            else if(range < distanceOfManticore){
                System.out.println("That round FELL SHORT of the target.");
            }
            else{
                System.out.println("That round was a DIRECT HIT!");
                manticoreHP -= damage;
            }
            if(manticoreHP <= 0){
                gameWon = true;
                break;
            }
            else{
                cityHP--;
            }
            if(cityHP <= 0){
                break;
            }
            round++;
        }
        if(gameWon){
            System.out.println("The Manticore has been destroyed! The city of Consolas has been saved!");
        }
        else{
            System.out.println("The Manticore destroyed the city!");
        }
    }
}
/*
For most turns, 1 point of damage is dealt. But if the turn number
is a multiple of 3, a fire blast deals 3 points of damage; a multiple of 5, an electric blast deals 3 points of
damage, and if it is a multiple of both 3 and 5, a mighty fire-electric blast deals 10 points of damage. The
Manticore is destroyed after taking 10 points of damage.

However, if the Manticore survives a turn, it will deal a guaranteed 1 point of damage to the city of
Consolas. The city can only take 15 points of damage before being annihilated.
Player 1, how far away from the city do you want to station the Manticore? 32
At this point, the display is cleared, and the second player gets their chance:

Player 2, it is your turn.
-----------------------------------------------------------
STATUS: Round: 1 City: 15/15 Manticore: 10/10
The cannon is expected to deal 1 damage this round.
Enter desired cannon range: 50
That round OVERSHOT the target.
-----------------------------------------------------------
STATUS: Round: 2 City: 14/15 Manticore: 10/10
The cannon is expected to deal 1 damage this round.
Enter desired cannon range: 25
That round FELL SHORT of the target.
-----------------------------------------------------------
STATUS: Round: 3 City: 13/15 Manticore: 10/10
The cannon is expected to deal 3 damage this round.
Enter desired cannon range: 32
That round was a DIRECT HIT!
 */
