package LC2487;

import library.ListNode;

/**
 * LC 2487. Remove Nodes From Linked List
 */

public class Solution3 {
    public ListNode removeNodes(ListNode head) {
        // two-time reverse
        head = reverse(head);
        int max = 0;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            max = Math.max(max, cur.val);
            if (cur.val < max) {
                // remove current node
                prev.next = cur.next;
                ListNode removeTemp = cur;
                cur = cur.next;
                removeTemp.next = null;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }

        return prev;
    }
}
