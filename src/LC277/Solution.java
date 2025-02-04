package LC277;

/**
 * LC 277. Find the Celebrity
 */
public class Solution {
    public int findCelebrity(int n) {
        // brute force
        // time: O(N ^ 2)
        // space: O(N)
        int[] graph = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    graph[i]--;
                    graph[j]++;
                }
            }
        }

        int count = 0;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (graph[i] == n - 1) {
                count++;
                res = i;
            }
        }
        return count == 1 ? res : -1;
    }

    private boolean knows(int a, int b) {
        return Math.abs(a - b) % 2 == 0;
    }
}
