package LC2125;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int numberOfBeams(String[] bank) {
        // M: the length of `bank`
        // N: the length of each bank string
        // time: O(M * N)
        // space: O(M)
        List<Integer> nums = new ArrayList<>();
        int res = 0;
        
        for (String s : bank) {
            int num = ones(s);
            if (num > 0) {
                nums.add(num);
            }
        }
        
        for (int i = 0; i < nums.size() - 1; i++) {
            res += nums.get(i) * nums.get(i + 1);
        }

        return res;
    }

    private int ones(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1')
                count++;
        }

        return count;
    }
}
