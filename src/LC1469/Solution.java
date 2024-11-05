package LC1469;

import java.util.*;
import library.TreeNode;

public class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        findAloneNodes(root);
        return res;
    }

    private void findAloneNodes(TreeNode root){
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            findAloneNodes(root.left);
            findAloneNodes(root.right);
        } else if (root.left == null && root.right == null) {
            return;
        } else if (root.left != null) {
            res.add(root.left.val);
            findAloneNodes(root.left);
        } else {
            res.add(root.right.val);
            findAloneNodes(root.right);
        }
    }
}
