package VPP.LearningAlphabetAnimalGame;

import java.util.ArrayList;
import java.util.Scanner;
public class LearningAlphabetAnimalGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("snake");
        animals.add("turtle");
        char choice = 'y';
        boolean foundAnAnimal = false;

        while(choice == 'y'){
            if(foundAnAnimal){
                System.out.print("Your turn! ");
                foundAnAnimal = false;
            }
            else{
                System.out.print("name an animal: ");
            }
            String namedAnimal = input.next().toLowerCase();
            for(String s: animals){
                //if(s.charAt(0) == namedAnimal.charAt(namedAnimal.length()-1)){
                if(namedAnimal.endsWith(s.substring(0,1))){
                    foundAnAnimal = true;
                    System.out.println(s + "!");
                    break;
                }
            }
            if(!foundAnAnimal){
                System.out.printf("I don't know any animal whose name starts with %c. You win!", namedAnimal.charAt(namedAnimal.length()-1));
                System.out.print("What would have been a good answer? ");
                String newAnimal = input.next().toLowerCase();
                animals.add(newAnimal);
                System.out.print("Do you want to play again? (y/n)");
                choice = input.next().toLowerCase().charAt(0);
            }

        }
    }

}
/*
There is a game where someone must say an animal name (like 'ant') and the next
player has to say the name of an
animal that starts with the last letter of that animal (like 'termite'), a
third player should mention an animal
    whose name starts with the last letter of THAT (like an 'eagle')

Goal: create a game where you can enter an animal, and the program responds by
naming an animal whose name starts
    with the last letter of the animal you mentioned.
If the program does not know an appropriate animal, it should say "I don't know
any animal whose name starts with
    '[letter]'. You win! What would have been a good answer?"
    The player can then enter an animal name.
    The game then asks whether the player wants to play again.
Let's also extend the game that if the computer replies, the player should
mention another animal.

    Example run
    Name an animal: dog
I don't know any animal whose name starts with 'g'. You win! What would have
been a good answer? goldfish
    Do you want to play again? yes
    Name an animal: dog
    goldfish!
    Your turn! hawk
I don't know any animal whose name starts with 'k'. You win! What would have
been a good answer? koala
    Do you want to play again? no
    Thank you for playing!

    Hint: some sample animal names: cat, dog, turtle.
 */