package PlayersGuide.DefenseOfConsolas;

import java.awt.*;
import java.util.Scanner;

public class DefenseOfConsolas {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Target row? ");
        int row = input.nextInt();
        System.out.print("Target column? ");
        int column = input.nextInt();
        System.out.println("Deploy to:");
        System.out.printf("%s(%d, %d)%s%n", ANSI_RED, row - 1, column, ANSI_RESET);
        System.out.printf("%s(%d, %d)%s%n", ANSI_BLUE, row + 1, column, ANSI_RESET);
        System.out.printf("%s(%d, %d)%s%n", ANSI_YELLOW, row, column - 1, ANSI_RESET);
        System.out.printf("%s(%d, %d)%s", ANSI_GREEN, row, column + 1, ANSI_RESET);
        Toolkit.getDefaultToolkit().beep();
    }
}
