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
        String[] v2 = version2.split("\\.");

        int subV1;
        int subV2;
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            subV1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            subV2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (subV1 > subV2) {
                return 1;
            } else if (subV1 < subV2) {
                return -1;
            }
        }

        return 0;
    }
}
