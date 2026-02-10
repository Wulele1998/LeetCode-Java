package LC3719;

import java.util.Map;
import java.util.HashMap;

/**
 * Feb 10
 * LC 3719. Longest Balanced Subarray I
 */
public class Solution {
    public int longestBalanced(int[] nums) {
        // N: the length of `nums`
        // time: O(N ^ 2)
        // space: O(N)
        int n = nums.length;
        int res = 0;
        
        // subarray [i .. j]
        for (int i = 0; i < n; i++) {
            // key: the number
            // value: count the appearence of each number
            Map<Integer, Integer> map = new HashMap<>();
            int even = 0;
            int odd = 0;
            for (int j = i; j < n; j++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                    if (nums[i] % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }

                if (odd == even) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }
}
