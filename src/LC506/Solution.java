package LC506;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        // N: the length of `score`
        // time: O(N * logN)
        // space: O(logN + N)
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            indexMap.put(score[i], i);
        }

        int[] copyScore = new int[score.length];
        System.arraycopy(score, 0, copyScore, 0, score.length);
        Arrays.sort(copyScore);

        String[] res = new String[score.length];
        for (int i = score.length - 1; i >= 0; i--) {
            int rank = score.length - i;
            if (rank == 1) {
                res[indexMap.get(copyScore[i])] = "Gold Medal";
            } else if (rank == 2) {
                res[indexMap.get(copyScore[i])] = "Silver Medal";
            } else if (rank == 3) {
                res[indexMap.get(copyScore[i])] = "Bronze Medal";
            } else {
                res[indexMap.get(copyScore[i])] = String.valueOf(rank);
            }
        }

        return res;
    }
}
