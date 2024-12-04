package LC277;

/**
 * LC 277. Find the Celebrity
 */
public class Solution2 {
    public int findCelebrity(int n) {
        // time: O(N)
        // space: O(1)
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // if candidate knows i, it cannot be candidate
            if (knows(candidate, i)) {
                // update the candidate
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == candidate)
                continue;
            if (knows(candidate, i) || !knows(i, candidate))
                return -1;
        }

        return candidate;
    }

    private boolean knows(int a, int b) {
        return Math.abs(a - b) % 2 == 0;
    }
}
