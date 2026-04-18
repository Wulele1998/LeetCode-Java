package LC1980;

import java.util.HashSet;
import java.util.Set;

/**
 * March 8, 2026
 * LC 1980. Find Unique Binary String
 */
public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // N: the length of `nums`, the length of each string in `nums`
        // time: O(N ^ 2)
        // space: O(N)
        Set<Integer> set = new HashSet<>();
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                String s = Integer.toBinaryString(i);
                StringBuilder sb = new StringBuilder(s);
                for (int zero = s.length(); zero < n; zero++) {
                    sb.insert(0, "0");
                }
                return sb.toString();
            }
        }

        return null;
    }
}
