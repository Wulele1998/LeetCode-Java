package LC2483;

/**
 * Dec 26, 2025
 * LC 2483. Minimum Penalty for a Shop
 */
public class Solution {
    public int bestClosingTime(String customers) {
        // N: the length of `customers`
        // time: O(N)
        // space: O(1)
        int penalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestTime = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestTime = i + 1;
            }
        }

        return bestTime;
    }
}
