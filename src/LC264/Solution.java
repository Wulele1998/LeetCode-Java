package LC264;

public class Solution {
    public int nthUglyNumber(int n) {
        // Dynamic Programming
        // N: the number `n`
        // time: O(N)
        // space: O(N)
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, num2 = 2;
        int index3 = 0, num3 = 3;
        int index5 = 0, num5 = 5;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (num2 == dp[i]) {
                index2++;
                num2 = dp[index2] * 2;
            }
            if (num3 == dp[i]) {
                index3++;
                num3 = dp[index3] * 3;
            }
            if (num5 == dp[i]) {
                index5++;
                num5 = dp[index5] * 5;
            }
        }

        return dp[n - 1];
    }
}
