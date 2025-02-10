package LC3174;

/**
 * LC 3174. Clear Digits
 */
public class Solution2 {
    public String clearDigits(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1), in-place update, avoid to using this method when multi-thread env
        char[] chars = s.toCharArray();
        int replaceIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (replaceIndex > 0) {
                    replaceIndex--;
                }
            } else {
                chars[replaceIndex++] = chars[i];
            }
        }

        return new String(chars, 0, replaceIndex);
    }
}
