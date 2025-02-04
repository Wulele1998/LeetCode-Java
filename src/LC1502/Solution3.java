package LC1502;

public class Solution3 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // use a boolean array instead of HashSet can be faster
        // N: the length of `arr`
        // time: O(N)
        // space: O(N)
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        int n = arr.length;

        for (int num : arr) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        if ((maxNum - minNum) % (n - 1) != 0)
            return false;

        if (maxNum == minNum)
            return true;

        boolean[] visited = new boolean[n];
        int diff = (maxNum - minNum) / (n - 1);

        // attention: diff cannot be zero
        // divisor cannot be zero
        for (int num : arr) {
            // make sure the number is divisible
            if ((num - minNum) % diff != 0)
                return false;
            int index = (num - minNum) / diff;
            if (visited[index])
                return false;
            visited[index] = true;
        }

        return true;
    }
}
