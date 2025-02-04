package LC2961;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        // N: the number of `variables`
        // M: the number of iteration
        // time: O(N * M)
        // space: O(N)
        List<Integer> res = new ArrayList<>();

        for (int index = 0; index < variables.length; index++) {
            int[] var = variables[index];
            int num = 1;
            for (int i = 0; i < var[1]; i++) {
                num = num * var[0] % 10;
            }
            int num2 = 1;
            for (int i = 0; i < var[2]; i++) {
                num2 = num2 * num % var[3];
            }

            if (num2 == target)
                res.add(index);
        }
        
        return res;
    }
}
