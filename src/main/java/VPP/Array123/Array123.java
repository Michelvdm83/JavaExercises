package VPP.Array123;

public class Array123 {
    public static void main(String[] args){
        System.out.println(array123(1, 1, 2, 3, 1));
        System.out.println(array123(1, 1, 2, 4, 1));
        System.out.println(array123(1, 1, 2, 1, 2, 3));
    }

    private static boolean array123(int ... allNumbers){
        for(int last = 2;last < allNumbers.length;last++){
            if(allNumbers[last-2] == 1 && allNumbers[last-1] == 2 && allNumbers[last] == 3) return true;
        }
        return false;
    }
}
/*
Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears
in the array somewhere.
You can use an array123(int... numbers) varargs method to automatically convert
a sequence of ints to an array

array123(1, 1, 2, 3, 1) → true
array123(1, 1, 2, 4, 1) → false
array123(1, 1, 2, 1, 2, 3) → true
 */