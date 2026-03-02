package OA.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final AtomicInteger idSource;
    private final String name;

    public Producer(BlockingQueue<Integer> queue, AtomicInteger idSource, String name) {
        this.queue = queue;
        this.idSource = idSource;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = idSource.incrementAndGet();
                System.out.println(name + " produced: " + value);
                queue.put(value);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final String name;

    public Consumer(BlockingQueue<Integer> queue, String name) {
        this.queue = queue;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            while (true) {
                int value = queue.take();
                System.out.println(name + " consumed: " + value);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerCustomerBQ {
    public static void main() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        AtomicInteger idSource = new AtomicInteger(0);

        Thread p1 = new Thread(new Producer(queue, idSource, "Producer 1"));
        Thread p2 = new Thread(new Producer(queue, idSource, "Producer 2"));

        Thread c1 = new Thread(new Consumer(queue,  "Consumer 1"));
        Thread c2 = new Thread(new Consumer(queue,  "Consumer 2"));

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
