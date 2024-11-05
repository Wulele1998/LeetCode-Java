package LC300;

import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // N: the length of `nums`
        // time: O(N ^ 2)
        // space: O(N)
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}
