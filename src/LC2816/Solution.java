package LC2816;

import library.ListNode;

import java.util.Stack;

/**
 * LC 2816. Double a Number Represented as a Linked List
 */
public class Solution {
    public ListNode doubleIt(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode res = null;
        int cum = 0;
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            int num = digit * 2 + cum;
            cum = num / 10;
            ListNode temp = new ListNode(num % 10);
            temp.next = res;
            res = temp;
        }

        if (cum == 1) {
            ListNode temp = new ListNode(1);
            temp.next = res;
            res = temp;
        }

        return res;
    }
}
