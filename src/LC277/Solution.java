package LC277;

public class Solution {
    public int findCelebrity(int n) {
        // time: O(N ^ 2)
        // space: O(N)
        // brute force
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
