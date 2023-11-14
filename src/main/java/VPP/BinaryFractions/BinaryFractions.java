package VPP.BinaryFractions;

public class BinaryFractions {
    public static void main(String[] args){
        for(int i = 1; i < 100; i++){
            int repeat = 0;
            double number = i/100.0;
            String doubleAsString = "0.";
            //0.6875 * 2 = 1.375, 1.375 rounded down is 1, 1.375 - 1 = 0.375, so
            //currentAnswer is "0.1"
            while(number > 0){
                number *= 2;
                doubleAsString += (int)number;
                number -= (int)number;
                repeat++;
                if(repeat == 20)break;
            }
            System.out.println((double)i/100 + " in binary is: " + doubleAsString);
            //While calculating binary from a decimal, each step to the left doubles the value
            //like: binary 001 = 1 and 010 = 2 and 100 = 4
            //So the exact opposite of the state is, of course also true
            //each step to the right halves the value
            //like: binary 100 = 4 and 010 = 2 and 001 = 1
            //continuing this will result in (binary) 0.1 = (decimal) 0.5
            //and (binary) 0.01 = (decimal) 0.25
            //this is why decimal 0.25, 0.50 and 0.75 are way shorter than the rest
        }
    }
}
/*
You may understand binary numbers by now: just like a decimal (base-10) number
works like
356 = 3 * 10 ^ 2 + 5 * 10 ^ 1 + 6 * 10 ^ 0 = 3 * 100 + 5 * 10 + 6 = 356
a binary number like 11001 works like
1 * 2 ^ 4 + 1 * 2 ^ 3 + 0 * 2 ^ 2 + 0 * 2 ^ 1 + 1 * 2 ^ 0 = 1 * 16 + 1 * 8 + 0
* 4 + 0 * 2 + 1 = 16 + 8 + 0 + 0 + 1 = 25

But few people have thought about not-whole numbers. It is quite a logical
extension, though...

decimal: 12.35 = 1 * 10 ^ 1 + 2 * 10 ^ 0 + 3 * 10 ^ -1 + 5 * 10 ^ -2 = 1 * 10 +
2 * 1 + 3 * 0.1 + 5 * 0.01 = 10 + 2 + 0.3 + 0.05 = 12.35
binary: 10.1011 = 1 * 2 ^ 1 + 0 * 2 ^ 0 + 1 * 2 ^ -1 + 0 * 2 ^ -2 + 1 * 2 ^ 3 +
1 * 2 ^ 4
= 1 * 2 + 0 * 1 + 1 * 0.5 + 0 * 0.25 + 1 * 0.125 + 1 * 0.0625 = 2 + 0 + 0.5 + 0
+ 0.125 + 0.0625 = 2.6875

Converting a normal number to a binary is not that hard:
25 % 2 = 1, 25 / 2 = 12, so currentAnswer = "1" (last digit), now calculate 12
binary
12 % 2 = 0, 12 / 2 = 6, so currentAnswer = "01" (last digits), now calculate 6
binary
6 % 2 = 0, 6 / 2 = 3, so currentAnswer = "001" (last digits), now calculate 3
binary
3 % 2 = 1, 3 / 2 = 1, so currentAnswer = "1001" (last digits), now calculate 1
binary
1 % 2 = 1, 1 / 2 = 0, so currentAnswer = "11001" (last digits), and since 0 is
left, we're done!

What about a fraction? We can do the inverse (starting with "0.")
0.6875 * 2 = 1.375, 1.375 rounded down is 1, 1.375 - 1 = 0.375, so
currentAnswer is "0.1", now calculate 0.375 binary
0.375 * 2 = 0.75, 0.75 rounded down is 0, 0.75 - 0 = 0.75, so currentAnswer is
"0.10", now calculate 0.75 binary
0.75 * 2 = 1.5, 1.5 rounded down is 1, 1.5 - 1 = 0.5, so currentAnswer is "0.
101", now calculate 0.5 binary
0.5 * 2 = 1, 1 rounded down is 1, 1 - 1 = 0, so currentAnswer is "0.1011", and
since 0 is left, we're done!

Of course, as in decimal notation, 1/3 never ends, binary notation can also
produce "unending" fractions.

Create a program that loops from 0.01 to 0.99 and calculates the binary
representation of each number. Note that you
may need to cut off the process at say 20 decimal digits, otherwise you can
loop forever (or until the imprecision in a
double)

Note: you may need to tweak this a bit, as double precision addition does not
work "properly" (0.01 + 0.01 is not
necessarily equal to 0.02... Actually, since doubles are numbers represented by
the computer in binary, this exercise
actually explains why this is so!)

Sample output:
0.01 in binary is 0.00000010100011110101
0.02 in binary is 0.00000101000111101011
0.03 in binary is 0.00000111101011100001
...
0.97 in binary is 0.11111000010100011110
0.98 in binary is 0.11111010111000010100
0.99 in binary is 0.11111101011100001010

Question: which binary fractions are short (way shorter than 20 digits)? Can
you understand why?
 */