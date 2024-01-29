package vpp.FakeAmericanGradingWithLambdas;


import java.util.Map;

public class FakeAmericanGradingWithLambdas {
    public static void main(String[] args){
        int[] scoring = {40, 12, 90, 80, 50, 101};
        for(int i: scoring){
            scoreToGrade(i);
        }
    }

    private static void scoreToGrade(int score){
        if(score < 0 || score > 100) System.out.println("Not a legal score");
        Map<Integer, Character> grading =
                Map.of(80, 'A', 60, 'B', 50, 'C', 45, 'D', 25, 'E', 0, 'F');

    }
}
/*
A sadistic Java teacher wants to let his students practice if-elses. Not being
able to quickly find a case where
if-else-chains cannot be improved by replacing them with switch expressions, he
turns to the grading scheme used
in many countries, where scores (in percentage points) are converted to letters.

Of course, using the REAL grading system of a country like the US would be way
too easy, as one could use the regularity
in the intervals (https://en.wikipedia.org/wiki/Academic_grading_in_the_United_
States) to avoid if-else loops and use
simple arithmetical transformations instead. So the teacher cooks up the
following scheme:
-scoring MORE than 80 percentage points results in an A
-scoring MORE than 60 percentage points (but less than 81) results in a B
-scoring MORE than 50 percentage points (but less than 61) results in a C
-scoring MORE than 45 percentage points (but less than 51) results in a D
-scoring MORE than 25 percentage points (but less than 46) results in an E
-anything lower results in an F

Looping over an array of percentages, your program should produce an output
like the below.

40 results in a grade of E
12 results in a grade of F
90 results in a grade of A
80 results in a grade of B
50 results in a grade of D

Can you outsmart the teacher and think of a way to solve this succinctly,
WITHOUT using if-else chains?
It would be nice if you could also check for the correctness of the input (in 0.
.100)
 */

/*
package exercises;

import java.util.Collections;
import java.util.Map;

public class FakeAmericanGradingWithLambdas {
    public static void main(String[] args) {
        int[] scores = {40, 12, 90, 80, 50};
        for (int score : scores) {
            System.out.println(score + " results in a grade of " + gradeFromScore(score));
        }
    }

    static char gradeFromScore(int score) {
        if (score < 0 || score > 100)
            throw new IllegalArgumentException("gradeFromScore() error: " + score + " is not in the range 0..100");
        Map<Integer, Character> scoringTable = Map.of(80, 'A', 60, 'B', 50, 'C', 45, 'D', 25, 'E');
        return scoringTable.keySet().stream().sorted(Collections.reverseOrder()).filter(limit -> limit < score).findFirst().map(scoringTable::get).orElse('F');
    }
}
 */