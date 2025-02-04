package LC1502;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // save time without sort the whole array
        // N: the length of `arr`
        // time: O(N)
        // space: O(N), the space of HashSet
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            maxNum = Math.max(num, maxNum);
            minNum = Math.min(num, minNum);

            set.add(num);
        }

        if ((maxNum - minNum) % (n - 1) != 0)
            return false;

        int diff = (maxNum - minNum) / (n - 1);
        int start = minNum;

        for (int i = 1; i < n - 1; i++) {
             start += diff;
            if (!set.contains(start)) {
                return false;
            }
        }

        return true;
    }
}
