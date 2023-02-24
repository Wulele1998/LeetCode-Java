package LC264;

public class Solution {
    public int nthUglyNumber(int n) {
        int num2 = 4;
        int num3 = 3;
        int num5 = 5;
        if (n <= 5) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 5; i++) {
            dp[i] = i;
        }
        for (int i = 6; i <= n; i++) {
            int next2 = num2 + 2;
            int next3 = num3 + 3;
            int next5 = num5 + 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (next2 == dp[i]) {
                num2 = next2;
            }
            if (next3 == dp[i]) {
                num3 = next3;
            }
            if (next5 == dp[i]) {
                num5 = next5;
            }
        }

        return dp[n];
    }
}
