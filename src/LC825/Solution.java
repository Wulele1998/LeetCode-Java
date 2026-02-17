package LC825;

/**
 * LC 825. Friends Of Appropriate Ages
 */
public class Solution {
    public int numFriendRequests(int[] ages) {
        // N: the length of `ages`
        // time: O(N)
        // space: O(1)
        int res = 0;
        int[] counts = new int[121];

        for (int age : ages) {
            counts[age]++;
        }

        for (int i = 1; i <= 120; i++) {
            for (int j = 1; j <= 120; j++) {
                if (i * 0.5 + 7 >= j) {
                    continue;
                }
                if (i < j) {
                    continue;
                }
                if (j > 100 & i < 100) {
                    continue;
                }
                res += counts[i] * counts[j];
                if (i == j) {
                    res -= counts[i];
                }
            }
        }

        return res;
    }
}
