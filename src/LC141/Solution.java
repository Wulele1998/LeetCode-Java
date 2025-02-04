package LC141;

import library.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // N: the length of the linked list
        // time: O(N)
        // space: O(1)
        if (head == null) {
            return false;
        }    

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
