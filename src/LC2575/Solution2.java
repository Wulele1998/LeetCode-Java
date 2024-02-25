package LC2575;

public class Solution2 {
    public int[] divisibilityArray(String word, int m) {
        // N: the length of `word`
        // time: O(N)
        // space: O(1)
        int n = word.length();
        int[] res = new int[n];
        long mod = 0L;

        for (int i = 0; i < n; i++) {
            mod = (mod * 10 + (word.charAt(i) - '0')) % m;
            res[i] = mod == 0 ? 1 : 0;
        }

        return res;
    }
}
