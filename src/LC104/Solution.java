package LC104;

import library.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        // N: the number of tree node
        // time: O(N)
        // space: O(log N), recursion stack space
        if (root == null) {
            return 0;
        } 
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
