package LC42;

import java.util.Stack;

public class Solution2 {
    public int trap(int[] height) {
        // time: O(N)
        // mono stack
        // most of cases, mono stack stores the index
        Stack<Integer> monoStack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!monoStack.isEmpty() && height[i] > height[monoStack.peek()]) {
                // we found the possible water here
                // the water right index is i, and we need to know the left index
                int lowerIndex = monoStack.pop();
                if (!monoStack.isEmpty()) {
                    int leftIndex = monoStack.peek();
                    int waterWidth = i - leftIndex - 1; // (leftIndex, i)
                    int waterHeight = Math.min(height[i], height[leftIndex]) - height[lowerIndex];
                    water += waterHeight * waterWidth;
                }
            }
            monoStack.push(i);
        }

        return water;
    }
}
