package vpp.StringMatch;

public class StringMatch {
    public static void main(String[] args){
        System.out.println(stringMatch("xxcaazz", "xxbaaz"));
        System.out.println(stringMatch("abc", "abc"));
        System.out.println(stringMatch("abc", "axc"));
    }

    private static int stringMatch(String first, String second){
        int count = 0;
        int shortest = Math.min(first.length(), second.length());
        for(int i = 0; i < shortest - 1; i++){
            if(first.substring(i,i+2).equals(second.substring(i,i+2))){
//            if(first.charAt(i) == second.charAt(i) && first.charAt(i+1) == second.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
}
/*
Given 2 strings, a and b, return the number of the positions where they contain
the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx",
"aa", and "az" substrings appear in the same place in both strings.

stringMatch("xxcaazz", "xxbaaz") → 3
stringMatch("abc", "abc") → 2
stringMatch("abc", "axc") → 0
 */