package LC2487;

import library.ListNode;

import java.util.Stack;

/**
 * LC 2487. Remove Nodes From Linked List
 */
public class Solution {
    public ListNode removeNodes(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(N)
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek() < cur.val) {
                stack.pop();
            }
            stack.push(cur.val);
            cur = cur.next;
        }

        ListNode prev = new ListNode(-1);
        cur = prev;
        for (int element : stack) {
            cur.next = new ListNode(element);
            cur = cur.next;
        }

        return prev.next;
    }
}
