package LC15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // time: O(N ^ 2)
    // space: O(log N), sort space
    private List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, nums[i]);
        }

        return res;
    }

    private void twoSum(int[] nums, int index, int current) {
        int l = index;
        int r = nums.length - 1;
        int target = -current;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                res.add(List.of(current, nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }

            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
    }
}
