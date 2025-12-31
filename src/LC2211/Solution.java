package LC2211;

import java.util.Stack;

/**
 * Dec 4, 2025
 * LC 2211. Count Collisions on a Road
 */
public class Solution {
    public int countCollisions(String directions) {
        // use stack
        // N: the length of `directions`
        // time: O(N)
        // space: O(N), use the stack
        int res = 0;
        int countR = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : directions.toCharArray()) {
            if (c == 'L') {
                if (!stack.isEmpty()) {
                    if (stack.peek() == 'R') {
                        res += countR + 1; // first R has 2 collisions, other R has 1 collision
                        countR = 0; // no active R anymore
                    } else if (stack.peek() == 'S') {
                        res++;
                    }
                }
            } else if (c == 'R') {
                stack.push(c);
                countR++;
            } else {
                stack.push(c);
                res += countR; // each active R has 1 collision
                countR = 0;
            }
        }

        return res;
    }
}
