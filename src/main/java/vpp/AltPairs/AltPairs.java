package vpp.AltPairs;

public class AltPairs {
    public static void main(String[] args){
        altPairs("kitten");
        altPairs("Chocolate");
        altPairs("CodingHorror");
    }

    private static void altPairs(String original){
        String result = "";
        //fill the resul string with the characters at 0 and 1 of a repeating sequence of 0,1,2,3
        for(int i = 0; i < original.length(); i++){
            if(i%4 <= 1) result += original.charAt(i);
        }
        System.out.println(result);
    }
}
/*
Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ...
so "kittens" yields "kien".

altPairs("kitten") → "kien"
altPairs("Chocolate") → "Chole"
altPairs("CodingHorror") → "Congrr"
 */