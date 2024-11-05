package LC1894;

/**
 * LC 1894. Find the Student that Will Replace the Chalk
 */
public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // N: the length of `chalk`
        // time: O(N)
        // space: O(1)
        long sum = 0;
        for (int c : chalk) {
            sum += c;
        }

        long left = k % sum;

        for (int i = 0; i < chalk.length; i++) {
            if (left >= chalk[i]) {
                left -= chalk[i];
            } else {
                return i;
            }
        }

        return -1;
    }
}
