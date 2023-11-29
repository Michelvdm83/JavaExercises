package PlayersGuide.BuyingInventory;

import java.util.Scanner;
public class BuyingInventory {
    public static void main(String[] args){
        //discounted inventory, structured solution
        Scanner input = new Scanner(System.in);
        String[] products = {"Rope", "Torches", "Climbing Equipment", "Clean Water", "Machete", "Canoe", "Food Supplies"};
        int[] prices = {10, 15, 25, 1, 20, 200, 1};

        System.out.print("What is your name? ");
        String name = input.nextLine().toLowerCase();

        for(int i = 0; i < products.length; i++) {
            System.out.printf("%d.%s%n", i+1, products[i]);
        }
        System.out.print("What number do you want to see the price of? ");
        int choice = input.nextInt()-1;
        if(choice < 0 || choice > 6){
            System.out.println("this is not a product!");
        }
        else {
            double price = name.equals("michel") ? (double) prices[choice] / 2 : prices[choice];
            System.out.println(products[choice] + " cost " + price + " gold");
        }


        //buying inventory, simple solution
        /*System.out.println("""
        The following items are available:

        1.Rope
        2.Torches
        3.Climbing Equipment
        4.Clean Water
        5.Machete
        6.Canoe
        7.Food Supplies""");
        System.out.print("What number do you want to see the price of? ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        String output = switch(choice){
            case 1 -> "Rope cost 10 gold";
            case 2 -> "Torches cost 15 gold";
            case 3 -> "Climbing equipment cost 25 gold";
            case 4 -> "Clean water cost 1 gold";
            case 5 -> "Machete cost 20 gold";
            case 6 -> "Canoe cost 200 gold";
            case 7 -> "Food supplies cost 1 gold";
            default -> "This is not a product";
        };
        System.out.println(output);*/
    }
}
/*
You search around the shop and find ledgers that show the following prices for these items: Rope: 10
gold, Torches: 15 gold, Climbing Equipment: 25 gold, Clean Water: 1 gold, Machete: 20 gold, Canoe: 200
gold, Food Supplies: 1 gold.
 */