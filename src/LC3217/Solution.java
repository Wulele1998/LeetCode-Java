package LC3217;


import library.ListNode;
import java.util.HashSet;

/**
 * Nov 1, 2025
 * LC 3217. Delete Nodes From Linked List Present in Array
 */
public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // M: the length of `nums`
        // N: the length of linked list
        // time: O(M + N)
        // space: O(M), the hash set we use to save `nums`

        // we may need to remove head node from the linked list, so create a dummy head instead
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // using a hash set to search if the number exists in the array
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode current = dummyHead;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next; //  remove `current.next` node
            } else {
                // move to next node
                current = current.next;
            }
        }

        return dummyHead.next;
    }
}
