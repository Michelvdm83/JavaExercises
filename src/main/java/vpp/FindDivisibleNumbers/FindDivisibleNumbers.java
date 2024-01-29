package vpp.FindDivisibleNumbers;

public class FindDivisibleNumbers {
    public static void main(String[] args){
        int x = 5, y = 20, p = 3;
        int divisibleNumbers = 0;
        for(int i = x; i<=y;i++){
            if(i%p == 0)divisibleNumbers++;
        }
        System.out.println(divisibleNumbers);
    }
}
/*
Write a Java program to find the number of values in a given range divisible by
a given value.
For example x = 5, y=20 and p =3, find the number of integers within the range
x..y and that are divisible by p i.e. { i :x ≤ i ≤ y, i mod p = 0 }
Sample Output:

5
// because 6, 9, 12, 15 and 18 form 5 values!
 */