package PlayersGuide.RandomUtils;

import java.util.Arrays;
import java.util.Random;

public class RandomUtils extends Random {
    public static void main(String[] args) {
        double dVal = nextMyDouble(-10.0);
        String coinTossed = coinFlip();
        String[] options = {"north, south, west, east"};
        String chosenString1 = nextString("north", "south", "west", "east");
        String chosenString2 = nextString(options);

        System.out.printf("""
                random double: %f
                coin toss: %s
                random String1: %s
                random String2: %s""", dVal, coinTossed, chosenString1, chosenString2);
    }

    public static double nextMyDouble(double maximum) {
        if (maximum < 0.0) return -new Random().nextDouble(Math.abs(maximum));
        if (maximum == 0.0) return 0.0;
        return new Random().nextDouble(maximum);
    }

    public static String coinFlip() {
        return coinFlip(50);
    }

    public static String coinFlip(int percentChanceOfHeads) {
        if (percentChanceOfHeads < 0 || percentChanceOfHeads > 100) {
            System.out.println("% is a value 0-100");
            return "No coin flip possible";
        }
        double chance = percentChanceOfHeads / 100.0;
        double randomDouble = nextMyDouble(1.0);
        if (randomDouble < chance) return "heads";
        else return "tails";
    }

    public static String nextString(String... possibleStrings) {
        String[] tryOut =
                Arrays.toString(possibleStrings).replace("[", "").replace("]", "").split(", ");
        int randomChoice = (int) (nextMyDouble(tryOut.length));
        return tryOut[randomChoice];
    }
}
/*
Add a static nextDouble method that gives a maximum value for a
randomly generated double.
Add a static nextString method that allows you to pass in any number of string
values (using varargs) and randomly pick one of them.
Add a static coinFlip method that randomly picks a boolean value.
Made an overload of the coinFlip method that has a parameter
that indicates the frequency of heads coming up, which should default to 0.5, or 50% of the time.
Bonus: try to make one coinFlip method refer to the other coinFlip method to reduce code duplication.
 */