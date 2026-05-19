package LC105;

import library.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeDFS(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeDFS(int[] preorder, int[] inorder, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null; // base case to end the recursion
        }

        TreeNode root = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = inorderIndexMap.get(preorder[preorderIndex]);
        preorderIndex++;

        // left subtree range [leftIndex, inorderIndex - 1]
        // right subtree range [inorderIndex + 1, rightIndex]
        root.left = buildTreeDFS(preorder, inorder, leftIndex, inorderIndex - 1);
        root.right = buildTreeDFS(preorder, inorder, inorderIndex + 1, rightIndex);

        return root;
    }
}
