package LC2698;

import java.util.Arrays;

/**
 * LC 2698. Find the Punishment Number of an Integer
 */
public class Solution {
    public int punishmentNumber(int n) {
        // N: the number `n`
        // time: O(N * 2 ^ log_10 (N ^ 2)) => O(N * 2 ^ log N)
        // space: O(N * log N)
        // O(log_10 (N^2)) = O(log_2 (N^2) / (log_10 2)) = O(log_2 (N^2)) = O(2log_2 N)
        int res = 0;
        for (int cur = 1; cur <= n; cur++) {
            int square = cur * cur;
            String squareStr = String.valueOf(square);
            // start to split the square number string
            // record the memo
            int[][] memo = new int[squareStr.length()][cur + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            if (findPartition(0, 0, squareStr, cur, memo)) {
                res += square;
            }
        }

        return res;
    }

    private boolean findPartition(int startIndex, int sum, String squareStr, int target, int[][] memo) {
        if (startIndex == squareStr.length()) {
            return sum == target;
        }
        // sum is larger than target, no need to continue
        if (sum > target) {
            return false;
        }

        if (memo[startIndex][sum] != -1) {
            return memo[startIndex][sum]  == 1;
        }

        // start recursion
        boolean partitionFound = false;
        // before [startIndex, squareStr.length()) the result is sum
        // [startIndex, index + 1), [index + 1, squareStr.length())
        for (int index = startIndex; index < squareStr.length(); index++) {
            String curStr = squareStr.substring(startIndex, index + 1);
            // [startIndex, index + 1) part
            int num = Integer.parseInt(curStr);
            // [index + 1, squareStr.length()) part
            partitionFound = findPartition(index + 1, sum + num, squareStr, target, memo);

            if (partitionFound) {
                memo[startIndex][sum] = 1;
                return true;
            }
        }

        memo[startIndex][sum] = 0;
        return false;
    }
}
