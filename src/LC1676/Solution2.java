package LC1676;

import library.TreeNode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * LC 1676. Lowest Common Ancestor of a Binary Tree IV
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // N: the number of nodes in the tree
        // K: the length of `nodes`
        // time: O(N + K)
        // space: O(N)
        HashSet<TreeNode> set = new HashSet<>(Arrays.asList(nodes));

        return recursive(root, set);

    }

    public TreeNode recursive(TreeNode root, HashSet<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }

        TreeNode leftSub = recursive(root.left, set);
        TreeNode rightSub = recursive(root.right, set);

        if (leftSub != null && rightSub != null) {
            // both left subtree and right subtree contains nodes in the set
            return root;
        } else if (leftSub != null) {
            return leftSub;
        } else if (rightSub != null) {
            return rightSub;
        } else {
            // neither left subtree and right subtree contains nodes in the set
            return null;
        }
    }
}
