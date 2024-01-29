package playersguide.TheRepeatingStream;

import java.util.Scanner;

public class TheRepeatingStream extends Thread {
    private static final RecentNumbers numbers = new RecentNumbers();

    public static void main(String[] args) {
        TheRepeatingStream numberGenerator = new TheRepeatingStream();
        numberGenerator.start();
        int count = 0;
        Scanner input = new Scanner(System.in);
        while (count < 3) {
            String s = input.nextLine();
            if (numbers.equalNumbers()) {
                System.out.println("The numbers are equal indeed!");
                count++;
            } else {
                System.out.println("The numbers aren't equal at the moment!");
            }
        }
        System.exit(0);
    }

    public void run() {
        while (true) {
            int randomNumber = (int) (Math.random() * 10);
            System.out.println(randomNumber);
            numbers.putNextNumber(randomNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep is interrupted");
            }
        }
    }

}
