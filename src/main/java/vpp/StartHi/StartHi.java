package vpp.StartHi;

public class StartHi {
    public static void main(String[] args){
        System.out.println(startHi("hi there"));
        System.out.println(startHi("hi"));
        System.out.println(startHi("hello hi"));
    }

    private static boolean startHi(String original){
        return original.startsWith("hi");
    }
}
/*
Given a string, return true if the string starts with "hi" and false otherwise.

startHi("hi there") → true
startHi("hi") → true
startHi("hello hi") → false
 */