package vpp.Money;

import java.math.BigDecimal;

public class Money {
    public static void main(String[] args){
        float fValue = 12.41f;
        double dValue = 12.41;
        BigDecimal bdValue = BigDecimal.valueOf(12.41);
        for(int i = 1; i <= 100; i++){
            System.out.println(i +" wadget(s): float = €" + fValue*i + ", double = €" + dValue*i + ", BigDecimal = €" + bdValue.multiply(BigDecimal.valueOf(i)));
        }
        System.out.println("Based on these result, the best data type would be BigDecimal");
    }
}
/*
EMCA industries wants to install a new Java(tm) based accounting system.
However, the system being so flexible, Ad in
accounting needs to set the datatype for prices himself, and not being a
programmer, he turns to his superiors during
their coffee break. Manager Fred says Ad should use floats, Manager Dennis
prescribes doubles, and Manager Betty insists
on BigDecimals. As none of them, on deeper probing, actually knows what those
menu options mean, they turn to you, the
lone technically competent person at EMCA industries, to help Ad decide.

Create a program that shows to Ad whether the prices calculated by float,
double and BigDecimal are different,
for 1 to 100 wadgets(tm), 12.41 euros each.

HINT: BigDecimal is a bit weird, as it is a class instead of a primitive, but
consult the official documentation about
BigDecimal (https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/
math/BigDecimal.html) and you should be
fine...

Expected output
1 wadget(s): float = €12.41, double = €12.41, BigDecimal = €12.41
2 wadget(s): float = €24.82, double = €24.82, BigDecimal = €24.82
3 wadget(s): float = €37.23, double = €37.230000000000004, BigDecimal = €37.23
...
99 wadget(s): float = €1228.59, double = €1228.59, BigDecimal = €1228.59
100 wadget(s): float = €1241.0, double = €1241.0, BigDecimal = €1241.00

Based on this list, which data type would you recommend?
// Bonus: if you haven't done so already, check out the BinaryFractions
exercise to better understand the result...
 */