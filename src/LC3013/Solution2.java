package LC3013;

import java.util.TreeSet;

/**
 * Feb 2, 2026
 * LC 3013. Divide an Array Into Subarrays With Minimum Cost II
 */
public class Solution2 {
    public long minimumCost(int[] nums, int k, int dist) {
        long res = Long.MAX_VALUE;
        int n = nums.length;
        long windowSum = 0L;
        TreeSet<Integer> using = new TreeSet<>((o1, o2) -> {
            return nums[o1] == nums[o2] ? o1 - o2 : nums[o1] - nums[o2];
        });
        TreeSet<Integer> waiting = new TreeSet<>((o1, o2) -> {
            return nums[o1] == nums[o2] ? o1 - o2 : nums[o1] - nums[o2];
        });

        // initialize the window
        for (int i = 1; i <= dist + 1; i++) {
            using.add(i);
            windowSum += nums[i];
        }

        // we only need k - 1 elements
        while (using.size() > k - 1) {
            int index = using.pollLast(); // remove the largest elements
            windowSum -= nums[index];
            waiting.add(index);
        }

        res = Math.min(res, windowSum);

        // start sliding window
        for (int i = 2; i + dist < n; i++) {
            waiting.add(i + dist);
            if (using.contains(i - 1)) {
                using.remove(i - 1);
                int index = waiting.pollFirst();
                using.add(index);
                windowSum = windowSum - nums[i - 1] + nums[index];
            } else {
                waiting.remove(i - 1);
                int indexWaiting = waiting.pollFirst();
                int indexUsing  = using.pollLast();
                if (nums[indexWaiting] < nums[indexUsing]) {
                    using.add(indexWaiting);
                    waiting.add(indexUsing);
                    windowSum = windowSum - nums[indexUsing] + nums[indexWaiting];
                } else {
                    // put back, no changes on the windowSum
                    using.add(indexUsing);
                    waiting.add(indexWaiting);
                }
            }

            res = Math.min(res, windowSum);
        }

        return res + nums[0];
    }
}
