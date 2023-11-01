package VPP.SwapTwoVariables;

public class SwapTwoVariables {
    public static void main(String[] args){
        int a = 15, b = 27;
        System.out.printf("Before swapping: a, b = %d, %d%n", a, b);
        int c = a;
        a = b;
        b = c;
        System.out.printf("After swapping: a, b = %d, %d%n", a, b);
    }
}
/*
Write a Java program to swap two variables.
Expected output:
Before swapping : a, b = 15, 27
After swapping : a, b = 27, 15
 */