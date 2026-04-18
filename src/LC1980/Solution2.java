package LC1980;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution2 {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        for (String num : nums)
            set.add(Integer.parseInt(num, 2));

        int n = nums.length;
        int maxLimit = (int) Math.pow(2, n);
        Random random = new Random();
        int ans;

        do {
            ans = random.nextInt(maxLimit);
        } while (set.contains(ans));

        String s = Integer.toBinaryString(ans);
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length(); i < n; i++) {
            sb.insert(0, "0");
        }

        return sb.toString();
    }
}
