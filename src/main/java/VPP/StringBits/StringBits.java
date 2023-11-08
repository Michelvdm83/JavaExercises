package VPP.StringBits;

public class StringBits {
    public static void main(String[] args){
        System.out.println(stringBits("Hello"));
        System.out.println(stringBits("Hi"));
        System.out.println(stringBits("Heeololeo"));
    }

    private static String stringBits(String original){
        String returnString = "";
        for(int i = 0; i < original.length(); i+=2){
            returnString += original.charAt(i);
        }
        return returnString;
    }
}
/*
Given a string, return a new string made of every other char starting with the
first, so "Hello" yields "Hlo".

stringBits("Hello") → "Hlo"
stringBits("Hi") → "H"
stringBits("Heeololeo") → "Hello"
*/