package vpp.StringTimes;

public class StringTimes {
    public static void main(String[] args){
        System.out.println(stringTimes("Hi", 2));
        System.out.println(stringTimes("Hi", 3));
        System.out.println(stringTimes("Hi", 1));
    }

    private static String stringTimes(String sentence, int times){
        String newSentence = "";
        for(int i = 1; i <= times; i++){
            newSentence += sentence;
        }
        return newSentence;
        //simple solution:
        //return sentence.repeat(times);
    }
}
/*
Given a string and a non-negative int n, return a larger string that is n
copies of the original string.

stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"
 */