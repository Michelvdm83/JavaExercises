package PlayersGuide.SaferNumberCrunching;

import java.util.Optional;
import java.util.Scanner;

public class SaferNumberCrunching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(getInt("Please enter a valid integer: ", input).orElseThrow());
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
}