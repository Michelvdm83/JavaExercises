package vpp.Makes10;

public class Makes10 {
    public static void main(String[] args){
        System.out.println(makes10(9,10));
        System.out.println(makes10(9,9));
        System.out.println(makes10(1,9));
    }

    private static boolean makes10(int first, int second){
        return (first+second == 10 || first == 10 || second == 10);
    }
}

/*
Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.

makes10(9, 10) → true
makes10(9, 9) → false
makes10(1, 9) → true
 */