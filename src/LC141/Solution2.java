package LC141;

import java.util.HashSet;
import java.util.Set;

import library.ListNode;

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        Set<ListNode> set = new HashSet<>();
        
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }

            set.add(head);
        }

        return false;
    }
}
