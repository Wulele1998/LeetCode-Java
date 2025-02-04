package LC1056;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean confusingNumber(int n) {
        // N: the number `n`
        // time: O(log N)
        // space: O(1)
        Set<Integer> set = new HashSet<>(Arrays.asList(0, 1, 6, 8, 9));
        int num = n;
        int newNum = 0;
        
        while (n > 0) {
            int digit = n % 10;
            if (!set.contains(digit)) {
                return false;
            }
            n /= 10;
            if (digit == 6)
                digit = 9;
            else if (digit == 9)
                digit = 6;
            newNum *= 10;
            newNum += digit;
        }

        return newNum != num;
    }
}
