package LC368;

import java.util.*;

/**
 * LC 368. Largest Divisible Subset
 */
public class Solution2 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // DP optimzie the space from O(N ^ 2) to O(N)
        // time: O(N ^ 2)
        // space: O(N)
        int n = nums.length;
        int[] dp = new int[n];
        int maxSize = -1;
        int maxIndex = -1;

        Arrays.sort(nums);
        
        for (int i = 0; i < n; i++) {
            int maxSubsetSize = 0;
            for (int k = 0; k < i; k++) {
                if (nums[i] % nums[k] == 0 && dp[k] > maxSubsetSize) {
                    maxSubsetSize = dp[k];
                }
            }
            dp[i] = maxSubsetSize + 1; // add `nums[i]` self
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // construct the max subset
        LinkedList<Integer> res = new LinkedList<>();
        int curTail = nums[maxIndex];
        int expectSize = maxSize;
        for (int i = maxIndex; i >= 0; i--) {
            if (expectSize == 0)
                break; // already get the result
            if (curTail % nums[i] == 0 && expectSize == dp[i]) {
                // IMPORTANT: need to check the size in the `dp` list if this number is the one we want
                res.addFirst(nums[i]);
                expectSize--;
                curTail = nums[i];
            }
        }
        
        return res;
    }
}
