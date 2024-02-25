package LC661;

public class Solution {
    public int[][] imageSmoother(int[][] img) {
        // M: the number of row
        // N: the number of column
        // time: O(M * N)
        // space: O(M * N)
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                int sum = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int row = i + k;
                        int col = j + l;
                        if (row >= 0 && row < m && col >= 0 && col < n) {
                            count++;
                            sum += img[row][col];
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }

        return res;
    }
}