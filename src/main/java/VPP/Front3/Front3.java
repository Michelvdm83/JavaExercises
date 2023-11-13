package VPP.Front3;

public class Front3 {
    public static void main(String[] args){
        System.out.println(front3("Java"));
        System.out.println(front3("Chocolate"));
        System.out.println(front3("abc"));
    }

    private static String front3(String original){
        int front = Math.min(original.length(), 3);
        return original.substring(0, front).repeat(3);
    }
}
/*
Given a string, we'll say that the front is the first 3 chars of the string. If
the string length is less than 3, the front is whatever is there. Return a new
string which is 3 copies of the front.

front3("Java") → "JavJavJav"
front3("Chocolate") → "ChoChoCho"
front3("abc") → "abcabcabc"
 */