package LC2483;

public class Solution2 {
    public int bestClosingTime(String customers) {
        // N: the length of `customers`
        // time: O(N)
        // space: O(1)
        // one pass
        int penalty = 0;
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
