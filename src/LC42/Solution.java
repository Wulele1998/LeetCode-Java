package LC42;

public class Solution {
    public int trap(int[] height) {
        // time: O(N)
        // space: O(N)
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int res = 0;

        prefixMax[0] = height[0];
        suffixMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        for (int i = 1; i <= n - 2; i++) {
            if (height[i] < prefixMax[i] && height[i] < suffixMax[i]) {
                res += Math.min(prefixMax[i], suffixMax[i]) - height[i];
            }
        }

        return res;
    }
}