package LC2599;

import java.util.PriorityQueue;

/**
 * LC 2599. Make the Prefix Sum Non-negative
 */
public class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        // N: the size of `nums`
        // time: O(N log N)
        // space: O(N)
        int prefixSum = 0;
        int move = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (num < 0) {
                minHeap.add(num);
            }
            prefixSum += num;
            while (prefixSum < 0 && !minHeap.isEmpty()) {
                prefixSum -= minHeap.poll();;
                move++;
            }
        }

        return move;
    }
}
