package LC1752;

import java.util.LinkedList;

/**
 * LC 1752. Check if Array Is Sorted and Rotated
 */
public class Solution {
    public boolean check(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        LinkedList<Integer> list = new LinkedList<>();
        int index = nums.length - 1;
        if (nums[nums.length - 1] <= nums[0]) {
            list.addFirst(nums[index--]);

            while (index >= 0 && nums[index] <= nums[index + 1]) {
                list.addFirst(nums[index]);
                index--;
            }
        }


        for (int i = 0; i < index; i++) {
            if (nums[i] <= nums[i + 1]) {
                list.add(nums[i]);
            } else {
                return false;
            }
        }

        for (int i = 0; i <  list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
