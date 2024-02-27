package LC543;

import library.TreeNode;

/**
 * LC 543. Diameter of Binary Tree
 */
public class Solution {
    // DFS
    // time: O(N)
    // space: O(N)
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        DFS(root);

        return res;
    }

    private int DFS(TreeNode root) {
        if (root == null) 
            return 0;
        int leftDepth = DFS(root.left);
        int rightDepth = DFS(root.right);
        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
