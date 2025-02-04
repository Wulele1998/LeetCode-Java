package LC1367;

import library.ListNode;
import library.TreeNode;
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // N: the number of nodes in the tree
        // H: the height of tree
        // M: the length of list
        // time: O(N * min(H, M))
        // space: O(H) => recursive stack
        // corner case
        if (root == null) {
            return false;
        }
        if (head == null) {
            return true;
        }

        if (root.val == head.val) {
            // continue searching downwards
            if (searchPath(head, root)) {
                return true;
            }
        }

        // try left subtree or right subtree
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean searchPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }

        return searchPath(head.next, root.left) || searchPath(head.next, root.right);
    }
}
