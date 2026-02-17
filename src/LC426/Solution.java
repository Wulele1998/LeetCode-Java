package LC426;

import library.TreeNode;

/**
 * LC 426. Convert Binary Search Tree to Sorted Doubly Linked List
 */
public class Solution {
    TreeNode head;
    TreeNode tail;
    public TreeNode treeToDoublyList(TreeNode root) {
        head = null;
        tail = null;

        DFS(root);

        head.left = tail;
        tail.right = head;

        return head;
    }

    private void DFS(TreeNode node) {
        if (node == null) {
            return;
        }

        DFS(node.left);

        if (head == null) {
            head = node; // find the leftmost tree node as the head, the minimum value in the BST
        }
        if (tail == null) {
            tail = node;
        } else {
            // tail is smaller than node
            tail.right = node;
            node.left = tail;
            tail = tail.right; // update the tail node
        }

        DFS(node.right);
    }
}

