package VPP.ParrotTrouble;

public class ParrotTrouble {
    public static void main(String[] args){
        System.out.println(parrotTrouble(true, 6));
        System.out.println(parrotTrouble(true, 7));
        System.out.println(parrotTrouble(false,6));
    }

    private static boolean parrotTrouble(boolean parrotIsTalking, int hour){
        return (hour < 7 || hour > 20) && parrotIsTalking;
    }
}
/*
We have a loud talking parrot. The "hour" parameter is the current hour time in
the range 0..23. We are in trouble if the parrot is talking and the hour is
before 7 or after 20. Return true if we are in trouble.

parrotTrouble(true, 6) → true
parrotTrouble(true, 7) → false
parrotTrouble(false, 6) → false

 */