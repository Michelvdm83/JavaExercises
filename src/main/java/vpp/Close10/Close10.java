package vpp.Close10;

public class Close10 {
    public static void main(String[] args){
        System.out.println(close10(8, 13));
        System.out.println(close10(13, 8));
        System.out.println(close10(13, 7));
    }

    private static int close10(int first, int second){
        //check the distance to 10 for first and second number
        int firstCheck = Math.abs(first-10);
        int secondCheck = Math.abs(second-10);
        //check which distance is shorter and return the corresponding number
        if(firstCheck < secondCheck)return first;
        if(secondCheck < firstCheck)return second;
        //if the above 2 aren't true, they are equal, so return 0
        return 0;
    }
}
/*
Given 2 int values, return whichever value is nearest to the value 10, or
return 0 in the event of a tie. Note that Math.abs(n) returns the absolute
value of a number.

close10(8, 13) → 8
close10(13, 8) → 8
close10(13, 7) → 0
 */