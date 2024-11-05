package LC876;

import library.ListNode;

/**
 * LC 876. Middle of the Linked List
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        // two pointers
        // N: the length of linked list
        // time: O(N)
        // space: O(1)
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
