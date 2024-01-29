package playersguide.SimulasTest;

import java.util.Scanner;

enum BoxState {
    CLOSED,
    OPEN,
    LOCKED
}

public class SimulasTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BoxState boxState = BoxState.CLOSED;
        System.out.println("Enter commands to change the state of the box.");
        System.out.println("Options are: unlock, lock, open, close");
        while (true) {
            System.out.printf("The chest is %s. What do you want to do? ", boxState.toString().toLowerCase());
            String action = input.next().toUpperCase();
            if (action.equals("BREAK")) {
                System.out.println("You've broken the box!");
                break;
            }

            switch (boxState) {
                case CLOSED -> {
                    if (action.equals("OPEN")) {
                        boxState = BoxState.OPEN;
                    } else if (action.equals("LOCK")) {
                        boxState = BoxState.LOCKED;
                    } else {
                        System.out.println("This is not a possibility!");
                    }
                }
                case OPEN -> {
                    if (action.equals("CLOSE")) {
                        boxState = BoxState.CLOSED;
                    } else {
                        System.out.println("This is not a possibility!");
                    }
                }
                case LOCKED -> {
                    if (action.equals("UNLOCK")) {
                        boxState = BoxState.CLOSED;
                    } else {
                        System.out.println("This is not a possibility!");
                    }
                }
                default -> System.out.println("This is not an option");
            }
        }
    }
}
