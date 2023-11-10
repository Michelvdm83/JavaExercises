package VPP.In3050;

public class In3050 {
    public static void main(String[] args){
        System.out.println(in3050(30, 31));
        System.out.println(in3050(30, 41));
        System.out.println(in3050(40, 50));
    }

    private static boolean in3050(int first, int second){
        if(first >= 30 && second >= 30){
            if(first <= 40 && second <= 40){
                return true;
            }
            if(first <= 50 && second <= 50){
                if(first >= 40 && second >= 40){
                    return true;
                }
            }
        }
        return false;
    }
}
/*
Given 2 int values, return true if they are both in the range 30..40 inclusive,
or they are both in the range 40..50 inclusive.

in3050(30, 31) → true
in3050(30, 41) → false
in3050(40, 50) → true
 */