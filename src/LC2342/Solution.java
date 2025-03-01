package LC2342;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * LC 2342. Max Sum of a Pair With Equal Sum of Digits
 */
public class Solution {
    public int maximumSum(int[] nums) {
        // N: the number of `nums`
        // time: O(N logN)
        // space: O(N)
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int maxPairSum = 0;
        for (int num : nums) {
            map.computeIfAbsent(digitSum(num), key -> new PriorityQueue<>((a, b) -> b - a)).add(num);
        }

        for (HashMap.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> maxHeap = entry.getValue();
            if (maxHeap.size() >= 2) {
                int sum = maxHeap.poll();
                sum += maxHeap.poll();
                maxPairSum = Math.max(maxPairSum, sum);
            }
        }

        return maxPairSum;
    }

    private int digitSum(int num) {
        String str = String.valueOf(num);
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += c - '0';
        }

        return sum;
    }
}
