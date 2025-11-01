package LC1290;

import library.ListNode;

/**
 * LC 1290. Convert Binary Number in a Linked List to Integer
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(1)
        int sum = 0;
        while (head != null) {
            sum <<= 1;
            sum += head.val;
            head = head.next;
        }

        return sum;
    }
}
