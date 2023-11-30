package PlayersGuide.VinFletchersArrows;

import java.util.Scanner;
public class VinFletchersArrows {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Arrow newArrow = null;
        boolean customArrow = false;
        System.out.println("Please choose your type of arrow:");
        System.out.println("1. Elite Arrow\n2. Beginner Arrow\n3. Marksman Arrow\nAll other input will make a Custom Arrow");
        switch(input.nextInt()){
            case 1 -> newArrow = Arrow.createEliteArrow();
            case 2 -> newArrow = Arrow.createBeginnerArrow();
            case 3 -> newArrow = Arrow.createMarksmanArrow();
            default -> customArrow = true;
        }
        if(customArrow) {
            System.out.print("Enter the arrow's length(60-100): ");
            int arrowLength = input.nextInt();

            System.out.println("What kind of arrow head would you like?");
            System.out.println("The options are:");
            for (Arrow.ArrowHead a : Arrow.ArrowHead.values()) {
                System.out.println(a);
            }
            String arrowHead = input.next().toUpperCase();

            System.out.println("What kind of fletching do you want?");
            System.out.println("The options are:");
            for (Arrow.Fletching f : Arrow.Fletching.values()) {
                System.out.println(f);
            }
            String fletching = input.next().toUpperCase();

            newArrow = new Arrow(arrowLength, arrowHead, fletching);
        }
        System.out.printf("You've got an %d cm long arrow,%n", newArrow.getArrowLength());
        System.out.printf("with an arrow head of %s%n", newArrow.getArrowHead());
        System.out.printf("and a fletching of %s%n", newArrow.getFletching());
        System.out.println("This will cost: " + newArrow.getCost() + "gold.");
    }
}
