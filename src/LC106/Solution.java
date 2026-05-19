package LC106;

import library.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> inorderIndexMap; // inorder num => inorder index
    private int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        postorderIndex = postorder.length - 1; // start from the end of the array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeDFS(inorder, postorder, 0, inorder.length - 1);

    }
    // [leftIndex, rightIndex], both side closed interval
    private TreeNode buildTreeDFS(int[] inorder, int[] postorder, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }

        int rootVal = postorder[postorderIndex--];
        int inorderIndex = inorderIndexMap.get(rootVal);
        TreeNode rightSub = buildTreeDFS(inorder, postorder, inorderIndex + 1, rightIndex);
        TreeNode leftSub = buildTreeDFS(inorder, postorder, leftIndex, inorderIndex - 1);

        return new TreeNode(rootVal, leftSub, rightSub);
    }
}