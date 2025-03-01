package LC2698;

/**
 * LC 2698. Find the Punishment Number of an Integer
 */
public class Solution2 {
    public int punishmentNumber(int n) {
        // N: the number `n`
        // time: O(N * 2 ^ log N)
        // space: O(log N), recursion stack
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (partitionFound(String.valueOf(square), i)) {
                res += square;
            }
        }

        return res;
    }

    private boolean partitionFound(String s, int target) {
        if (s.isEmpty() && target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        for (int index = 0; index < s.length(); index++) {
            String left = s.substring(0, index + 1);
            String right = s.substring(index + 1);
            int leftNum = Integer.parseInt(left);
            if (partitionFound(right, target - leftNum)) {
                return true;
            }
        }

        return false;
    }
}
