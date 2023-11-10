package VPP.EvenSumOfDigits;

public class EvenSumOfDigits {
    public static void main(String[] args){
        for(int i = 100; i < 150; i++){
            if((i%10 + i/10 + i/100)%2 == 0){
                System.out.println(i);
            }
        }
    }
}
/*
Print every integer between 100 and 150 (exclusive, so start at 100 and end at
149, [100, 150> )
of which the sum of digits is an even number.

Sample output
101
103
105
107
109
110
// ... etcetera
 */