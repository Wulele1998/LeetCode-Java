package LC889;

import library.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 889. Construct Binary Tree from Preorder and Postorder Traversal
 */
public class Solution3 {
    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // time: O(N)
        // space: O(N)
        return constructHelper(preorder, postorder);
    }

    private TreeNode constructHelper(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (root.val != postorder[postIndex]) {
            root.left = constructHelper(preorder, postorder);
        }
        if (root.val != postorder[postIndex]) {
            root.right = constructHelper(preorder, postorder);
        }

        postIndex++;
        return root;
    }
}
