package LC1669;

import library.ListNode;
/**
 * LC 1669. Merge In Between Linked Lists
 */

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;

        for (int i = 0; i < a - 1; i++) {
            start = start.next;
        }

        for (int i = 0; i < b + 1; i++) {
            end = end.next;
        }
        start.next = list2;
        ListNode end2 = list2;
        while (end2.next != null) {
            end2 = end2.next;
        }
        end2.next = end;

        return list1;
    }
}
