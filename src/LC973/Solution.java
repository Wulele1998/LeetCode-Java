package LC973;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]));
        for (int[] point : points) {
            minHeap.offer(point);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }
}
