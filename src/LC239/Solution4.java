package LC239;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution4 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // {nums[i], i}
        Queue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[] {nums[i], i});
        }
        res[index++] = maxHeap.peek()[0];

        for (int i = k; i < nums.length; i++) {
            maxHeap.offer(new int[] {nums[i], i});
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            res[index++] = maxHeap.peek()[0];
        }

        return res;
    }
}
