package LC549;

import library.TreeNode;

/**
 * LC 549. Binary Tree Longest Consecutive Sequence II
 */
public class Solution {
    int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        // N: the number of node in `root` tree
        // time: O(N)
        // space: O(N), recursion stack
        longestPath(root);

        return maxLength;
    }

    /**
     * get the increasing and decreasing paths start from current tree
     * @param root the root note
     * @return array [ascending path length, descending path length]
     */
    private int[] longestPath(TreeNode root) {
        // base case
        if (root == null) {
            return new int[] {0, 0};
        }

        int leftSubAsc = 0; // left subtree ascending path length
        int leftSubDesc = 0; //  left subtree descending path length
        if (root.left != null) {
            int[] leftSub = longestPath(root.left);
            if (root.left.val == root.val + 1) {
                leftSubAsc = leftSub[0];
            } else if (root.left.val == root.val - 1) {
                leftSubDesc = leftSub[1];
            }
        }

        int rightSubAsc = 0;
        int rightSubDesc = 0;
        if (root.right != null) {
            int[] rightSub = longestPath(root.right);
            if (root.right.val == root.val + 1) {
                rightSubAsc = rightSub[0];
            } else if (root.right.val == root.val - 1) {
                rightSubDesc = rightSub[1];
            }
        }

        maxLength = Math.max(maxLength,
                Math.max(leftSubAsc + rightSubDesc, leftSubDesc + rightSubAsc) + 1
        );

        return new int[] {Math.max(leftSubAsc, rightSubAsc) + 1, Math.max(leftSubDesc, rightSubDesc) + 1};
    }
}
