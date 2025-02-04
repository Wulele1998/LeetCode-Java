package LC3042;

/**
 * LC 3042. Count Prefix and Suffix Pairs I
 */
public class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        // N: the length of `words`
        // time: O(N ^ 2)
        // space: O(1)
        int n = words.length;
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            String str1 = words[i];
            for (int j = i + 1; j < n; j++) {
                String str2 = words[j];
                if (str2.startsWith(str1) && str2.endsWith(str1)) {
                    res++;
                }
            }
        }

        return res;
    }
}
