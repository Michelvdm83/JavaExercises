package vpp.Array667;

public class Array667 {
    public static void main(String[] args){
        System.out.println(array667(new int[]{6, 6, 2}));
        System.out.println(array667(new int[]{6, 6, 2, 6}));
        System.out.println(array667(new int[]{6, 7, 2, 6}));
    }

    private static int array667(int[] numbers){
    // could also use: private static int array667(int... numbers)
    // this would still accept an array of int, but also just multiple int
        int total = 0;
        for(int i = 0; i < numbers.length-1; i++){
            if(numbers[i] == 6 && (numbers[i+1] == 6 || numbers[i+1] == 7)) total++;
        }
        return total;
    }
}
/*
Given an array of ints, return the number of times that two 6's are next to
each other in the array. Also count instances where the second "6" is actually
a 7.

array667(new int[]{6, 6, 2}) → 1
array667(new int[]{6, 6, 2, 6}) → 1
array667(new int[]{6, 7, 2, 6}) → 1
 */