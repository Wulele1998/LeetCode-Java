package LC143;

import library.ListNode;

import java.util.Stack;

/**
 * LC 143. Reorder List
 */
public class Solution {
    public void reorderList(ListNode head) {
        // N: the length of linked list
        // time: O(N)
        // space: O(1)
        ListNode cur = head;
        // get the length of linked list
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        // find the middle node
        cur = head;
        for (int i = 0; i < (n + 1) / 2 - 1; i++) {
            cur = cur.next;
        }
        ListNode end = cur;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        end.next = null;

        ListNode prev = head;
        cur = prev.next;
        while (prev != null && !stack.isEmpty()) {
            ListNode node = stack.pop();
            prev.next = node;
            node.next = cur;
            prev = cur;
            if (prev != null)
                cur = prev.next;
        }
    }
}
