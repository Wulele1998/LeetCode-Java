package LC2568;

import java.util.HashSet;

public class Solution {
    public int minImpossibleOR(int[] nums) {
        // if 1 not in `nums` => 1
        // if 2 not in `nums` => 2
        // we can create 3 by 1 | 2
        // if 4 not in `nums` => 4
        // we can create 5 by 1 | 4
        // we can create 6 by 2 | 4
        // we can create 7 by 3 | 4

        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int n = 1;
        while (set.contains(n)) {
            n <<= 1;
        }

        return n;
    }
}
