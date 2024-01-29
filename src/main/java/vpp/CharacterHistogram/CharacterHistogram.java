package vpp.CharacterHistogram;

import java.util.*;

public class CharacterHistogram {
    private static final Map<Character, Integer> count = new HashMap<>();
    //by using LinkedHashMap instead of HashMap the Map would keep its order of entry and
    //the List 'order' below wouldn't be necessary
    private static final List<Character> order = new ArrayList<>();
    public static void main(String[] args){
        fillCount();
        //count.entrySet().forEach(System.out::println);

        Scanner input = new Scanner(System.in);
        System.out.print("Please give a sentence to analyze: ");
        String sentence = input.nextLine().toLowerCase();
        countCharacters(sentence);
        //count.entrySet().forEach(System.out::println);
        int highest = 0;
        for(int i: count.values()){
            if(i > highest){
                highest = i;
            }
        }
        //order.forEach(System.out::println);
        printHistogram(highest);
    }

    private static void fillCount(){
        for(int i = 97; i <= 122; i++){
            count.put((char) i, 0);
            order.add((char)i);
        }
        for(int i = 0; i < 10; i++){
            count.put(Character.forDigit(i, 10), 0);
            order.add(Character.forDigit(i, 10));
        }
    }

    private static void countCharacters(String original){
        for(char c: original.toCharArray()){
            if(count.containsKey(c)){
                count.replace(c, count.get(c)+1);
                //System.out.println(c);
            }
        }
    }

    private static void printHistogram(int counter){
        for(;counter > 0; counter--){
            for(char c: order){
                if(count.get(c) >= counter){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                //shorter version of above if/else statement
                //System.out.print(count.get(c) >= counter? '*':' ');
            }
            System.out.println();
        }
        order.forEach(System.out::print);
    }
}
/*
Make a program that creates a histogram of characters (letters and digits) in a
sentence given by the user. Uppercase
letters are counted as their lowercase variants (so 1 'A' and 2 'a' lead to 3
'a's)

Example run:
Please give a sentence to analyze: I'll give you 121 golden dubloons!
           *  *
           *  *
   ** * *  * **     *      *
 * ** * *  * **   * **  *  **
abcdefghijklmnopqrstuvwxyz0123456789
 */