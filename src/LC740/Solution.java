package LC740;

import java.util.HashMap;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        // Dynamic Programming
        // N: the length of `nums`
        // K: the max number in `nums`
        // time: O(N + K)
        // space: O(N + K), N for the hashmap K for the dp array
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        // we use the index [1, maxNum]
        int[] dp = new int[maxNum + 1];
        // base case
        dp[1] = map.getOrDefault(1, 0);

        // transition equation
        // dp[i] = max(dp[i-2] + gain, dp[i-1])
        for (int i = 2; i < maxNum + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + map.getOrDefault(i, 0), dp[i - 1]);
        }

        return dp[maxNum];
    }
}
