package vpp.CountXX;

public class CountXX {
    public static void main(String[] args){
        System.out.println(countXX("abcxx"));
        System.out.println(countXX("xxx"));
        System.out.println(countXX("xxxx"));
    }

    private static int countXX(String sentence){
        int count = 0;
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.startsWith("xx", i)) count++;
        }
        return count;
    }
}
/*
Count the number of "xx" in the given string. We'll say that overlapping is
allowed, so "xxx" contains 2 "xx".

countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3
 */