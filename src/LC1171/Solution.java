package LC1171;

import library.ListNode;

/**
 * LC 1171. Remove Zero Sum Consecutive Nodes from Linked List
 */
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // N: the length of the linked list
        // time: O(N ^ 2)
        // space: O(1)
        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy;

        while (start != null) {
            int sum = 0;
            ListNode end = start.next;
            while (end != null) {
                sum += end.val;
                if (sum == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }

            start = start.next;
        }

        return dummy.next;
    }
}
