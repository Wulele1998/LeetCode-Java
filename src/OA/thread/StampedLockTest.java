package OA.thread;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    private final StampedLock stampedLock = new StampedLock();
    private int data = 0;

    public void write(int value) {
        long stamp = stampedLock.writeLock();
        try {
            data = value;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public int read() {
        long stamp = stampedLock.tryOptimisticRead(); // use optimistic read (no lock)
        int currentData = data;
        if (!stampedLock.validate(stamp)){
            // retry optimistic read 5 times
            for (int i = 0; i < 5; i++) {
                stamp = stampedLock.tryOptimisticRead();
                currentData = data;
                if (stampedLock.validate(stamp)){
                    return currentData;
                }
            }

            // manually inflate to pessimistic read lock
            stamp = stampedLock.readLock();
            try {
                currentData = data;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        return currentData;
    }
}
