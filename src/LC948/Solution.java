package LC948;

import java.util.Arrays;

/**
 * LC 948. Bag of Tokens
 */
public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // N: the length of `tokens`
        // time: O(N * log N)
        // space: O(log N)
        Arrays.sort(tokens);
        int score = 0;
        int res = 0;

        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
            } else {
                if (score == 0) {
                    return 0;
                } else {
                    power += tokens[right];
                    score--;
                    right--;
                }
            }
            res = Math.max(score, res);
        }

        return res;
    }
}
