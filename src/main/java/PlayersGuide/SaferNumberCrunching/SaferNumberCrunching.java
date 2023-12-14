package PlayersGuide.SaferNumberCrunching;

import java.util.Optional;
import java.util.Scanner;

public class SaferNumberCrunching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(getInt("Please enter a valid integer: ", input).orElseThrow());
        System.out.println(getDouble("Please enter a valid double value: ", input).orElseThrow());
        System.out.println(getBoolean("Please enter a valid boolean: ", input).orElseThrow());
    }

    public static Optional<Integer> getInt(String text, Scanner in) {
        while (true) {
            System.out.print(text);
            try {
                int integerInput = Integer.parseInt(in.nextLine());
                return Optional.of(integerInput);
            } catch (NumberFormatException e) {
                System.out.println("This is not an integer! Try again!");
            }
        }
    }

    public static Optional<Double> getDouble(String text, Scanner in) {
        while (true) {
            System.out.print(text);
            try {
                double doubleInput = Double.parseDouble(in.nextLine());
                return Optional.of(doubleInput);
            } catch (NumberFormatException e) {
                System.out.println("This is not a Double! Try again!");
            }
        }
    }

    public static Optional<Boolean> getBoolean(String text, Scanner in) {
        while (true) {
            System.out.print(text);
            String inputString = in.nextLine();
            if (inputString.equalsIgnoreCase("true")) return Optional.of(true);
            else if (inputString.equalsIgnoreCase("false")) return Optional.of(false);
            else System.out.println("This is not a boolean value! Try again!");
        }
    }

}