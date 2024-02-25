package LC1428;

import library.BinaryMatrix;

public class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // M: the number of row
        // N: the number of col
        // time: O(M * log N)
        // space: O(1)
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int res = col;

        // binary search
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (binaryMatrix.get(i, mid) == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (binaryMatrix.get(i, left) == 1)
                res = Math.min(res, i);
        }

        return res == col ? -1 : res;
    }
}
