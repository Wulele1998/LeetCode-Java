package LC347;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, map.get(num));
        }

        // bucket sort (counting sort)
        ArrayList<Integer>[] freq = new ArrayList[maxCount + 1];
        for (int i = 0; i < maxCount + 1; i++) {
            freq[i] = new ArrayList<>();
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = maxCount; i >= 0 && index < k; i--) {
            for (int key : freq[i]) {
                res[index++] = key;
            }
        }

        return res;
    }
}
