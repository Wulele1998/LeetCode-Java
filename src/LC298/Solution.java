package LC298;

import library.TreeNode;

public class Solution {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);

        return res;
    }

    /**
     * get the length of longest consecutive sequence
     * @param root root node
     * @return ascending length start from root node
     */
    private int longestPath(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        int ascLength = 1;
        if (root.left != null) {
            int leftSub = longestPath(root.left);
            if (root.left.val == root.val + 1) {
                // ascending
                ascLength += leftSub;
            }
        }

        if (root.right != null) {
            int rightSub = longestPath(root.right);
            if (root.right.val == root.val + 1) {
                // ascending
                ascLength = Math.max(ascLength, rightSub + 1);
            }
        }

        res = Math.max(res, ascLength);

        return ascLength;
    }
}
