package LC2566;

import java.util.Stack;

public class Solution {
    public int minMaxDifference(int num) {
        // N: the number of digits in `num`
        // time: O(N)
        // space: O(N)
        Stack<Integer> stack = new Stack<>();

        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }

        int n = stack.size();
        int[] digitsMax = new int[n];
        int[] digitsMin = new int[n];
        int index = 0;
        int flagMax = -1;
        int flagMin = -1;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur < 9 && flagMax == -1) {
                flagMax = cur;
            }
            if (cur > 0 && flagMin == -1) {
                flagMin = cur;
            }
            if (cur == flagMax) {
                digitsMax[index] = 9;
            } else {
                digitsMax[index] = cur;
            }
            if (cur == flagMin) {
                digitsMin[index] = 0;
            } else {
                digitsMin[index] = cur;
            }
            index++;
        }

        int resMax = 0;
        int resMin = 0;
        int base = 1;
        for (int i = n - 1; i >= 0; i--) {
            resMax += base * digitsMax[i];
            resMin += base * digitsMin[i];
            base *= 10;
        }

        return resMax - resMin;
    }
}
