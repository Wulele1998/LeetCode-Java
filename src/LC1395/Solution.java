package LC1395;

import java.util.Arrays;

/**
 * LC 1395. Count Number of Teams
 */
public class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        int[][] increasingCache = new int[n][4];
        int[][] decreasingCache = new int[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(increasingCache[i], -1);
            Arrays.fill(decreasingCache[i], -1);
        }

        for (int i = 0; i < n; i++) {
            res += increasingTeams(rating, i, 1, increasingCache) + decreasingTeams(rating, i, 1, decreasingCache);
        }

        return res;
    }

    private int increasingTeams(int[] rating, int currentIndex, int teamSize, int[][] increasingCache) {
        int n = rating.length;
        if (currentIndex == n) {
            return 0;
        }
        if (teamSize == 3) {
            return 1;
        }

        if (increasingCache[currentIndex][teamSize] != -1) {
            return increasingCache[currentIndex][teamSize];
        }

        int count = 0;
        for (int i = currentIndex + 1; i < n; i++) {
            if (rating[i] > rating[currentIndex]) {
                count += increasingTeams(rating,  i, teamSize + 1, increasingCache);
            }
        }

        increasingCache[currentIndex][teamSize] = count;

        return count;
    }

    private int decreasingTeams(int[] rating, int currentIndex, int teamSize, int[][] decreasingCache) {
        int n = rating.length;
        if (currentIndex == n) {
            return 0;
        }

        if (teamSize == 3) {
            return 1;
        }

        if (decreasingCache[currentIndex][teamSize] != -1) {
            return decreasingCache[currentIndex][teamSize];
        }

        int count = 0;
        for (int i = currentIndex + 1; i < n; i++) {
            if (rating[i] < rating[currentIndex]) {
                count += decreasingTeams(rating, i, teamSize + 1, decreasingCache);
            }
        }

        decreasingCache[currentIndex][teamSize] = count;
        return count;
    }
}
