package vpp.AlphabetAnimalGame;

import java.util.List;
import java.util.Scanner;
public class AlphabetAnimalGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Name an animal: ");
        String animalEntered = input.next();
        System.out.println(returnAnAnimal(animalEntered));
    }

    private static String returnAnAnimal(String namedAnimal){
        List<String> animalNames = List.of("dog", "cat", "turtle", "tiger", "lion", "snake", "giraffe", "elephant");
        char lastChar = namedAnimal.toLowerCase().charAt(namedAnimal.length()-1);
        for(String name: animalNames){
            if(lastChar == name.charAt(0)){
                return name;
            }
        }
        return "I don't know any animal whose name starts with '" + lastChar + "'. You win!";
    }
}
/*

There is a game where someone must say an animal name (like 'ant') and the next
player has to say the name of an
animal that starts with the last letter of that animal (like 'termite'), a
third player should mention an animal
    whose name starts with the last letter of THAT (like an 'eagle')

Goal: create a game where you can enter an animal, and the program responds by
naming an animal whose name starts with the last letter of the animal you mentioned,
or "I don't know any animal whose name starts with '[letter]'.
You win!" if the computer does not know any animal whose name starts with the
correct letter.

    Example run 1:
    Name an animal: cat
    turtle!

    Example run 2:
    Name an animal: dog
    I don't know any animal whose name starts with 'g'. You win!

    Hint: some sample animal names: cat, dog, turtle.
 */