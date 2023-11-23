package VPP.Last2;

public class Last2 {
    public static void main(String[] args){
        System.out.println(last2("hixxhi"));
        System.out.println(last2("xaxxaxaxx"));
        System.out.println(last2("axxxaaxx"));
    }

    public static int last2(String original){
        if(original.length() <= 2) return 0;
        int count = 0;
        String endString = original.substring(original.length()-2);
        for(int i = 0; i < original.length()-2; i++){
            if(original.substring(i, i+2).equals(endString))count++;
        }
        return count;
    }
}
/*
Given a string, return the count of the number of times that a substring length
2 appears in the string and also as the last 2 chars of the string, so
"hixxxhi" yields 1 (we won't count the end substring).

last2("hixxhi") → 1
last2("xaxxaxaxx") → 1
last2("axxxaaxx") → 2
 */