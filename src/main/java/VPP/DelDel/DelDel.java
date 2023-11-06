package VPP.DelDel;

public class DelDel {
    public static void main(String[] args){
        System.out.println(delDel("adelbc"));
        System.out.println(delDel("adelHello"));
        System.out.println(delDel("adedbc"));
    }

    private static String delDel(String original){
        if(original.startsWith("del", 1)){
            original = original.charAt(0) + original.substring(4);
        }
        return original;
    }
}
/*
Given a string, if the string "del" appears starting at index 1, return a
string where that "del" has been deleted. Otherwise, return the string
unchanged.

delDel("adelbc") → "abc"
delDel("adelHello") → "aHello"
delDel("adedbc") → "adedbc"
 */