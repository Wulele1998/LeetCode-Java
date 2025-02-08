package LC2349;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * LC 2349. Design a Number Container System
 */
public class NumberContainers {
    private final HashMap<Integer, PriorityQueue<Integer>> numToIndices;
    private final HashMap<Integer, Integer> indexToNum;
    public NumberContainers() {
        numToIndices = new HashMap<>();
        indexToNum = new HashMap<>();
    }

    // change operation
    // N: the number of indices
    // time: O(log N), insert the index into priority queue, need to resort the min heap
    public void change(int index, int number) {
        indexToNum.put(index, number);
        numToIndices.computeIfAbsent(number, key -> new PriorityQueue<>()).add(index);
    }

    // find operation
    // time: O(k log N)
    public int find(int number) {
        if (!numToIndices.containsKey(number)) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = numToIndices.get(number);

        while (!minHeap.isEmpty()) {
            if (indexToNum.get(minHeap.peek()) != number) {
                minHeap.poll();
            } else {
                return minHeap.peek();
            }
        }

        return -1;
    }
}
