package OA.thread;

import org.junit.Test;

public class BlockTest {
    @Test
    public void testBlock() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        }, "thread 1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        }, "thread 2");

        t1.start();
        t1.join();
        t2.start();

        System.out.println(t1.getName() + ":" + t1.getState());
        System.out.println(t2.getName() + ":" + t2.getState());
    }

    private synchronized void test() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
