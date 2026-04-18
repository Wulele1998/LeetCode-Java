package LC128;

import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        HashSet<Integer> set = new HashSet<>();
        int res = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                // num is the start of the sequence
                int count = 1;
                while (set.contains(++num)) {
                    count++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }
}
