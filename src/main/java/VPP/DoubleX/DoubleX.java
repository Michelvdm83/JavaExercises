package VPP.DoubleX;

public class DoubleX {
    public static void main(String[] args){
        System.out.println(doubleX("axxbb"));
        System.out.println(doubleX("axaxax"));
        System.out.println(doubleX("xxxx"));
    }

    private static boolean doubleX(String text){
        return text.startsWith("xx",text.indexOf('x'));
    }
}
/*
Given a string, return true if the first instance of "x" in the string is
immediately followed by another "x".

doubleX("axxbb") → true
doubleX("axaxax") → false
doubleX("xxxxx") → true
 */