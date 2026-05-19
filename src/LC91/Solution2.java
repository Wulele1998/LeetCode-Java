package LC91;

import java.util.Arrays;

public class Solution2 {
    private int[] memo; // memo[i]: the number of decode ways of s[i:]
    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);

        return topDownDPHelper(s, 0);
    }


    private int topDownDPHelper(String s, int index) {
        // base case
        if (index == s.length()) {
            return 1;
        }

        if (memo[index] != -1)
            return memo[index];

        if (s.charAt(index) == '0') {
            return memo[index] = 0;
        }

        int count = topDownDPHelper(s, index + 1);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            count += topDownDPHelper(s, index + 2);
        }

        return memo[index] = count;
    }
}
