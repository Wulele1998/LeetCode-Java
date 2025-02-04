package LC979;

import library.TreeNode;

/**
 * LC 979. Distribute Coins in Binary Tree
 */
public class Solution {
    // N: the number of nodes in the tree
    // time: O(N)
    // space: O(N)
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        DFS(root);

        return moves;
    }

    private int DFS(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        int left = DFS(root.left);
        int right = DFS(root.right);

        moves += Math.abs(left) + Math.abs(right);

        return root.val - 1 + left + right;
    }
}
