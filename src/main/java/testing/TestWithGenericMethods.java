package testing;

import generic.CommandLine;

import static generic.AnsiColors.ANSI_RED;
import static generic.AnsiColors.ANSI_RESET;

public class TestWithGenericMethods {

    public static void main(String[] args) {
        int multiplier = 5;
        int min = 2;
        int max = 6;

        String prompt = "Please enter a whole number that you want to be multiplied by " + multiplier +
                " (range: " + min + "-" + max + "):";
        int input = CommandLine.askForInt(prompt, 2, 6);
        System.out.printf("You entered: %s%d%s%n", ANSI_RED, input, ANSI_RESET);
        int result = input * multiplier;
        System.out.printf("Multiplying it by %d gives %d%n", multiplier, result);

        String name = CommandLine.askForString("Please enter your name: ");
        String chosenName = CommandLine.askForStringFromMenu("Harry", "Gerard", "Else", "Michel");
        String[] nameList = new String[]{"Harry", "Gerard", "Else", "Michel"};
        String newChosenName = CommandLine.askForStringFromMenu(nameList);
        System.out.println(name + " " + chosenName + " " + newChosenName);
    }

}
