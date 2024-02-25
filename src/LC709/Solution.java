package LC709;

public class Solution {
    public String toLowerCase(String s) {
        // N: the length of `S`
        // time: O(N)
        // space: O(1)
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return String.valueOf(chars);
    }
}
