package VPP.Snail;

import java.util.ArrayList;
import java.util.Arrays;

public class Snail {
    public static void main(String[] args){
        int[][] snailMe = {{1, 2, 6, 10},{5, 3, 4, 11},{7, 8, 9, 12}, {13, 14, 15, 16}};
        snailMe = snail(snailMe);
        for (int[] ints : snailMe) {
            for (int j = 0; j < snailMe.length; j++) {
                //first try
                //System.out.print(snailMe[i][j] + " ");
                //better formatted
                System.out.printf("%2d ", ints[j]);
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(snailMe));
    }

    private static int[][] snail(int[][] original){
        int side = original.length;
        if(side < 2) return original;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int[] iArray:original){
            for(int i: iArray){
                temp.add(i);
            }
        }
        temp.sort(null);

        //obtain the 'route' to follow
        int[] theWay = order(side);
        int[][] returnArray = new int[side][side];
        int count = 0;
        //second try, shorter version
        for(int i: theWay){
            int x = i/side;
            int y = i%side;
            returnArray[x][y] = temp.get(count);
            count++;
        }

        //first try
        /*int[] list = new int[temp.size()];
        int count = 0;

        for(int i: theWay){
            list[i] = temp.get(count);
            count++;
        }

        int[][] returnArray = new int[side][side];
        count = 0;
        for(int i = 0; i < returnArray.length; i++){
            for(int j = 0; j < returnArray[i].length; j++){
                returnArray[i][j] = list[count];
                count++;
            }
        }*/
        return returnArray;
    }

    private static int[] order(int length){
        int[] returnMe = new int[length*length];
        int x = 0, y = 0;
        int xMax = length-1, yMax = length-1;
        int xMin = 0, yMin = 1;
        boolean forward = true;
        for(int i = 0; i < returnMe.length; i++){
            returnMe[i] = y*length+x;
            //debugging statement
            //System.out.println(returnMe[i]);
            if(forward){
                if(x < xMax){
                    x++;
                }
                else if(y < yMax){
                    y++;
                }
                else{
                    xMax--;
                    yMax--;
                    x--;
                    forward = false;
                }

            }
            else{
                if(x > xMin){
                    x--;
                }
                else if(y > yMin){
                    y--;
                }
                else{
                    xMin++;
                    yMin++;
                    x++;
                    forward = true;
                }
            }
        }
        return returnMe;
    }
}
/*
Snail Sort
Given an n x n array, return the array elements arranged from outermost
elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array
consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]

NOTE: The idea is not sort the elements from the lowest value to the highest;
the idea is to traverse the 2-d array in a clockwise snailshell pattern.

NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array
[[]].

NOTE 3: the tags SUGGEST a solution, but it is perfectly possible to do snail
sort with just a couple of loops.
The most important thing is that you think of a solution you find easy/
The most important thing is that you think of a solution you find easy/logical
and can implement,
even if it is not the fanciest or shortest in existence (in this phase,
even if it is not the fanciest or shortest in existence (in this phase, as many
lines of code per hour is
      way more important than finding the most elegant solution)
 */