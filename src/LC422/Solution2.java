package LC422;

import java.util.List;

public class Solution2 {
    public boolean validWordSquare(List<String> words) {
        // N: Max(the length of words, the max length of each word)
        // time: O(N ^ 2)
        // space: O()
        int n = words.size();
        int maxLen = n;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        byte[][] mat = new byte[maxLen][maxLen];

        for (int i = 0; i < n; i++) {
            char[] chars = words.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                mat[i][j] = (byte) chars[j];
            }
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = i + 1; j < maxLen; j++) {
                if (mat[i][j] != mat[j][i])
                    return false;
            }
        }

        return true;
    }
}
