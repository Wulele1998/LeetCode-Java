package LC1848;

/**
 * April 13, 2026
 * LC 1848. Minimum Distance to the Target Element
 */
public class Solution2 {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int l = start;
        int r = start;
        int move = 0;
        while (l >= 0 || r < n) {
            if ((l >= 0 && nums[l] == target) || (r < n && nums[r] == target)) {
                return move;
            }
            l--;
            r++;
            move++;
        }

        return -1;
    }
}
