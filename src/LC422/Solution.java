package LC422;

import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        // N: the length of words
        // time: O(N ^ 2)
        // space: O(N)
        int n = words.size();
        
        for (int k = 0; k < n; k++) {
            String row = words.get(k);
            StringBuilder col = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (words.get(i).length() - 1 < k) {
                    col.append("");
                } else {
                    col.append(words.get(i).charAt(k));
                }
            }
            if (!row.equals(col.toString())) {
                return false;
            }
        }
        return true;
    }
}
