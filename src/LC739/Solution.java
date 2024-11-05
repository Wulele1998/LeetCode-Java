package LC739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // N: the length of `temperatures`
        // time: O(N)
        // space: O(N)
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }

        return res;
    }
}
