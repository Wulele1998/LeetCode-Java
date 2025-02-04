package LC206;

import library.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        // N: the length of linkedlist
        // time: O(N)
        // space: O(1)
        if (head == null) 
            return null;
        
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
