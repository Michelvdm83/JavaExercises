package vpp.NoTriples;

public class NoTriples {
    public static void main(String[] args){
        System.out.println(noTriples(1, 1, 2, 2, 1));
        System.out.println(noTriples(1, 1, 2, 2, 2, 1));
        System.out.println(noTriples(1, 1, 1, 2, 2, 2, 1));
    }

    private static boolean noTriples(int ... numbers){
        //if(numbers.length < 3)return true;
        for(int i = 0; i < numbers.length-2; i++){
            if(numbers[i] == numbers[i+1] && numbers[i] == numbers[i+2]) return false;
        }
        return true;
    }
}
/*
Given an array of ints, we'll say that a triple is a value appearing 3 times in
a row in the array. Return true if the array does not contain any triples.
Note: you can use a varargs argument to pass a sequence of integers (like 1, 2,
5) as an array
boolean noTriples(int... numbers)

noTriples(1, 1, 2, 2, 1) → true
noTriples(1, 1, 2, 2, 2, 1) → false
noTriples(1, 1, 1, 2, 2, 2, 1) → false
*/