package LC1481;

import java.util.*;

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);

        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
            if (sum > k) {
                return values.size() - i;
            }
        }

        return 0;
    }
}
