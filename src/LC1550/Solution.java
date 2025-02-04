package LC1550;

/**
 * LC 1550. Three Consecutive Odds
 */
public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // N: the length of `arr`
        // time: O(N)
        // space: O(1)
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
