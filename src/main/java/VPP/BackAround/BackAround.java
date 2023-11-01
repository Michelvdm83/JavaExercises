package VPP.BackAround;

public class BackAround {
    public static void main(String[] args){
        System.out.println(backAround("cat"));
        System.out.println(backAround("Hello"));
        System.out.println(backAround("a"));
    }

    private static String backAround(String original){
        char lastChar = original.charAt(original.length()-1);
        return lastChar + original + lastChar;
    }
}

/*
Given a string, take the last char and return a new string with the last char
added at the front and back, so "cat" yields "tcatt". The original string will
be length 1 or more.

backAround("cat") → "tcatt"
backAround("Hello") → "oHelloo"
backAround("a") → "aaa"

 */