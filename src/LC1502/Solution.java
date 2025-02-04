package LC1502;

import java.util.Arrays;

public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // N: the length of `arr`
        // time: O(N * log N)
        // space: O(log N), in Java uses quick sort which needs O(log N) space
        Arrays.sort(arr);
        int n = arr.length;
        int delta = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != delta)
                return false;
        }

        return true;
    }
}
