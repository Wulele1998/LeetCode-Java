package LC1590;

import java.util.HashMap;

/**
 * Nov 30, 2025
 * LC 1590. Make Sum Divisible by P
 */
public class Solution {
    public int minSubarray(int[] nums, int p) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int sum = 0;
        // get the reminder of all numbers sum of `p`
        for (int num : nums) {
            sum = (sum + num) % p;
        }

        if (sum == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = nums.length;
        int currentSum = 0; // based on prefix sum
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            currentSum =  (currentSum + nums[i]) % p;
            // `(sum - currentSum + prefixSum) % p` should be 0
            int prefixSum = (currentSum - sum + p) % p; // the prefix we need to keep
            if (map.containsKey(prefixSum)) {
                res = Math.min(res, i - map.get(prefixSum));
            }

            map.put(currentSum, i);
        }

        return res == nums.length ? -1 : res;
    }
}
