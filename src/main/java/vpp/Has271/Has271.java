package vpp.Has271;

public class Has271 {
    public static void main(String[] args){
        System.out.println(has271(new int[]{1, 2, 7, 1}));
        System.out.println(has271(new int[]{1, 2, 8, 1}));
        System.out.println(has271(new int[]{2, 7, 1}));
    }

    private static boolean has271(int[] list){
        for(int i = 0; i < list.length - 2; i++){
            if(list[i]+5 == list[i+1] && Math.abs(list[i+2] - (list[i]-1)) <= 2) return true;
        }
        return false;
    }
}
/*
Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value,
followed by the value plus 5, followed by the value minus 1. Additionally the
271 counts even if the "1" differs by 2 or less from the correct value.

has271(new int[]{1, 2, 7, 1}) → true
has271(new int[]{1, 2, 8, 1}) → false
has271(new int[]{2, 7, 1]}) → true
 */