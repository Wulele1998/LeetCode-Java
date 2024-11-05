package LC2441;

import java.util.Arrays;

public class Solution2 {
    public int findMaxK(int[] nums) {
        // two pointers
        // N: the length of `nums`
        // time: O(N * logN)
        // space: O(logN)
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (-nums[i] == nums[j]) {
                return nums[j];
            } else if (-nums[i] > nums[j]) {
                i++;
            } else if (-nums[i] < nums[j]) {
                j--;
            }
        }

        return -1;
    }
}
