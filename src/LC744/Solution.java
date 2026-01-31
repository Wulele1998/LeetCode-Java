package LC744;

/**
 * Jan 31, 2026
 * LC 744. Find Smallest Letter Greater Than Target
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // N: the length of `letters`
        // time: O(log N)
        // space: O(1)
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}
