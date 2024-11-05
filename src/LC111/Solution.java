package LC111;

import library.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        // N: the number of node
        // time: O(N)
        // space: O(log N), recursion stack space
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        } else if (root.left != null) {
            return 1 + minDepth(root.left);
        } else if (root.right != null) {
            return 1 + minDepth(root.right);
        } else {
            return 1;
        }
    }
}
