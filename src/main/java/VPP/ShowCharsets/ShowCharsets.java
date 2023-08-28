package VPP.ShowCharsets;

import java.nio.charset.Charset;

public class ShowCharsets {
    public static void main(String[] args){
        for(String i : Charset.availableCharsets().keySet()){
            System.out.println(i);
        }
    }
}
