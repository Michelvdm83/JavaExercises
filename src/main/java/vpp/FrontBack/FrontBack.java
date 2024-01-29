package vpp.FrontBack;

public class FrontBack {
    public static void main(String[] args){
        System.out.println(frontBack("code"));
        System.out.println(frontBack("a"));
        System.out.println(frontBack("ab"));
    }

    private static String frontBack(String original){
        if(original.length() <= 1)return original;
        String firstChar = original.substring(0,1);
        String lastChar = original.substring(original.length()-1);
        return lastChar + original.substring(1, original.length()-1)+ firstChar;
    }
}
/*
Given a string, return a new string where the first and last chars have been
exchanged.

frontBack("code") → "eodc"
frontBack("a") → "a"
frontBack("ab") → "ba"
 */