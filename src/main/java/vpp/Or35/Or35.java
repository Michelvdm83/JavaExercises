package vpp.Or35;

public class Or35 {
    public static void main(String[] args){
        System.out.println(or35(3));
        System.out.println(or35(10));
        System.out.println(or35(8));
    }

    private static boolean or35(int number){
        return number%3 == 0 || number%5 == 0;
    }
}

/*
Return true if the given non-negative number is a multiple of 3 or a multiple
of 5. Use the % "mod" operator -- see Introduction to Mod

or35(3) → true
or35(10) → true
or35(8) → false

 */