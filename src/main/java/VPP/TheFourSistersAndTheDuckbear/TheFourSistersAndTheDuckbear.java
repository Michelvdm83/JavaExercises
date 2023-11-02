package VPP.TheFourSistersAndTheDuckbear;

import java.util.Scanner;
public class TheFourSistersAndTheDuckbear {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input total amount of chocolate eggs gathered: ");
        int totalEggs = input.nextInt();
        System.out.println("Each sister gets " + (totalEggs/4) + " eggs.");
        System.out.println("The duckbear gets " + (totalEggs%4) + " eggs.");

        // eggs < 16, because when the 4 sisters collect 16 eggs, each get 4 eggs.
        // The duckbear will never get more than 3 eggs.
        StringBuilder duckbearHappy = new StringBuilder("the duckbear gets more than the sister when they collect these number of eggs: \n");
        for(int eggs = 1; eggs < 16; eggs++){
            if(eggs%4 > eggs/4) duckbearHappy.append(eggs).append(", ");
        }
        duckbearHappy.delete(duckbearHappy.length()-2, duckbearHappy.length()-1);
        System.out.println(duckbearHappy);
    }
}
/*
The Four Sisters and the Duckbear

Four sisters own a chocolate farm and collect chocolate eggs laid by chocolate
chickens every day. But more often than not, the number of eggs is not evenly
divisible among the sisters, and everybody knows you cannot split a chocolate
egg into
pieces without ruining it. The arguments have grown more heated over time. The
town is
tired of hearing the four sisters complain, and Chandra, the town’s Arbiter, has
finally come up with a plan everybody can agree to. All four sisters get an
equal
number of chocolate eggs every day, and the remainder is fed to their pet
duckbear.
All that is left is to have some skilled Programmer build a program to tell
them how
much each sister and the duckbear should get.

Objectives:
- Create a program that lets the user enter the number of chocolate eggs
gathered
that day.
- Using / and %, compute how many eggs each sister should get and how many are
left over for the duckbear.

Answer this question: What are the total egg counts where the duckbear gets
more than each sister does? You can use the program you created to help you
find the answer.
 */