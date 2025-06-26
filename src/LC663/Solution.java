package LC663;

import library.TreeNode;

/**
 * LC 663. Equal Tree Partition
 */
public class Solution {
    public boolean checkEqualTree(TreeNode root) {
        // DFS traversal
        // N: the number of tree nodes
        // time: O(N)
        // space: O(N)
        int treeSum = sum(root);

        if (treeSum % 2 != 0) {
            return false;
        }

        return checkHelper(root.left, treeSum) || checkHelper(root.right, treeSum);

    }

    private boolean checkHelper(TreeNode root, int treeSum) {
        if (root == null) {
            return false;
        }
        if (sum(root) * 2 == treeSum) {
            return true;
        }

        return checkHelper(root.left, treeSum) || checkHelper(root.right, treeSum);
    }

    private int sum(TreeNode root){
        if (root == null) {
            return 0;
        }

        return root.val + sum(root.left) + sum(root.right);
    }
}

