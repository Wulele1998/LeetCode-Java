package LC6;

public class Solution {
    public String convert(String s, int numRows) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        // corner case
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        StringBuilder res = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int i = row;
            if (row == 0 || row == numRows - 1) {
                // the first and the last row
                while (i < n) {
                    res.append(s.charAt(i));
                    i += 2 * (numRows - 1);
                }
            } else {
                // other row
                while (i < n) {
                    res.append(s.charAt(i));
                    i += 2 * (numRows - 1 - row);
                    if (i < n) {
                        res.append(s.charAt(i));
                    }
                    i += 2 * row;
                }
            }
        }

        return res.toString();
    }
}
