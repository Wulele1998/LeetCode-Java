package LC41;

/**
 * LC 41. First Missing Positive
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        boolean[] isExist = new boolean[n + 1];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                isExist[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!isExist[i]) {
                return i;
            }
        }

        return n + 1;
    }
}
