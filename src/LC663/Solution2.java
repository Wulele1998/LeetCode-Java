package LC663;

import library.TreeNode;

import java.util.Stack;

/**
 * LC 663. Equal Tree Partition
 */
public class Solution2 {
    Stack<Integer> stack;
    public boolean checkEqualTree(TreeNode root) {
        // DFS traversal
        // N: the number of tree nodes
        // time: O(N)
        // space: O(N)
        stack = new Stack<>();
        int treeSum = sum(root);
        // remove the root node
        stack.pop();

        if (treeSum % 2 != 0) {
            return false;
        }
        for (int subtreeSum : stack) {
            if (subtreeSum * 2 == treeSum) {
                return true;
            }
        }

        return false;

    }

    private int sum(TreeNode root){
        if (root == null) {
            return 0;
        }
        stack.push(root.val + sum(root.left) + sum(root.right));

        return stack.peek();
    }
}

