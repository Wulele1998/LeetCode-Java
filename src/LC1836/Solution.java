package LC1836;

import library.ListNode;

import java.util.HashMap;

/**
 * LC 1836. Remove Duplicates From an Unsorted Linked List
 */
public class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        ListNode blind = new ListNode(-1);
        blind.next = head;
        ListNode prev = blind;
        cur = head;
        while (cur != null) {
            if (map.get(cur.val) > 1) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

        return blind.next;
    }
}
