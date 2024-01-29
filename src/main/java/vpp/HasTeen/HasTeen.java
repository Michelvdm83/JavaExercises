package vpp.HasTeen;

public class HasTeen {
    public static void main(String[] args){
        System.out.println(hasTeen(13, 20, 10));
        System.out.println(hasTeen(20, 19, 10));
        System.out.println(hasTeen(20, 30, 7));
    }

    private static boolean hasTeen(int age1, int age2, int age3){
        if (age1 >= 13 && age1 <= 19) return true;
        if (age2 >= 13 && age2 <= 19) return true;
        if (age3 >= 13 && age3 <= 19) return true;
        return false;
    }
}
/*
We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given
3 int values, return true if 1 or more of them are teen.

hasTeen(13, 20, 10) → true
hasTeen(20, 19, 10) → true
hasTeen(20, 30, 7) → false

 */