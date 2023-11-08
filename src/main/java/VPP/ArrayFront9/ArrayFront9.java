package VPP.ArrayFront9;

public class ArrayFront9 {
    public static void main(String[] args){
        System.out.println(arrayFront9(new int[]{1, 2, 9, 3, 4}));
        System.out.println(arrayFront9(new int[]{1, 2, 3, 4, 9}));
        System.out.println(arrayFront9(new int[]{1, 2, 3, 4, 5}));
    }

    private static boolean arrayFront9(int[] series){
        for(int i = 0; i < 4; i++){
            if(i == series.length)break;
            if(series[i] == 9)return true;
        }
        return false;
    }
}
/*
Given an array of ints, return true if one of the first 4 elements in the array
is a 9. The array length may be less than 4.

arrayFront9(new int[]{1, 2, 9, 3, 4}) → true
arrayFront9(new int[]{1, 2, 3, 4, 9}) → false
arrayFront9(new int[]{1, 2, 3, 4, 5}) → false
 */