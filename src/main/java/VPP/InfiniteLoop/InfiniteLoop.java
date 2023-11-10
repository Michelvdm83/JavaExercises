package VPP.InfiniteLoop;

import java.util.ArrayList;
import java.util.List;

public class InfiniteLoop {
    public static void main(String[] args) {
        System.out.println(printArray(1));
        System.out.println(printArray(3));
        System.out.println(printArray(6));
    }

    public static List<Integer> printArray(int number)
    {
        List<Integer> array = new ArrayList<>();

        for(int count = 1; count <= number; count++) {
            array.add(count);
        }

        return array;
    }
}
