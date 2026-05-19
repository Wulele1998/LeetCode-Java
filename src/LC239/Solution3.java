package LC239;

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

public class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Mono Deque
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> resList = new ArrayList<>();
        // Deque saves the current maximum number index
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast(); // only keep the largest number index at deque
            }
            dq.offer(i);
        }
        resList.add(nums[dq.peekFirst()]);

        // sliding window
        for (int i = k; i < nums.length; i++) {
            // we will remove the nums[i - k] since it is not included in the window
            // check if current [i - k] is the largest number in previous window
            if (i - k == dq.peekFirst()) {
                dq.pollFirst();
            }
            // remove all smaller numbers index (in the window) from the deque
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast(); // only keep the largest number index at deque
            }
            dq.offer(i);

            resList.add(nums[dq.peekFirst()]);
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }
}
