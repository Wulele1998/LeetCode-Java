package LC3063;

import library.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3063. Linked List Frequency
 */
public class Solution {
    public ListNode frequenciesOfElements(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null) {
            if (!map.containsKey(head.val)) {
                cur.next = new ListNode(1);
                cur = cur.next;
                map.put(head.val, cur);
            } else {
                ListNode node = map.get(head.val);
                node.val++;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
