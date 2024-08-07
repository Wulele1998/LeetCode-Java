package LC1823;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1823. Find the Winner of the Circular Game
 */
public class Solution2 {
    public int findTheWinner(int n, int k) {
        // using Queue to simulate
        // time: O(N * k)
        // space: O(N)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
        
    }
}
