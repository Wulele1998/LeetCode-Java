package LC1;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // N: the length of array `nums`
        // time: O(N)
        // space: O(N) => HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int want = target - nums[i];
            if (map.containsKey(want)) {
                return new int[]{map.get(want), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
