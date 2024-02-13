package testing;

import java.util.function.UnaryOperator;

import static generic.CommandLine.getNewRGBColorStringOperator;

public class TestWithGenericMethods {


    public static void main(String[] args) {

        UnaryOperator<String> myColor = getNewRGBColorStringOperator(55, 55, 3);
        System.out.println(myColor.apply("Hello World"));

        String one = "HoiHoi1";
        System.out.println(one.matches(".*[0-9].*"));
//        StringBuilder first = new StringBuilder("Java");
//        first.insert(2, new char[]{'1', '2', '3', '4'}, 1, 3);
//        //first > Ja234va
//        first.delete(2, 5);
//        //first > Java
//        first.replace(1, 3, "1");
//        String second = first.substring(1, 3);
//        System.out.println(first);
//        int[] test = {0, 1, 2, 3, 4};
//        System.out.println(Arrays.toString(test));
//        change(test);
//        System.out.println(Arrays.toString(test));
//        int test2 = 0;
//        change(test2);
//        System.out.println(test2);
//        int[][] me = {{1, 2, 3}, {1, 2, 3, 4}, null};
//        me[2] = new int[3];


//        int multiplier = 5;
//        int min = 2;
//        int max = 6;
//
//        String prompt = "Please enter a whole number that you want to be multiplied by " + multiplier +
//                " (range: " + min + "-" + max + "):";
//        int input = CommandLine.askForInt(prompt, 2, 6);
//        System.out.printf("You entered: %s%d%s%n", ANSI_RED, input, ANSI_RESET);
//        int result = input * multiplier;
//        System.out.printf("Multiplying it by %d gives %d%n", multiplier, result);
//
//        String name = CommandLine.askForString("Please enter your name: ");
//        String chosenName = CommandLine.askForStringFromMenu("Harry", "Gerard", "Else", "Michel");
//        String[] nameList = new String[]{"Harry", "Gerard", "Else", "Michel"};
//        String newChosenName = CommandLine.askForStringFromMenu(nameList);
//        System.out.println(name + " " + chosenName + " " + CommandLine.green.apply(newChosenName));
    }

    public static void change(int a) {
        a = 5;
    }

    public static void change(int[] a) {
        a[0] = 2;
        a[1] = 2;
    }

}
