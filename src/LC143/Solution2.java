package LC143;

import library.ListNode;

/**
 * LC 143. Reorder List
 */
public class Solution2 {
    public void reorderList(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(1)
        // find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        ListNode first = head;
        ListNode second = prev;
        while (first != null && second.next != null) {
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
