package LC1572;

public class Solution {
    public int diagonalSum(int[][] mat) {
        // M: the length of `mat`
        // time: O(N)
        // space: O(1)
        int sum = 0;
        int m = mat.length;


        for (int i = 0; i < m; i++) {
            sum += mat[i][i] + mat[i][m - 1 - i];
        }

        if ((m & 1) == 0)
            sum -= mat[m / 2][m / 2];

        return sum;
    }
}
