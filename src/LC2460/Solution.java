package LC2460;

/**
 * LC 2460. Apply Operations to an Array
 */
public class Solution {
    public int[] applyOperations(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int[] res = new int[n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                res[index++] = nums[i] * 2;
                i++;
            } else {
                res[index++] = nums[i];
            }
        }

        for (int i = index; i < n; i++) {
            res[i] = 0;
        }

        return res;
    }
}
