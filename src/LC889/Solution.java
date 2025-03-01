package LC889;

import library.TreeNode;

/**
 * LC 889. Construct Binary Tree from Preorder and Postorder Traversal
 */
public class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // time: O(N ^ 2)
        // space: O(N)
        return constructHelper(preorder, postorder, 0, preorder.length - 1, 0);
    }

    private TreeNode constructHelper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart) {
        // pre order => root -> left - > right
        // post order => left -> right -> root

        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int leftRootVal = preorder[preStart + 1];
        int numLeftSubtree = 1;
        // left subtree: preorder[preStart + 1, preStart + numLeftSubtree]
        while (postorder[postStart + numLeftSubtree - 1] != leftRootVal) {
            numLeftSubtree++;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = constructHelper(preorder, postorder, preStart + 1, preStart + numLeftSubtree, postStart);
        root.right = constructHelper(preorder, postorder, preStart + numLeftSubtree + 1, preEnd, postStart + numLeftSubtree);

        return root;
    }
}
