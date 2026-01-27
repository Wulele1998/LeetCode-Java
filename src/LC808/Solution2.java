package LC808;

public class Solution2 {
    double[][] memo;
    public double soupServings(int n) {
        // top down Dynamic Programming
        if (n > 5000) {
            return 1.0;
        }

        int m = n % 25 == 0 ? n / 25 : n / 25 + 1;
        memo = new double[m + 1][m + 1];

        return solve(m, m);

    }

    private double solve(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }

        if (memo[a][b] > 0.0) {
            return memo[a][b];
        }

        double prob = 0.25 * (solve(a - 1, b - 3) + solve(a - 2, b - 2) + solve(a - 3, b - 1) + solve(a - 4, b));
        memo[a][b] = prob;

        return memo[a][b];
    }
}
