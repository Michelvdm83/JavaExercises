package VPP.StringYak;

public class StringYak {
    public static void main(String[] args){
        System.out.println(stringYak("yakpak"));
        System.out.println(stringYak("pakyak"));
        System.out.println(stringYak("yak123ya"));
    }

    private static String stringYak(String original){
        if(original.length() < 3) return original;
        String returnString = "";
        for(int i = 0; i < original.length(); i++){
            if(original.length() > i+2) {
                if (original.charAt(i) == 'y' && original.charAt(i + 2) == 'k') {
                    i += 2;
                    continue;
                }
            }
            returnString += original.charAt(i);
        }
        return returnString;
    }
}
/*
Suppose the string "yak" is unlucky. Given a string, return a version where all
the "yak" are removed, but the "a" can be any char. The "yak" strings will not
overlap.

stringYak("yakpak") → "pak"
stringYak("pakyak") → "pak"
stringYak("yak123ya") → "123ya"
 */