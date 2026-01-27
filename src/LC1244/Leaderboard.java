package LC1244;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LC 1244. Design A Leaderboard
 */
public class Leaderboard {
    HashMap<Integer, Integer> playerMap;
    public Leaderboard() {
        playerMap = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (playerMap.containsKey(playerId)) {
            playerMap.put(playerId, playerMap.get(playerId) + score);
        } else {
            playerMap.put(playerId, score);
        }
    }

    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue()
        );

        maxHeap.addAll(playerMap.entrySet());

        int sum = 0;
        while (!maxHeap.isEmpty() && K > 0) {
            sum += maxHeap.poll().getValue();
        }

        return sum;
    }

    public void reset(int playerId) {
        playerMap.put(playerId, 0);
    }
}
