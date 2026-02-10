package LC110;

import library.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    Map<TreeNode, Integer> heightMap = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        // top-down recursion with memo
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N) => recursive stack
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // O(N)
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (heightMap.containsKey(root)) {
            return heightMap.get(root);
        }
        
        int height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        heightMap.put(root, height);

        return height;
    }
}
