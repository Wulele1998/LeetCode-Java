package LC295;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private final Queue<Integer> maxHeap;
    private final Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // maxHeap.size() <= minHeap.size()
        if (maxHeap.size() == minHeap.size()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        if (!maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            int num1 = !minHeap.isEmpty() ? minHeap.peek() : 0;
            int num2 = !maxHeap.isEmpty() ? maxHeap.peek() : 0;
            return (num1 + num2) / 2.0;
        } else {
            return minHeap.peek() * 1.0;
        }
    }
}
