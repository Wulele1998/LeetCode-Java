package LC1672;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        // M: the row number of `accounts`
        // N: the column number of `accounts`
        // time: O(M * N)
        int res = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int bank : account) {
                sum += bank;
            }
            res = Math.max(res, sum);
        }

        return res;
    }
}
