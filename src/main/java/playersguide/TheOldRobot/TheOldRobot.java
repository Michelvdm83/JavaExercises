package playersguide.TheOldRobot;

import java.util.Scanner;

public class TheOldRobot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Robot robot = new Robot();
        System.out.println("please enter your 3 commands for your robot:");
        System.out.println("Choose from the following commands:");
        System.out.println("""
                ON
                NORTH
                EAST
                SOUTH
                WEST
                OFF""");
        boolean addingCommands = true;
        while (addingCommands) {
            System.out.print("Please enter a command: ");
            String command = input.next().toUpperCase();
            switch (command) {
                case "ON" -> robot.addCommand(new OnCommand());
                case "OFF" -> robot.addCommand(new OffCommand());
                case "NORTH" -> robot.addCommand(new NorthCommand());
                case "SOUTH" -> robot.addCommand(new SouthCommand());
                case "EAST" -> robot.addCommand(new EastCommand());
                case "WEST" -> robot.addCommand(new WestCommand());
                case "STOP" -> addingCommands = false;
                default -> System.out.println("wrong command, please try again.");
            }
        }
        System.out.printf("You've entered %d commands", robot.getNumberOfCommands());
        robot.run();
    }
}
