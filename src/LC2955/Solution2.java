package LC2955;

/**
 * LC 2955. Number of Same-End Substrings
 */
public class Solution2 {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        int[][] prefix = new int[26][0];
        int[] res = new int[m];


        for (int i = 0; i < n; i++) {
            prefix[s.charAt(i) - 'a'][i]++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < n; j++) {
                prefix[i][j] += prefix[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int sum = 0;

            // go through each letter
            for (int j = 0; j < 26; j++) {
                int freqDiff = prefix[j][end] - (start == 0 ? 0 : prefix[j][start - 1]);
                sum += freqDiff * (freqDiff + 1) / 2;
            }

            res[i] = sum;
        }

        return res;
    }
}
