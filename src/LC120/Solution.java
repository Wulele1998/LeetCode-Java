package LC120;

import java.util.List;

/**
 * LC 120. Triangle
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // DP: top-down
        // N: the number of levels in the `triangle`
        // time: O(N ^ 2)
        // space: O(1), replace the value in the `triangle`
        int m = triangle.size();
        for (int i = 1; i < m; i++) {
            List<Integer> level = triangle.get(i);
            int n = level.size();
            level.set(0, level.get(0) + triangle.get(i - 1).get(0));
            level.set(n - 1, level.get(n - 1) + triangle.get(i - 1).get(n - 2));
            for (int j = 1; j < n - 1; j++) {
                level.set(j, level.get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
        }
        
        int mini = triangle.get(m - 1).get(0);
        for (int j = 1; j < m; j++) {
            mini = Math.min(mini, triangle.get(m - 1).get(j));
        }
        
        return mini;
    }
}
