package LC279;

public class Solution {
    public int numSquares(int n) {
        // time: O(N * √N)
        // space: O(N)
        int[] dp = new int[n + 1];
        // the max perfect square number less or equal than n
        int maxSquare = (int) Math.sqrt(n);
        int[] squares = new int[maxSquare + 1];
        for (int i = 1; i <= maxSquare; i++) {
            squares[i] = i * i;
            dp[i * i] = 1;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxSquare; j++) {
                if (squares[j] > i)
                    break;
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }

        return dp[n];
    }
}
