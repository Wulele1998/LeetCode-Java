package LC1043;

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // DP
        // N: the length of `arr`
        // time: O(N * k)
        // space: O(N)
        int n = arr.length;
        // dp[i] the sum of arr[i - 1]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int maxK = 0;
        for (int i = 1; i <= k; i++) {
            maxK = Math.max(maxK, arr[i - 1]);
            dp[i] = maxK * i;
        }

        for (int end = k + 1; end <= n; end++) {
            // index: k
            int curMax = 0;
            int start = end - k;

            for (int i = end - 1; i >= start; i--) {
                curMax = Math.max(curMax, arr[i]);
                dp[end] = Math.max(dp[end], dp[i] + curMax * (end - i));
            }
        }

        return dp[n];
    }
}
