package LC3066;

import java.util.PriorityQueue;

/**
 * LC 3066. Minimum Operations to Exceed Threshold Value II
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int op = 0;
        for (int num : nums) {
            minHeap.add((long) num);
        }

        while (minHeap.size() >= 2 && minHeap.peek() >= k) {
            long x = minHeap.poll();
            long y = minHeap.poll();
            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));
            op++;
        }

        return op;
    }
}
