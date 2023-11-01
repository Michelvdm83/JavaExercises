package VPP.NearHundred;

public class NearHundred {
    public static void main(String[] args){
        System.out.println(nearHundred(93));
        System.out.println(nearHundred(90));
        System.out.println(nearHundred(89));
    }
    private static boolean nearHundred(int number){
        return Math.abs(number - 100) <= 10 || Math.abs(number - 200) <= 10;
    }
}
/*
Create a method boolean nearHundred(int n)
Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(
num) computes the absolute value of a number.

nearHundred(93) → true
nearHundred(90) → true
nearHundred(89) → false

 */