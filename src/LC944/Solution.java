package LC944;

/**
 * Dec 20, 2025
 * LC 944. Delete Columns to Make Sorted
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        // N: the length of `strs`
        // M: the length of each string in `strs`
        // time: O(M * N)
        // space: O(1)
        int count = 0;
        int m = strs.length;
        int n = strs[0].length();

        for (int c = 0; c < n; c++) {
            for (int r = 1; r < m; r++) {
                if (strs[r].charAt(c) < strs[r - 1].charAt(c)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
