package LC19;

import library.ListNode;

/**
 * LC 19. Remove Nth Node From End of List
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // N: the length of linked list
        // time: O(N)
        // space: O(1)

        // get the original length
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        int move = len - n;
        ListNode deaf = new ListNode(-1);
        deaf.next = head;
        ListNode prev = deaf;
        for (int i = 0; i < move; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return deaf.next;
    }
}
