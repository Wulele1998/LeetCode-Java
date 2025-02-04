package LC2575;

public class Solution {
    public int[] divisibilityArray(String word, int m) {
        // N: the length of `word`
        // time: O(N)
        // space: O(1)
        int n = word.length();
        int[] res = new int[n];
        int mod = 0;
        for (int i = 0; i < n; i++) {
            int digit = word.charAt(i) - '0';
            if (i == 0 || res[i - 1] == 1) {
                res[i] = digit % m == 0 ? 1 : 0;
                mod = digit % m;
            } else {
                long num = (long) mod * 10 + digit;
                res[i] = num % m == 0 ? 1 : 0;
                mod = (int) (num % m);
            }
        }

        return res;
    }
}
