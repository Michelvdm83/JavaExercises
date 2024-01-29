package vpp.EndUp;

public class EndUp {
    public static void main(String[] args){
        System.out.println(endUp("Hello"));
        System.out.println(endUp("hi there"));
        System.out.println(endUp("hi"));
    }

    private static String endUp(String original){
        if(original.length() < 3) return original.toUpperCase();
        String endPart = original.substring(original.length()-3).toUpperCase();
        String firstPart = original.substring(0,original.length()-3);
        return firstPart.concat(endPart);
    }
}
/*
Given a string, return a new string where the last 3 chars are now in upper
case. If the string has less than 3 chars, uppercase whatever is there. Note
that str.toUpperCase() returns the uppercase version of a string.

endUp("Hello") → "HeLLO"
endUp("hi there") → "hi thERE"
endUp("hi") → "HI"
 */