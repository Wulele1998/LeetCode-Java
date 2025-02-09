package LC2364;

import java.util.HashMap;

/**
 * LC 2364. Count Number of Bad Pairs
 */
public class Solution {
    public long countBadPairs(int[] nums) {
        // N: the length of nums
        // time: O(N)
        // space: O(N)
        // nums[i] - i != nums[j] - j
        int n = nums.length;
        long total = (long)n * (long)(n - 1) / 2;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }

        // find nums[i] - i = nums[j] - j
        HashMap<Integer, Integer> map = new HashMap<>();
        long equalPair = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val >= 2) {
                equalPair += (long)val * (long)(val - 1) / 2;
            }
        }

        return total - equalPair;
    }
}
