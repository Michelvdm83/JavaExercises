package VPP.StringSplosion;

public class StringSplosion {
    public static void main(String[] args){
        System.out.println(stringSplosion("Code"));
        System.out.println(stringSplosion("abc"));
        System.out.println(stringSplosion("ab"));
    }

    private static String stringSplosion(String original){
        String returnString = "";
        for(int i=0; i < original.length(); i++){
            returnString += original.substring(0,i+1);
        }
        return returnString;
    }
}
/*
Given a non-empty string like "Code" return a string like "CCoCodCode".

stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"
 */