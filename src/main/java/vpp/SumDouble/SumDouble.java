package vpp.SumDouble;

public class SumDouble {
    public static void main(String[] args){
        System.out.println(sumDouble(1, 2));
        System.out.println(sumDouble(3,2));
        System.out.println(sumDouble(2, 2));
    }

    private static int sumDouble(int first, int second){
        int result = first+second;
        if(first == second)result = result*2;
        return result;
    }
}
/*
Given two int values, return their sum. Unless the two values are the same,
then return double their sum.

sumDouble(1, 2) → 3
sumDouble(3, 2) → 5
sumDouble(2, 2) → 8
 */