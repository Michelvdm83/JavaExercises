package VPP.StringE;

public class StringE {
    public static void main(String[] args){
        System.out.println(stringE("Hello"));
        System.out.println(stringE("Heelle"));
        System.out.println(stringE("Heelele"));
    }

    private static boolean stringE(String original){
        int counter = 0;
        for(int i = 0; i < original.length(); i++){
            if(original.charAt(i) == 'e')counter++;
            /* if you want to check 'e' or 'E'
            if(original.subString(i, i+1).equalsToIgnoreCase("e"))counter++;
             */
        }
        return ((0 < counter) && (counter <= 3));
    }
}
/*
Return true if the given string contains between 1 and 3 'e' chars.

stringE("Hello") → true
stringE("Heelle") → true
stringE("Heelele") → false
 */