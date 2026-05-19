package LC853;

import java.util.Stack;
import java.util.Arrays;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // the size of car fleet depends on the arrive time
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (o1, o2) -> o2[0] - o1[0]); // from closer to further (target)
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) * 1.0 / cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
