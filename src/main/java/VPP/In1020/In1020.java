package VPP.In1020;

public class In1020 {
    public static void main(String[] args){
        System.out.println(in1020(12,99));
        System.out.println(in1020(21,12));
        System.out.println(in1020(8,99));
    }

    private static boolean in1020(int first, int second){
        if(first >= 10 && first <= 20){
            return true;
        }
        else if(second >= 10 && second <= 20){
            return true;
        }
        else return false;
    }
}
/*
Given 2 int values, return true if either of them is in the range 10..20
inclusive.

in1020(12, 99) → true
in1020(21, 12) → true
in1020(8, 99) → false
 */