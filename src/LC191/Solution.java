package LC191;

public class Solution {
    public int hammingWeight(int n) {
        // time: O(log n)
        // space: O(1)
        int count = 0;
        int base = 1;
        final int MAX = 32;

        for (int i = 0; i < MAX; i++) {
            if ((base & n) != 0) {
                count++;
            }
            base <<= 1;
        }

        return count;
    }
}
