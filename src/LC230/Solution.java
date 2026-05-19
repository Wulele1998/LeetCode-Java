package LC230;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        inorder(root);

        return list.get(k - 1);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
