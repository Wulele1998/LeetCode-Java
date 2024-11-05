package LC997;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        // M: the length of `trust`
        // time: O(M)
        // space: O(N)
        int[] people = new int[n + 1];
        for (int[] t : trust) {
            people[t[0]]--;
            people[t[1]]++;
        }

        int count = 0;
        int res = -1;
        for (int i = 1; i <= n; i++) {
            if (people[i] == n - 1) {
                count++;
                res = i;
            }
        }

        return count == 1 ? res : -1;
    }
}
