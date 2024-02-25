package LC1043;

import java.util.Arrays;

public class Solution3 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // DP
        // bottom-up
        int n = arr.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, 0);
        for (int start = n - 1; start >= 0; start--) {
            int curMax = 0;
            int end = Math.min(start + k, n);
            for (int i = start; i < end; i++) {
                // get the max number among the k-sized window
                curMax = Math.max(arr[i], curMax);
                dp[start] = Math.max(dp[start], dp[i + 1] + curMax * (i - start + 1));
            }
        }

        return dp[0];
    }
}
