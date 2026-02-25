package LC1022;

import library.TreeNode;

/**
 * Feb 24, 2026
 * LC 1022. Sum of Root To Leaf Binary Numbers
 */
public class Solution {
    int res;
    public int sumRootToLeaf(TreeNode root) {
        // time: O(N)
        // space: O(N)
        res = 0;
        if (root == null) {
            return 0;
        }

        DFS(root, 0);
        return res;
    }

    private void DFS(TreeNode node, int pathSum) {
        pathSum = pathSum * 2 + node.val;
        if (node.left == null && node.right == null) {
            res += pathSum;
        }
        if (node.left != null) {
            DFS(node.left, pathSum);
        }
        if (node.right != null) {
            DFS(node.right, pathSum);
        }
    }
}
