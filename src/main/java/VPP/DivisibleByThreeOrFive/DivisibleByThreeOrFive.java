package VPP.DivisibleByThreeOrFive;

import java.util.ArrayList;

public class DivisibleByThreeOrFive {
    public static void main(String[] args){
        ArrayList<Integer> divisible3 = new ArrayList<>();
        ArrayList<Integer> divisible5 = new ArrayList<>();
        //lijst aangepast naar String, zoals in voorbeeld van VPP
        ArrayList<String> divisible3And5 = new ArrayList<>();
        for(int i = 1; i < 100; i++){
            if(i%3 == 0)divisible3.add(i);
            if(i%5 == 0)divisible5.add(i);
            if(i%3 == 0 && i%5 == 0)divisible3And5.add("" + i);
        }
        System.out.println("Divisible by 3:");
        divisible3.forEach(i -> System.out.print(i + ", "));
        System.out.println("\n\nDivisible by 5:");
        divisible5.forEach(i -> System.out.print(i + ", "));
        System.out.println("\n\nDivisible by 3 & 5:");
//        divisible3And5.forEach(i -> System.out.print(i + ", "));
        //test met het voorbeeld van VPP
        System.out.println(String.join(", ", divisible3And5));
    }
}
/*
Write a Java program to print numbers between 1 to 100 which are divisible by 3,
5 and by both.
Sample Output:

Divisible by 3:
3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57
, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99,

Divisible by 5:
5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90,
95,

Divisible by 3 & 5:
15, 30, 45, 60, 75, 90,
 */