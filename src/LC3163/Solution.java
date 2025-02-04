package LC3163;

/**
 * LC 3163. String Compression III
 */
public class Solution {
    public String compressedString(String word) {
        // N: the length of `word`
        // time: O(N)
        // space: O(N)
        StringBuilder sb = new StringBuilder();

        char c = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == c && count < 9) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                count = 1;
                c = word.charAt(i);
            }
        }

        sb.append(count);
        sb.append(c);

        return sb.toString();
    }
}