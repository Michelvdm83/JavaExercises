package PlayersGuide.TheOldRobot;

import java.util.Scanner;

public class TheOldRobot {
    public static void main(String[] args){
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
        for(int i = 1; i <= robot.getNumberOfCommands(); i++){
            System.out.print("command " + i + ": ");
            String command = input.next().toUpperCase();
            switch(command){
                case "ON"    -> robot.setCommands(new OnCommand2(), i);
                case "OFF"   -> robot.setCommands(new OffCommand2(), i);
                case "NORTH" -> robot.setCommands(new NorthCommand2(), i);
                case "SOUTH" -> robot.setCommands(new SouthCommand2(), i);
                case "EAST"  -> robot.setCommands(new EastCommand2(), i);
                case "WEST"  -> robot.setCommands(new WestCommand2(), i);
                default      -> {
                    System.out.println("wrong command, please try again.");
                    i--;
                }
            }
        }
        robot.run();
    }
}
