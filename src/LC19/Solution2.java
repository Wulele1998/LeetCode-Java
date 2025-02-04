package LC19;

import library.ListNode;

/**
 * LC 19. Remove Nth Node From End of List
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // two pointers
        // N: the length of linked list
        // time: O(N)
        // space: O(1)

        // use dummy node in the case remove the head node
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
