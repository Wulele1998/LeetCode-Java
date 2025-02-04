package LC1750;

/**
 * LC 1750. Minimum Length of String After Deleting Similar Ends
 */
public class Solution {
    public int minimumLength(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
            while (left <= right && s.charAt(left) == s.charAt(left - 1)) {
                left++;
            }
            while (left <= right && s.charAt(right) == s.charAt(right + 1)) {
                right--;
            }
           
        }

        return right - left + 1;
    }
}
