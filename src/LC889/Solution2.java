package LC889;

import library.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 889. Construct Binary Tree from Preorder and Postorder Traversal
 */
public class Solution2 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // time: O(N)
        // space: O(N)
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }

        return constructHelper(preorder, postorder, 0, preorder.length - 1, 0, valToIndex);
    }

    private TreeNode constructHelper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, Map<Integer, Integer> valToIndex) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int leftRootVal = preorder[preStart + 1];
        int numberOfLeftSubtree = valToIndex.get(leftRootVal) - postStart + 1;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = constructHelper(preorder, postorder, preStart + 1, preStart + numberOfLeftSubtree, postStart, valToIndex);
        root.right = constructHelper(preorder, postorder, preStart + numberOfLeftSubtree + 1, preEnd, postStart + numberOfLeftSubtree, valToIndex);

        return root;
    }
}
