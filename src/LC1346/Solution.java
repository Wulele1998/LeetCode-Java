package LC1346;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 1346. Check If N and Its Double Exist
 */
public class Solution {
    public boolean checkIfExist(int[] arr) {
        // N: the length of `arr`
        // time: O(N)
        // space: O(N)
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
