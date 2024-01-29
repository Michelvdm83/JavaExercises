package playersguide.PackingInventory;

import java.util.Scanner;

public class PackingInventory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pack pack = new Pack(10, 10, 10);
        System.out.println("Your Pack is ready!");
        while (true) {
            System.out.println("Please choose what item to add from the list below:");
            System.out.println("""
                    1. Arrow
                    2. Rope
                    3. Water
                    4. Food rations
                    5. Sword
                    6. Bow""");

            System.out.println("Your pack currently contains:\n" + pack);
            System.out.print("Please enter your choice: ");
            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
                System.out.println("That's not a legal entry.\nPlease try again!");
                continue;
            }
            if (1 <= choice && choice <= 6) {
                InventoryItem newItem = switch (choice) {
                    case 1 -> new Arrow();
                    case 2 -> new Rope();
                    case 3 -> new Water();
                    case 4 -> new FoodRations();
                    case 5 -> new Sword();
                    case 6 -> new Bow();
                    default -> null;
                };
                if (pack.canItemBeAdded(newItem)) {
                    pack.add(newItem);
                    System.out.println("Item successfully added to your pack.");
                } else {
                    System.out.println("Item not added to your pack");
                }
            } else {
                System.out.println("That's not an option in the list!");
            }

            System.out.print("Want to add another item?(y/n) ");
            char another = input.next().toLowerCase().charAt(0);
            input.nextLine();
            if (!(another == 'y')) break;
        }
    }
}
/*
An arrow has a weight of 0.1 and a volume of 0.05.
A bow has a weight of 1 and a volume of 4.
Rope has a weight of 1 and a volume of 1.5.
Water has a weight of 2 and a volume of 3.
Food rations have a weight of 1 and a volume of 0.5.
A sword has a weight of 5 and a volume of 3.
 */