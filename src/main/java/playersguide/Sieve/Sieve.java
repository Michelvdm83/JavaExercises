package playersguide.Sieve;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class Sieve {
    Predicate<Integer> predicate;

    public static void main(String[] args) {
        Sieve sieve;
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Do you want to test numbers for:
                1. being even
                2. being positive
                3. being a multiple of 10
                """);
        System.out.print("Your choice: ");
        while (true) {
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> sieve = new Sieve(Sieve::evenTest);
                    case 2 -> sieve = new Sieve(i -> i > 0);
                    case 3 -> sieve = new Sieve(i -> i % 10 == 0);
                    default -> {
                        System.out.println("Only 1, 2 and 3 are an option!");
                        continue;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please choose with a number(1,2 or 3)");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Please enter a number to check: ");
            try {
                int number = input.nextInt();
                System.out.println(sieve.isGood(number));
                if (number == 99) break;
            } catch (InputMismatchException e) {
                System.out.println("Not a number!");
                input.nextLine();
            }
        }
    }

    public Sieve(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    public boolean isGood(int number) {
        return predicate.test(number);
    }

    public static boolean evenTest(int number) {
        return number % 2 == 0;
    }
}
//using inheritance and polymorphism you'd make an abstract class (or interface) Sieve
//and then make seperate classes like IsEvenSieve and IsPositiveSieve
//if you want to limit the possible Sieve, inheritance is better, the method above gives more flexability