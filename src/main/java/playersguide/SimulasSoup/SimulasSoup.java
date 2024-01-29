package playersguide.SimulasSoup;

import java.util.Scanner;

public class SimulasSoup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Soup soup = new Soup();
        System.out.println("Please choose your type of course.");
        for (Soup.Type type : Soup.Type.values()) {
            System.out.println(type);
        }
        try {
            soup.setType(Soup.Type.valueOf(input.next().toUpperCase()));
        } catch (IllegalArgumentException e) {
            soup.setType(Soup.Type.SOUP);
        }

        System.out.println("Please choose your Main Ingredient.");
        for (Soup.MainIngredient ingredient : Soup.MainIngredient.values()) {
            System.out.println(ingredient);
        }
        try {
            soup.setIngredient(Soup.MainIngredient.valueOf(input.next().toUpperCase()));
        } catch (IllegalArgumentException e) {
            soup.setIngredient(Soup.MainIngredient.CHICKEN);
        }

        System.out.println("Please choose your type of seasoning.");
        for (Soup.Seasoning seasoning : Soup.Seasoning.values()) {
            System.out.println(seasoning);
        }
        try {
            soup.setSeasoning(Soup.Seasoning.valueOf(input.next().toUpperCase()));
        } catch (IllegalArgumentException e) {
            soup.setSeasoning(Soup.Seasoning.SWEET);
        }

        System.out.println("We've made you a " + soup);
        System.out.println("Enjoy!");
    }
}
