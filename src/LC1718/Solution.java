package LC1718;

public class Solution {
    public int[] constructDistancedSequence(int n) {
        // N: the number n
        // time: O(N!)
        // space: O(N), backtrack stack
        int[] res = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1]; // [1, n]
        backtrackHelper(res, used, 0, n);

        return res;
    }

    private boolean backtrackHelper(int[] res, boolean[] used, int curIndex, int n) {
        if (curIndex == res.length) {
            // has filled the res array successfully
            return true;
        }
        if (res[curIndex] != 0) {
            // keep going
            return backtrackHelper(res, used, curIndex + 1, n);
        }
        // res[curIndex] is empty, waiting to be filled
        // make it larger as possible, start traverse from the end to the start
        for (int i = n; i >= 1; i--) {
            if (!used[i]) {
                res[curIndex] = i;
                used[i] = true;
                if (i == 1) {
                    if (backtrackHelper(res, used, curIndex + 1, n)) {
                        return true;
                    }
                } else {
                    if (i + curIndex < res.length && res[i + curIndex] == 0) {
                        res[curIndex + i] = i;
                        if (backtrackHelper(res, used, curIndex + 1, n)) {
                            return true;
                        } else {
                            // undo the operation
                            res[curIndex + i] = 0;
                        }
                    }
                }

                // undo the operation
                res[curIndex] = 0;
                used[i] = false;
            }
        }

        return false;
    }
}
