package LC2678;

/**
 * LC 2678. Number of Senior Citizens
 */
public class Solution {
    public int countSeniors(String[] details) {
        // time: O(N)
        // space: O(1)
        int count = 0;

        for (String detail : details) {
            String age = detail.substring(11, 13);
            if (Integer.parseInt(age) > 60) {
                count++;
            }
        }

        return count;
    }
}
