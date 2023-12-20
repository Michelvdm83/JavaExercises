package PlayersGuide.RandomWords;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RandomWords implements Callable<Integer> {
    private static String string;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            lock.lock();
            System.out.print("Please input a word to be generated randomly: ");
            String word = input.nextLine();
            lock.unlock();
            RandomWords wordTest = new RandomWords(word);
            //ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Integer> future = executor.submit(wordTest);
            FuturePrinting printer = new FuturePrinting(lock, wordTest.getString(), future);
            printer.start();
        }
        executor.close();
    }

    public RandomWords(String text) {
        string = text;
    }

    public String getString() {
        return string;
    }

    @Override
    public Integer call() {
        long start = System.currentTimeMillis();
        int numberOfTries = 1;
        int stringLength = string.length();
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        while (true) {
            for (int i = 0; i < stringLength; i++) {
                randomString.append((char) ('a' + random.nextInt(26)));
            }
            if (string.equalsIgnoreCase(randomString.toString())) {
                break;
            } else {
                randomString.setLength(0);
                numberOfTries++;
            }
        }
        long finish = System.currentTimeMillis();
        double timeNeeded = (finish - start) / 1000.0;
        lock.lock();
        System.out.println(timeNeeded + " seconds where needed to get the string: " + randomString);
        lock.unlock();
        return numberOfTries;
    }
}

//A thread that can wait for the result of a Future and print when ready
class FuturePrinting extends Thread {
    private final Lock lock;
    private final String string;
    private final Future<Integer> future;

    public FuturePrinting(Lock lock, String string, Future<Integer> future) {
        this.lock = lock;
        this.string = string;
        this.future = future;
    }

    public void run() {
        //waiting for the future to be done before getting its return value, so I can get the lock without
        //other parts having to wait for the lock until the future is ready
        while (!future.isDone()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Interrupted thread");
            }
        }
        try {
            lock.lock();
            System.out.println("it took me " + future.get() + " tries to produce: " + string);
            lock.unlock();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}