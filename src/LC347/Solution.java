package LC347;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // N: the length of `nums`
        // time: O(N logN)
        // space: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new int[] {entry.getValue(), entry.getKey()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            res[i] = maxHeap.poll()[0];
        }

        return res;
    }
}
