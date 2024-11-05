package LC1523;

public class Solution {
    public int countOdds(int low, int high) {
        // time: O(1)
        // space: O(1)
        int res = (high - low) / 2;

        if (low % 2 == 1 || high % 2 == 1) {
            return res + 1;
        } else {
            return res;
        }
    }
}