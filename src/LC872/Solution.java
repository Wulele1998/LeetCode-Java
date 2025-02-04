package LC872;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // time: O(N)
        // space: O(N)
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeaves(root1, list1);
        getLeaves(root2, list2);

        return list1.equals(list2);
    }

    private void getLeaves(TreeNode root, List<Integer> list) {
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(log N)
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            getLeaves(root.left, list);
        }
        if (root.right != null) {
            getLeaves(root.right, list);
        }

    }


}
