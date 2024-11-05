package LC445;

import java.util.Stack;

import library.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // M: the length of `l1`
        // N: the length of `l2`
        // Time: O(max(M, N))
        // space: O(M + N)
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        Stack<Integer> res = new Stack<>();
        int carry = 0;
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                num2.push(l2.val);
                l2 = l2.next;
            }
        }

        while (!num1.isEmpty() || !num2.isEmpty()) {
            int digit1 = num1.isEmpty() ? 0 : num1.pop();
            int digit2 = num2.isEmpty() ? 0 : num2.pop();
            int sum = digit1 + digit2 + carry;
            res.push(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0)
            res.push(carry);

        while (!res.isEmpty()) {
            cur.next = new ListNode(res.pop());
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
