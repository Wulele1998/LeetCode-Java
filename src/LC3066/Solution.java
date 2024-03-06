package LC3066;

import java.util.PriorityQueue;

public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);
        }

        while (minHeap.size() >= 2) {
            long num1 = minHeap.poll();
            long num2 = minHeap.poll();

        }

        return 0;
    }
}
