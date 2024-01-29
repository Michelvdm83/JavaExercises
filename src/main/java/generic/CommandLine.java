package generic;

import java.util.Scanner;

import static generic.AnsiColors.RESET;

public class CommandLine {

    private static final Scanner in = new Scanner(System.in);

    private static int askForInt() {
        do {
            try {
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        } while (true);
    }

    private static int askForInt(int min, int max) {
        do {
            int returnInt = askForInt();
            if (min <= returnInt && returnInt <= max) {
                return returnInt;
            } else {
                System.out.printf("Please enter a number between %d and %d (both inclusive)%n", min, max);
            }
        } while (true);
    }

    public static int askForInt(String prompt) {
        System.out.print(prompt);
        return askForInt();
    }

    public static int askForInt(String prompt, int min, int max) {
        System.out.print(prompt);
        return askForInt(min, max);
    }

    public static String askForString(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }

    public static String askForStringFromMenu(String... options) {
        if (options.length < 1) return "";
        int choice = askForIntFromMenu(options);
        return options[choice - 1];
    }

    public static int askForIntFromMenu(String... options) {
        if (options.length < 1) return 0;// >throw exception, want method word dan fout gebruikt
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }
        return askForInt(1, options.length);
    }

    public static String getStringColored(String text, AnsiColors color) {
        return color.getColor() + text + RESET.getColor();
    }
}
//try catch vervangen door if/else


