package LC362;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    private Queue<Integer> queue;

    public HitCounter() {
        this.queue = new LinkedList<>();
    }
    
    // time: O(1)
    public void hit(int timestamp) {
        queue.add(timestamp);
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
    }

    // time: O(N)
    // space: O(N)
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
        return queue.size();
    }
}
