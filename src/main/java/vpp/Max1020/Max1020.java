package vpp.Max1020;

public class Max1020 {
    public static void main(String[] args){
        System.out.println(max1020(11, 19));
        System.out.println(max1020(19, 11));
        System.out.println(max1020(11, 9));
    }

    private static int max1020(int first, int second){
        //first version
        /*
        int check;
        if(Math.max(first, second) > 20){
            check = Math.min(first, second);
        }
        else if(Math.min(first, second) < 10){
            check = Math.max(first, second);
        }
        else check = Math.max(first, second);

        if(check > 20 || check < 10) return 0;
        else return check;
        */

        //shorter version
        int check = Math.max(first, second);//check is the largest number of the 2
        if(10 < check && check < 20) return check;//if the largest of the 2 is within range return it
        //if the above is true, the code below won't be reached
        check = Math.min(first, second);// set check as the lowest of the 2 numbers
        if(10 < check && check < 20) return check;// if the largest number wasn't within range, check the lowest
        return 0;// if both are out of range, return 0
    }
}
/*
Given 2 positive int values, return the larger value that is in the range 10..
20 inclusive, or return 0 if neither is in that range.

max1020(11, 19) → 19
max1020(19, 11) → 19
max1020(11, 9) → 11
 */