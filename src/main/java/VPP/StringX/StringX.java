package VPP.StringX;

public class StringX {
    public static void main(String[] args){
        System.out.println(stringX("xxHxix"));
        System.out.println(stringX("abxxxcd"));
        System.out.println(stringX("xabxxxcdx"));
    }

    private static String stringX(String original){
        String testString = original.substring(1, original.length()-1);
        String noXString = testString.replaceAll("x", "");
        String returnString = original.charAt(0) + noXString + original.charAt(original.length()-1);
        return returnString;
    }
}
/*
Given a string, return a version where all the "x" have been removed. Except an
"x" at the very start or end should not be removed.

stringX("xxHxix") → "xHix"
stringX("abxxxcd") → "abcd"
stringX("xabxxxcdx") → "xabcdx"
 */