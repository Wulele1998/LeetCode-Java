package LC2661;

import java.util.HashMap;

/**
 * LC 2661. First Completely Painted Row or Column
 */
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // time: O(M * N)
        // space: O(M * N)
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }

        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];

        for (int i = 0; i < arr.length; i++) {
            int[] pos = map.get(arr[i]);
            rowCount[pos[0]]++;
            colCount[pos[1]]++;
            if (rowCount[pos[0]] == mat[0].length || colCount[pos[1]] == mat.length) {
                return i;
            }
        }

        return arr.length - 1;
    }
}
