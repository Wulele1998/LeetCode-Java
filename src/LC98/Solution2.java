package LC98;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 98. Validate Binary Search Tree
 */
public class Solution2 {
    List<Integer> tmp;
    public boolean isValidBST(TreeNode root) {
        tmp = new ArrayList<>();

        inOrderTraversal(root);
        for (int i = 0; i < tmp.size() - 1; i++) {
            if (tmp.get(i) >= tmp.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        tmp.add(root.val);
        inOrderTraversal(root.right);
    }
}
