package LC1717;

/**
 * LC 1717. Maximum Score From Removing Substrings
 */
public class Solution2 {
    public int maximumGain(String s, int x, int y) {
        // "ab" => x
        // "ba" => y
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        String higher = x >= y ? "ab" : "ba";
        int maxScore = Math.max(x, y);
        int minScore = Math.min(x, y);
        int count0 = 0;
        int count1 = 0;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == higher.charAt(0)) {
                count0++;
            } else if (c == higher.charAt(1)) {
                if (count0 > 0) { // higher string has priorioty
                    res += maxScore; // match the higher first
                    count0--;
                } else {
                    count1++;
                }
            }  else {
                // not a or b
                res += Math.min(count0, count1) * minScore;
                count0 = 0;
                count1 = 0;
            }
        }

        return res + Math.min(count0, count1) * minScore;
    }
}
