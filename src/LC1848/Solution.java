package LC1848;

public class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        int minToStart = n + 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target && minToStart > Math.abs(i - start)) {
                minToStart = Math.abs(i - start);
            }
        }

        return minToStart;
    }
}
