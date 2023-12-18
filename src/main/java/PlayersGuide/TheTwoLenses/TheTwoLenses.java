package PlayersGuide.TheTwoLenses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheTwoLenses {
    public static void main(String[] args) {
        int[] originalList = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        List<Integer> newListProcedural = sortListProcedural(originalList);
        List<Integer> newListLambda = sortListWithLambdas(originalList);
        System.out.println(Arrays.toString(originalList));
        System.out.println(newListProcedural);
        System.out.println(newListLambda);
    }

    public static List<Integer> sortListProcedural(int[] original) {
        List<Integer> returnList = new ArrayList<>();
        for (int i : original) {
            if (i % 2 == 0) returnList.add(i);
        }
        returnList.sort(null);
        for (int i = 0; i < returnList.size(); i++) {
            int temp = returnList.get(i);
            returnList.set(i, temp * 2);
        }
        return returnList;
    }

    public static List<Integer> sortListWithLambdas(int[] original) {
        return Arrays.stream(original).boxed().sorted().filter(i -> i % 2 == 0).map(i -> i * 2).toList();
    }
}
/*
with lambdas the code is much shorter, but can be harder to read
the procedural code states each step separately, making it easier to understand

All the odd numbers are filtered out, and only the even should be considered.
The numbers are in order.
The numbers are doubled.
 */
