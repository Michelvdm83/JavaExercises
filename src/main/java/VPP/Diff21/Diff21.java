package VPP.Diff21;

public class Diff21 {
    public static void main(String[] args){
        System.out.println(diff21(19));
        System.out.println(diff21(10));
        System.out.println(diff21(21));
    }

    private static int diff21(int number){
        if(number > 21) return (number-21)*2;
        return 21-number;
    }
}
/*
Create a method int diff21(int n)
Given an int n, return the absolute difference between n and 21, except return
double the absolute difference if n is over 21.

diff21(19) → 2
diff21(10) → 11
diff21(21) → 0
 */