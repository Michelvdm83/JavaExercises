package boek.murachtestscoreapp;

import java.text.NumberFormat;
import java.util.Scanner;

public class MurachTestScoreApp {

    public static void main(String[] args) {
        // display operational messages
        System.out.println("Enter test scores that range from 0 to 100.");
        System.out.println("To end the program, enter 999.\n");
        //System.out.println();  // print a blank line

        // initialize variables and create a Scanner object
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        int minimumScore = 100;
        int maximumScore = 0;
        Scanner sc = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(1);

        // get a series of test scores from the user
        while (testScore != 999) {
            // get the input from the user
            System.out.print("Enter score: ");
            String input = sc.nextLine();
            testScore = Integer.parseInt(input);

            // accumulate score count and score total
            if (testScore <= 100) {
                if (minimumScore > testScore) minimumScore = testScore;
                if (maximumScore < testScore) maximumScore = testScore;
                //scoreCount = scoreCount + 1;
                scoreCount++;
                scoreTotal += testScore;
                //scoreTotal = scoreTotal + testScore;
            } else if (testScore != 999) {
                System.out.println("Invalid entry; not counted");
            }
        }

        // display the score count, score total, and average score
        double averageScore = 0.0;
        if (scoreCount > 0) {
            averageScore = (double) scoreTotal / scoreCount;
        }
        String message = "\n"
                + "Score count:   " + scoreCount + "\n"
                + "Score total:   " + scoreTotal + "\n"
                + "Average score: " + formatter.format(averageScore) + "\n"
                + "Minimum score: " + minimumScore + "\n"
                + "Maximum score: " + maximumScore + "\n";
        System.out.println(message);
    }
}