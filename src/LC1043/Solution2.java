package LC1043;

import java.util.Arrays;
public class Solution2 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // DP Top-down
        // N: the length of `arr`
        // time: O(N * K)
        // space: O(N)
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return maxSum(arr, k, dp, 0);
    }

    private int maxSum(int[] arr, int k, int[] dp, int start) {
        int n = arr.length;

        if (start >= n)
            return 0;

        if (dp[start] != -1)
            return dp[start];

        int curMax = 0;
        int ans = 0;
        int end = Math.min(n, start + k);
        for (int i = start; i < end; i++) {
            // find the max number among arr[start ... end]
            curMax = Math.max(curMax, arr[i]);
            ans = Math.max(ans, curMax * (i - start + 1) + maxSum(arr, k, dp, i + 1));
        }
        return dp[start] = ans;
    }
}
