package LC2816;

import library.ListNode;

/**
 * LC 2816. Double a Number Represented as a Linked List
 */

public class Solution2 {
    public ListNode doubleIt(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        head = reverse(head);
        int cum = 0;
        ListNode res = null;
        while (head != null) {
            int num = head.val * 2 + cum;
            cum = num / 10;
            ListNode temp = new ListNode(num % 10);
            temp.next = res;
            res = temp;
            head = head.next;
        }

        if (cum == 1) {
            ListNode temp = new ListNode(1);
            temp.next = res;
            res = temp;
        }

        return res;
    }

    private ListNode reverse(ListNode head){
        // reverse the linked list
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }

        return pre;
    }
}
