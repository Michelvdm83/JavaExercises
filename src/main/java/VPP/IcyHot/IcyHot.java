package VPP.IcyHot;

public class IcyHot {
    public static void main(String[] args){
        System.out.println(icyHot(120,-1));
        System.out.println(icyHot(-1,120));
        System.out.println(icyHot(2,120));
    }

    private static boolean icyHot(int first, int second){
        return (first < 0 && second > 100) || (first > 100 && second < 0);
    }
}
/*
Given two temperatures, return true if one is less than 0 and the other is
greater than 100.

icyHot(120, -1) → true
icyHot(-1, 120) → true
icyHot(2, 120) → false
 */