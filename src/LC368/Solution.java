package LC368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // DP
        // N: the length of `nums`
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        int n = nums.length;
        List<List<Integer>> dp = new ArrayList<>();
        for (int num : nums)
            dp.add(new ArrayList<>());

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            List<Integer> maxSubset = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                if (nums[i] % nums[k] == 0 && maxSubset.size() < dp.get(k).size()) {
                    maxSubset = dp.get(k);
                }
            }
            dp.get(i).add(nums[i]);
            dp.get(i).addAll(maxSubset);
        }

        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (dp.get(maxIndex).size() < dp.get(i).size())
                maxIndex = i;
        }

        return dp.get(maxIndex);
    }
}
