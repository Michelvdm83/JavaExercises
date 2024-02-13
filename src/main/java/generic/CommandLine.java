package generic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

import static generic.AnsiColors.*;

public class CommandLine {

    private static final Scanner in = new Scanner(System.in);

    private static int askForInt() {
        do {
            if (in.hasNextInt()) {
                int returnInt = in.nextInt();
                in.nextLine();
                return returnInt;
            } else {
                in.nextLine();
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
        if (options.length < 1)
            throw (new IllegalArgumentException("method askForStringFromMenu needs at least 1 argument"));
        int choice = askForIntFromMenu(options);
        return options[choice - 1];
    }

    private static int calculateNrOfLinesForMenu(int nrOfOptions, int longestOptionLength) {
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getSize().width;
        int maxOptionsPerLine = screenWidth / longestOptionLength;

        int lines;
        if (nrOfOptions <= 5) {
            lines = nrOfOptions;
        } else if (nrOfOptions / maxOptionsPerLine < 5) {
            lines = 5;
        } else {
            lines = nrOfOptions / maxOptionsPerLine;
            if (nrOfOptions % maxOptionsPerLine > 0) lines++;
        }
        return lines;
    }

    public static int askForIntFromMenu(String... options) {
        if (options.length < 1)
            throw (new IllegalArgumentException("method askForIntFromMenu needs at least 1 argument"));

        var menu = new ArrayList<String>();
        int longestOptionSize = 0;
        for (int i = 1; i <= options.length; i++) {
            menu.add(i + ". " + options[i - 1]);
            longestOptionSize = Math.max(longestOptionSize, menu.get(i - 1).length());
        }
        longestOptionSize += 2;

        int size = menu.size();
        int lines = calculateNrOfLinesForMenu(size, longestOptionSize);

        String optionFormat = "%-" + longestOptionSize + "s";
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < size; j += lines) {
                System.out.printf(optionFormat, menu.get(i + j));
            }
            System.out.println();
        }
        return askForInt(1, options.length);
    }

    public static int askForIntFromMenu(String question, String[] options) {
        System.out.println(question);
        return askForIntFromMenu(options);
    }

    public static <T extends Enum<T>> T askForEnumValueFromEnumMenu(T[] enumValues) {
        String[] optionsAsStrings = new String[enumValues.length];
        for (int i = 0; i < enumValues.length; i++) {
            optionsAsStrings[i] = enumValues[i].toString().toLowerCase().replace("_", " ");
        }
        int choice = askForIntFromMenu(optionsAsStrings);
        return enumValues[choice - 1];
    }

    public static <T extends Enum<T>> T askForEnumValueFromEnumMenu(String question, T[] enumValues) {
        System.out.println(question);
        return askForEnumValueFromEnumMenu(enumValues);
    }

    public static boolean askYesOrNo(String prompt) {
        System.out.println(prompt);
        return (askForIntFromMenu("yes", "no") == 1);
    }

    private static String getStringColored(String text, AnsiColors color) {
        return color.getColor() + text + RESET.getColor();
    }

    public static UnaryOperator<String> getNewRGBColorStringOperator(int r, int g, int b) {
        if ((r < 0 || g < 0 || b < 0) || (r > 255 || g > 255 || b > 255))
            throw new IllegalArgumentException("rgb values range from 0-255 inclusive!");
        String color = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
        return (s -> color + s + RESET.getColor());
    }

    public static UnaryOperator<String> red = s -> getStringColored(s, RED);
    public static UnaryOperator<String> green = s -> getStringColored(s, GREEN);
    public static UnaryOperator<String> cyan = s -> getStringColored(s, CYAN);
    public static UnaryOperator<String> yellow = s -> getStringColored(s, YELLOW);
    public static UnaryOperator<String> blue = s -> getStringColored(s, BLUE);
    public static UnaryOperator<String> purple = s -> getStringColored(s, PURPLE);
    public static UnaryOperator<String> white = s -> getStringColored(s, WHITE);
}