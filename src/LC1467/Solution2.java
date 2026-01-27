package LC1467;

import java.util.Arrays;

public class Solution2 {
    int sum;
    int boxSize;
    int n;
    long[][] memoAll;
    long[][][] memoValid;
    int[][] comb;
    public double getProbability(int[] balls) {
        // N: the length of `balls`
        // M: the max value among `balls`
        // boxSize: M * N
        // time: O(M ^ 2 * N ^ 2)
        // space: O(M ^ 2 * N ^ 2)
        int maxBall = 0;
        for (int ball : balls) {
            sum += ball;
            maxBall = Math.max(maxBall, ball);
        }

        n = balls.length;
        boxSize = sum / 2;
        memoAll = new long[n][boxSize + 1];
        memoValid = new long[n][boxSize + 1][2 * n + 1]; // distinct color different can from 0 to n
        // O(M * M * N)
        for (int i = 0; i < n; i++) {
            Arrays.fill(memoAll[i], -1); // initialize
        }

        // O(M^2 * N^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < boxSize + 1; j++) {
                Arrays.fill(memoValid[i][j], -1);
            }
        }

        // O(M ^ 2)
        // n_C_k: choose k balls from n balls in same color
        // pre-compute c[n][k] k:
        comb = new int[maxBall + 1][maxBall + 1];
        // 1 0 => 0
        // 1 1 0 => 1 balls
        // 1 2 1 => 2 balls
        // 1 3 3 1 => 3 balls
        // 1 4 6 4 1 => 4 balls
        precomputeC(maxBall);

        long allCases = recursionAllCases(balls, 0, 0);
        long validCases = recursionValidCases(balls, 0, 0, 0);

        return 1.0 * validCases / allCases;
    }

    private void precomputeC(int n) {
        comb[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
    }

    private long recursionAllCases(int[] balls, int index, int box1) {
        if (index == balls.length) {
            if (box1 == boxSize) {
                return 1;
            } else {
                return 0;
            }
        }

        // check memo
        if (memoAll[index][box1] != -1) {
            return memoAll[index][box1];
        }

        long cases = 0L;
        for (int i = 0; i <= Math.min(boxSize - box1, balls[index]); i++) {
            // put `i` balls in box 1
            cases += comb[balls[index]][i] * recursionAllCases(balls, index + 1, box1 + i);
        }

        return memoAll[index][box1] = cases;
    }

    // colorDiff = color of box 1 - color of box2
    private long recursionValidCases(int[] balls, int index, int box1, int colorDiff) {
        if (balls.length == index) {
            if (box1 == boxSize && colorDiff == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // check memo
        if (memoValid[index][box1][colorDiff + n] != -1) {
            return memoValid[index][box1][colorDiff + n];
        }

        long cases = 0L;
        for (int i = 0; i <= Math.min(balls[index], boxSize - box1); i++) {
            if (i == 0) {
                // all balls go to one of the boxes
                cases += comb[balls[index]][i] * recursionValidCases(balls, index + 1, box1 + i, colorDiff - 1);
            } else if (i == balls[index]) {
                cases += comb[balls[index]][i] * recursionValidCases(balls, index + 1, box1 + i, colorDiff + 1);
            } else{
                // put balls into both boxes
                cases += comb[balls[index]][i] * recursionValidCases(balls, index + 1, box1 + i, colorDiff);
            }
        }

        return memoValid[index][box1][colorDiff + n] = cases;
    }
}
