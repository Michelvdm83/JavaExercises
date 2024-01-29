package vpp.DoubleArithC;

public class DoubleArithC {
    public static void main(String[] args) {
        int divide = 3;
        int count = 1;
        double subResult = 1.0;

        for (double endResult = 0.0; endResult < 3.14 || endResult > 3.15;count++) {
            if(count%2 == 0){
                subResult += (1.0 / divide);
            }
            else {
                subResult -= (1.0 / divide);
            }
            endResult = 4.0 * subResult;

            System.out.println(endResult);
            divide+=2;
        }
        //System.out.println(4.0 * (1 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11)));
    }
}
