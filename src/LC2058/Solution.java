package LC2058;

import java.util.ArrayList;
import java.util.List;

import library.ListNode;

public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        List<Integer> indices = new ArrayList<>();   
        ListNode cur = head;
        int i = 0;
        ListNode prev = null;
        while (cur != null && cur.next != null) {
            if (prev != null && cur.next != null) {
                if ((cur.val > prev.val && cur.val > cur.next.val) || (cur.val < prev.val && cur.val < cur.next.val)) {
                    indices.add(i);
                }
            }
            prev = cur;
            cur = cur.next;
            i++;
        }
        
        if (indices.size() < 2) {
            return new int[] { -1, -1 };
        }

        int maxDis = indices.get(indices.size() - 1) - indices.get(0);
        int minDis = maxDis;

        for (int j = 0; j < indices.size() - 1; j++) {
            minDis = Math.min(minDis, indices.get(j + 1) - indices.get(j));
        }

        return new int[] { minDis, maxDis };
    }
}
