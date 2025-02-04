package LC442;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * LC 442. Find All Duplicates in an Array
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // N: the length of `nums`
        // time: O(N logN)
        // space: O(logN)
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res.add(nums[i]);
                i++;
            }
        }

        return res;
    }
}
