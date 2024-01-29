package playersguide.TheLockedDoor;

import java.util.Scanner;

public class TheLockedDoor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a numeric passcode for your new door: ");
        int code = input.nextInt();
        Door door = new Door(code);
        System.out.println("Congratulations with your new, closed, door!");
        boolean testing = true;
        while (testing) {
            System.out.println("What do you want to do with your door?");
            System.out.println("Your door is currently " + door.getState());
            System.out.println("The possible actions are: ");
            System.out.println("1.Open\n2.close\n3.lock\n4.unlock\n5.change passcode\n6.remove");
            System.out.print("Please enter the number of your choice: ");
            switch (input.nextInt()) {
                case 1 -> door.openDoor();
                case 2 -> door.closeDoor();
                case 3 -> door.lockDoor();
                case 4 -> {
                    if (door.getState().equals("locked")) {
                        System.out.print("Please enter your passcode: ");
                        door.unlockDoor(input.nextInt());
                    } else {
                        door.unlockDoor(1);
                    }
                }
                case 5 -> {
                    System.out.print("Please enter the old passcode: ");
                    int oldCode = input.nextInt();
                    System.out.print("Please enter your new passcode: ");
                    int newCode = input.nextInt();
                    door.changeCode(oldCode, newCode);
                }
                case 6 -> testing = false;
                default -> System.out.println("This is not an option!");
            }
        }
    }
}
