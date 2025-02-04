package LC2337;

/**
 * LC 2337. Move Pieces to Obtain a String
 */
public class Solution {
    public boolean canChange(String start, String target) {
        // two pointers
        // N: the length of the string
        // O(N)
        // space: O(1)
        int i = 0;
        int j = 0;

        while (i < start.length() || j < target.length()){
            while (i < start.length() && start.charAt(i) == '_') {
                i++;
            }
            while (j < target.length() && target.charAt(j) == '_') {
                j++;
            }
            if (i == start.length() || j == target.length()) {
                return i == start.length() && j == target.length();
            }
            if (start.charAt(i) != target.charAt(j) || (start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) {
                // if equal
                // for L, start string should NOT have L on the left side of the target
                // for R, start string should NOT have R on the right side of the target
                return false;
            }
            i++;
            j++;

        }

        return true;
    }
}
