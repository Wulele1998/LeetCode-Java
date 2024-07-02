package LC237;

import library.ListNode;

/**
 * LC 237. Delete Node in a Linked List
 */

public class Solution {
    public void deleteNode(ListNode node) {
        // time: O(1)
        // space: O(1)
        // copy the next node val
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
