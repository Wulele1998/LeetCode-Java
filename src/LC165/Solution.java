package LC165;

/**
 * LC 165. Compare Version Numbers
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        // M: the length of `version1`
        // N: the length of `version2`
        // time: O(M + N + Max(M, N))
        // space: O(M + N)
        String[] v1 = version1.split("\\.");
        String[] v2 = version1.split("\\.");

        int i = 0;
        int j = 0;
        while (i < v1.length || j < v2.length) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = j < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            } else {
                i++;
                j++;
            }
        }

        return 0;
    }
}
