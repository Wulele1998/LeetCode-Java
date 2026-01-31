package LC1653;

/**
 * LC 1653. Minimum Deletions to Make String Balanced
 */
public class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countArrayA = new int[n];
        int[] countArrayB = new int[n];

        int countA = 0;
        int countB = 0;
        for (int i = 0; i < n; i++) {
            countArrayB[i] = countB;
            if (s.charAt(i) == 'b') {
                countB++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            countArrayA[i] = countA;
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }

        int res = n;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, countArrayA[i] + countArrayB[i]);
        }

        return n;
    }
}
