package LC951;

import library.TreeNode;

import java.util.Stack;

/**
 * LC 951. Flip Equivalent Binary Trees
 */
public class Solution2 {
    public boolean checkNodeValues(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;

        return node1.val == node2.val;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // N: the number of node in the tree
        // time: O(N)
        // space: O(N)

        // node pairs stack
        Stack<TreeNode[]> stack = new Stack<>();
        // use stack to start DFS
        stack.push(new TreeNode[] {root1, root2});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            if (checkNodeValues(node1.left, node2.left) && checkNodeValues(node1.right, node2.right)) {
                stack.push(new TreeNode[] {node1.left, node2.left});
                stack.push(new TreeNode[] {node1.right, node2.right});
            } else if (checkNodeValues(node1.left, node2.right) && checkNodeValues(node1.right, node2.left)) {
                stack.push(new TreeNode[] {node1.left, node2.right});
                stack.push(new TreeNode[] {node1.right, node2.left});
            } else {
                return false;
            }
        }

        return true;
    }
}
