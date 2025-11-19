package LC3318;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Nov 4, 2025
 * LC 3318. Find X-Sum of All K-Long Subarrays I
 */

public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        // N: the length of `nums`
        // K: `k`
        // time: O(N * K * logK)
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        res[0] = getSum(map, x);

        // sliding window
        for (int i = k; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[i - k], map.get(nums[i - k]) - 1);
            if (map.get(nums[i - k]) == 0) {
                map.remove(nums[i - k]);
            }

            res[i - k + 1] = getSum(map, x);
        }

        return res;
    }

    private int getSum(Map<Integer, Integer> map, int x) {
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        freqList.sort((o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0]); // O(k * logK)
        int sum = 0;
        for (int i = 0; i < Math.min(x, freqList.size()); i++) {
            int[] freq = freqList.get(i);
            sum += freq[0] * freq[1];
        }

        return sum;
    }
}
