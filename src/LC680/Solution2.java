package LC680;

public class Solution2 {
    public boolean validPalindrome(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        return isPalindrome(s, 0, s.length() - 1, 1);
    }

    private boolean isPalindrome(String s, int left, int right, int lives) {
        if (lives < 0) {
            return false;
        }

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right, lives - 1) || isPalindrome(s, left, right - 1, lives - 1);
            }
        }

        return true;
    }
}
