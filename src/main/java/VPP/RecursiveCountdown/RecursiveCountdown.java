package VPP.RecursiveCountdown;

public class RecursiveCountdown {
    public static void main(String[] args){
        System.out.println(recursiveCountdown(8));
    }

    private static String recursiveCountdown(int start){
        if (start > 0){
            return start + "\n" + recursiveCountdown(start-1);
        }
        else return "" + start;

        // alternative:
        // if (start == 0) return "" + start;
        // return start + "\n" + recursiveCountdown(start-1);
    }
}
/*
Print the numbers from 8 to 0, using recursion.

 */