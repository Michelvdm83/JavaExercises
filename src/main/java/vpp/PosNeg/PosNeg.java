package vpp.PosNeg;

public class PosNeg {
    public static void main(String[] args){
        System.out.println(posNeg(1, -1, false));
        System.out.println(posNeg(-1, 1, false));
        System.out.println(posNeg(-4, -5, true));
    }

    private static boolean posNeg(int first, int second, boolean negative){
        if(negative) return (first<0)&&(second<0);
        return !((first<0) == (second<0));
    }
}
/*
Given 2 int values, return true if one is negative and one is positive.
Except if the parameter "negative" is true, then return true only if both are
negative.

posNeg(1, -1, false) → true
posNeg(-1, 1, false) → true
posNeg(-4, -5, true) → true
 */