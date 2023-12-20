package PlayersGuide.TheRepeatingStream;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RecentNumbers {
    private int lastNumber = -1;
    private int currentNumber = -1;
    private final Lock lock = new ReentrantLock();

    public void putNextNumber(int number) {
        lock.lock();

        lastNumber = currentNumber;
        currentNumber = number;

        lock.unlock();
    }

    public boolean equalNumbers() {
        lock.lock();
        try {
            return lastNumber == currentNumber;
        } finally {
            lock.unlock();
        }
    }
}
