package LC422;

import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        // N: the length of words
        // time: O(N ^ 2)
        // space: O(N)
        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (words.get(i).length() > n) {
                return false;
            }

            for (int j = 0; j < n; j++) {
                char c1 = j < words.get(i).length() ? words.get(i).charAt(j) : ' ';
                char c2 = i < words.get(j).length() ? words.get(j).charAt(i) : ' ';
                if (c1 != c2) {
                    return false;
                }
            }
        }

        return true;
    }
}
