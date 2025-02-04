package LC2825;

/**
 * LC 2825. Make String a Subsequence Using Cyclic Increments
 */
public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        // two pointers
        // N: the length of `str1`
        // time: O(N)
        // space: O(1)
        int i = 0;
        int j = 0;


        while (i < str1.length() && j < str2.length()){
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            } else if (str1.charAt(i) + 1 == str2.charAt(j) || str1.charAt(i) + 25 == str2.charAt(j)){
                j++;
            }
            i++;
        }

        return j == str2.length();
    }
}
