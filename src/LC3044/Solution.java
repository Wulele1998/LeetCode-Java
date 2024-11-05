package LC3044;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3044. Most Frequent Prime
 */
public class Solution {
    public int mostFrequentPrime(int[][] mat) {
        // M: the number of rows
        // N: the number of column
        // time: O(M * N * MAX(M, N))
        // space: O(N)
        int m = mat.length;
        int n = mat[0].length;
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] direction : directions) {
                    int x = i;
                    int y = j;
                    StringBuilder sb = new StringBuilder();
                    while (x >= 0 && x < m && y >= 0 && y < n) {
                        sb.append(mat[x][y]);
                        x += direction[0];
                        y += direction[1];
                        int num = Integer.parseInt(sb.toString());
                        if (num <= 10)
                            continue;
                        if (map.containsKey(num)) {
                            map.put(num, map.get(num) + 1);
                        } else {
                            if (isPrime(num)) {
                                map.put(num, 1);
                            }
                        }
                    }

                }
            }
        }
        int max = 0;
        int num = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max || (entry.getValue() == max && entry.getKey() > num)) {
                num = entry.getKey();
                max = entry.getValue();
            }
        }

        return num;
    }

    private boolean isPrime(int n) {
        int maxSqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= maxSqrt; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
