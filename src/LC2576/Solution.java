package LC2576;

import java.util.Arrays;

public class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        // N: the length of `nums`
        // time: O(N * log N) => Sort
        // space: O(log N) => Quick Sort in Java
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;

        for (int j = n - n / 2; j < n; j++) {
            i += 2 * nums[i] <= nums[j] ? 1 : 0;
        }

        return i * 2;
    }
}
