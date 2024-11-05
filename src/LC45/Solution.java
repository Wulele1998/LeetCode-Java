package LC45;

public class Solution {
    public int jump(int[] nums) {
        // Dynamic Programming
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int n = nums.length;

        int curMaxDis = 0;
        int times = 0;
        int curDis = 0;

        // can reach nums[n-1]
        for (int i = 0; i < n - 1; i++) {
            curMaxDis = Math.max(curMaxDis, i + nums[i]);
            if (i == curDis) {
                times++;
                curDis = curMaxDis;
            }
        }

        return times;
    }
}
