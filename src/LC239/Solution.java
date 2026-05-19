package LC239;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // time: O(N * logN)
        // space: O(N)
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            maxHeap.offer(nums[i]);
        }

        res[0] = maxHeap.peek();

        // sliding window
        for (int i = 1; i < res.length; i++) {
            // remove the element from the window
            freqMap.put(nums[i - 1], freqMap.get(nums[i - 1]) - 1);
            // add new element into the window
            freqMap.put(nums[i - 1 + k], freqMap.getOrDefault(nums[i - 1 + k], 0) + 1);
            if (freqMap.get(nums[i - 1]) == 0) {
                freqMap.remove(nums[i - 1]);
            }
            maxHeap.offer(nums[i - 1 + k]);

            while (!freqMap.containsKey(maxHeap.peek())) {
                maxHeap.poll();
            }
            res[i] = maxHeap.peek();
        }

        return res;
    }
}
