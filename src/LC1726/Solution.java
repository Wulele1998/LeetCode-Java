package LC1726;

import java.util.HashMap;

/**
 * LC 1726. Tuple with Same Product
 */
public class Solution {
    public int tupleSameProduct(int[] nums) {
        // N: the length of `nums`
        // time: O(N ^ 2)
        // space: O(N), HashMap
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> productMap = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }

        for (HashMap.Entry<Integer, Integer> entry : productMap.entrySet()) {
            int val = entry.getValue();
            if (val >= 2) {
                res += val * (val - 1) / 2 * 8;
            }
        }

        return res;
    }
}
