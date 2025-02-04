package LC2225;

import java.util.*;


public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // N: the length of `matches`
        // time: O(N * log N)
        // space: O(N)
        Set<Integer> winners = new HashSet<>();
        Map<Integer, Integer> losers = new HashMap<>();
        List<Integer> winnersRes = new ArrayList<>();
        List<Integer> losersRes = new ArrayList<>();

        for (int[] match : matches) {
            winners.add(match[0]);
            losers.put(match[1], losers.getOrDefault(match[1], 0) + 1);
        }

        for (int winner : winners) {
            if (!losers.containsKey(winner))
                winnersRes.add(winner);
        }

        for (Map.Entry<Integer, Integer> entry : losers.entrySet()) {
            if (entry.getValue() == 1)
                losersRes.add(entry.getKey());
        }

        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(winnersRes);
        Collections.sort(losersRes);
        res.add(winnersRes);
        res.add(losersRes);

        return res;
    }
}
