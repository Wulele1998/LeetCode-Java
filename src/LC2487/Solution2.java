package LC2487;

import library.ListNode;

/**
 * LC 2487. Remove Nodes From Linked List
 */
public class Solution2 {
    public ListNode removeNodes(ListNode head) {
        // recursive
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = removeNodes(head.next);
        if (head.val < nextNode.val) {
            return nextNode;
        }

        head.next = nextNode;
        return head;
    }
}
