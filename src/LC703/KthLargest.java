package LC703;

import java.util.PriorityQueue;
/**
 * LC 703. Kth Largest Element in a Stream
 */
public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        return minHeap.peek();
    }
}
