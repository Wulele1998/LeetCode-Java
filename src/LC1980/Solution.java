package LC1980;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;
        int max = (int) Math.pow(2, n);
        for (int i = 0; i < max; i++) {
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
