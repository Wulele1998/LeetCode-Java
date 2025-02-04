package LC2381;

/**
 * LC 2381. Shifting Letters II
 */
public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // N: the length of `s`
        // M: the length of `shifts`
        // time: O(M + N)
        // space: O(N)
        int n = s.length();
        int[] diff = new int[n];

        for (int[] shift : shifts) {
            if (shift[2] == 0) {
                diff[shift[0]]--;
                if (shift[1] + 1 < n) {
                    diff[shift[1] + 1]++;
                }
            } else {
                diff[shift[0]]++;
                if (shift[1] + 1 < n) {
                    diff[shift[1] + 1]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int move = 0;
        for (int i = 0; i < n; i++) {
            move = (move + diff[i]) % 26;
            move = move < 0 ? move + 26 : move;
            sb.append((char)((s.charAt(i) - 'a' + move) % 26 + 'a'));
        }

        return sb.toString();
    }
}
