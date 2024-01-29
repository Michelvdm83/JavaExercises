package vpp.Front22;

public class Front22 {
    public static void main(String[] args){
        System.out.println(front22("kitten"));
        System.out.println(front22("Ha"));
        System.out.println(front22("abc"));
    }

    private static String front22(String original){
        int length = Math.min(2, original.length());
        String first2 = original.substring(0,length);
        return first2.concat(original).concat(first2);
    }
}
/*
Given a string, take the first 2 chars and return the string with the 2 chars
added at both the front and back, so "kitten" yields"kikittenki". If the string
length is less than 2, use whatever chars are there.

front22("kitten") → "kikittenki"
front22("Ha") → "HaHaHa"
front22("abc") → "ababcab"
 */