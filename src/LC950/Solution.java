package LC950;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * LC 950. Reveal Cards In Increasing Order
 */
public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // N: the length of `deck`
        // time: O(N * log N)
        // space: O(N + log N)
        int n = deck.length;
        int[] res = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        Arrays.sort(deck);

        for (int i = 0; i < n; i++) {
            res[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }

        return res;
    }
}
