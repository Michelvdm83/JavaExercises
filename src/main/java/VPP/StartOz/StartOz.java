package VPP.StartOz;

public class StartOz {
    public static void main(String[] args){
        System.out.println(startOz("ozymandias"));
        System.out.println(startOz("bzoo"));
        System.out.println(startOz("oxx"));
    }

    private static String startOz(String original){
        String returnString = "";
        if(original.length() > 1){//if the length of the string has at least 1 character, check the first character
            if(original.charAt(0) == 'o') returnString += original.charAt(0);
        }
        if(original.length() > 2){//if the length of the string has at least 2 characters, check the second character
            if(original.charAt(1) == 'z') returnString += original.charAt(1);
        }
        return returnString;
    }
}
/*
Given a string, return a string made of the first 2 chars (if present), however
include first char only if it is 'o' and include the second only if it is 'z',
so "ozymandias" yields "oz".

startOz("ozymandias") → "oz"
startOz("bzoo") → "z"
startOz("oxx") → "o"
 */