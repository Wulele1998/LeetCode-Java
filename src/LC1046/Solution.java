package LC1046;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() >= 2) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
