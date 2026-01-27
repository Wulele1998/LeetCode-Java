package LC1467;

/**
 * LC 1467. Probability of a Two Boxes Having The Same Number of Distinct Balls
 */
public class Solution {
    int sum = 0;
    public double getProbability(int[] balls) {
        for (int ball : balls) {
            sum += ball;
        }

        return allCases(balls, 0, 0, 0) / casesWithEqualDistinctBalls(balls, 0, 0, 0, 0, 0);
    }

    /**
     * get all possible cases to split the balls into 2 boxes evenly
     * @param balls balls
     * @param index current index of balls
     * @param box1 the number of balls in first box
     * @param box2 the number of balls in second box
     * @return the number of cases
     */
    private double allCases(int[] balls, int index, int box1, int box2) {
        // base case
        if (index == balls.length) {
            if (box1 == box2) {
                // box1 has sum / 2 balls, which has factorial(sum / 2) permutation
                // box2 same
                return 1.0;
            } else {
                return 0.0;
            }
        }

        double cases = 0.0;
        // put some balls into first box, some to second box
        for (int i = 0; i <= balls[index]; i++) {
            cases += allCases(balls, index + 1, box1 + i, box2 + balls[index] - i) / (factorial(i) * factorial(balls[index - i]));
        }

        return cases;
    }

    /**
     *
     * @param balls balls
     * @param index current index
     * @param box1 the number of balls in first box
     * @param box2 the number of balls in second box
     * @param distBox1 the number of distinct balls in first box
     * @param distBox2 the number of distinct balls in second box
     * @return the number of cases that two boxes has same distinct balls
     */
    private double casesWithEqualDistinctBalls(int[] balls, int index, int box1, int box2, int distBox1, int distBox2) {
        if (index == balls.length) {
            if (box1 == box2 && distBox1 == distBox2) {
                return 1.0;
            } else {
                return 0.0;
            }
        }

        double cases = 0.0;
        for (int i = 0; i <= balls[index]; i++) {
            if (i == 0) {
                // all balls in current color put into box 2
                cases += casesWithEqualDistinctBalls(balls, index + 1, box1, box2 + balls[index], distBox1, distBox2 + 1) / factorial(balls[index]);
            } else if (i == balls[index]) {
                // all balls in current color put into box 1
                cases += casesWithEqualDistinctBalls(balls, index + 1, box1 + balls[index], box2, distBox1 + 1, distBox2) / factorial(balls[index]);
            } else {
                // put balls in both boxes
                cases += casesWithEqualDistinctBalls(balls, index + 1, box1 + i, box2 + balls[index] - i, distBox1 + 1, distBox2 + 1) / (factorial(i) * factorial(balls[index] - i));
            }
        }

        return cases;
    }

    private double factorial(int n) {
        double res = 1.0;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }
}
