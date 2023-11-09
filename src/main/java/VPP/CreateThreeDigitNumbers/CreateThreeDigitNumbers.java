package VPP.CreateThreeDigitNumbers;

public class CreateThreeDigitNumbers {
    public static void main(String[] args){
        int count = 0;
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                if(i != j) {
                    for (int k = 1; k <= 4; k++) {
                        if (k != j && k != i){
                            System.out.printf("%d%d%d\n", i, j, k);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("Total number of three-digit-numbers is " + count);
    }
}
/*
Write a Java program to create and display unique (a certain digit cannot occur
more than once in a number)
three-digit numbers using 1, 2, 3, 4. Also count how many three-digit numbers
are there.
Expected Output

123
124
...

431
432
Total number of three-digit-numbers is 24
*/