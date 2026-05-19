package LC84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        // monotonic stack, save the index
        // stack should be always in height increasing order
        // time: O(N)
        // space: O(N)
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                // calculate the area can be constructed
                int curIndex = stack.pop();
                int curHeight = heights[curIndex];
                int leftIndex = stack.isEmpty() ? 0 : stack.peek() + 1;
                int rightIndex = i - 1;
                // width: [leftIndex, rightIndex]
                maxArea = Math.max(maxArea, curHeight * (rightIndex - leftIndex + 1));
            }

            stack.push(i);
        }
        // all indices left in the monotonic stack are in height increasing order
        while (!stack.isEmpty()) {
            int curIndex = stack.pop();
            int curHeight = heights[curIndex];
            int leftIndex = stack.isEmpty() ? 0 : stack.peek() + 1;
            int rightIndex = n - 1;
            maxArea = Math.max(maxArea, curHeight * (rightIndex - leftIndex + 1));
        }

        return maxArea;
    }
}
