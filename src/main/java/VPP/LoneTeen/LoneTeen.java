package VPP.LoneTeen;

import java.time.temporal.ValueRange;

public class LoneTeen {
    public static void main(String[] args){
        System.out.println(loneTeen(13,99));
        System.out.println(loneTeen(21,19));
        System.out.println(loneTeen(13,13));
    }

    private static boolean loneTeen(int age1, int age2){
        /*if((13 <= age1) && (age1 <= 19)){
            if((13 <= age2) && (age2 <= 19)) return false;
            return true;
        }
        return (13 <= age2) && (age2 <= 19);
        */
        ValueRange teenCheck = ValueRange.of(13,19);
        return (teenCheck.isValidIntValue(age1) != teenCheck.isValidIntValue(age2));
        //return (teenCheck.isValidIntValue(age1) && !teenCheck.isValidIntValue(age2)) || (teenCheck.isValidIntValue(age2) && !teenCheck.isValidIntValue(age1));
    }
}
/*
We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given
2 int values, return true if one or the other is teen, but not both.

loneTeen(13, 99) → true
loneTeen(21, 19) → true
loneTeen(13, 13) → false

 */