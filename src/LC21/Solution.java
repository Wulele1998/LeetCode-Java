package LC21;

import library.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // M: the length of `list1`
        // N: the length of `list2`
        // time: O(M + N)
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val > list2.val) {
                    cur.next = list2;
                    list2 = list2.next;
                } else {
                    cur.next = list1;
                    list1 = list1.next;
                }
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
