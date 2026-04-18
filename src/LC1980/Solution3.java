package LC1980;

public class Solution3 {
    public String findDifferentBinaryString(String[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        StringBuilder sb = new StringBuilder();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            char c = nums[i].charAt(i);
            sb.append(c == '0' ? '1' : '0');
        }

        return sb.toString();
    }
}
