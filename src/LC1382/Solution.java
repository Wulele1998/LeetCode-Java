package LC1382;

import java.util.List;
import java.util.ArrayList;
import library.TreeNode;

/**
 * Feb 9
 * LC 1382. Balance a Binary Search Tree
 */
public class Solution {
    List<Integer> treeList;
    public TreeNode balanceBST(TreeNode root) {
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        treeList = new ArrayList<>();
        inOrderTraverse(root);
    
        return buildBalancedBST(0, treeList.size() - 1);
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.left);
        treeList.add(node.val);
        inOrderTraverse(node.right);
    }

    private TreeNode buildBalancedBST(int left, int right) {
        // index range: [left, right]
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(treeList.get(mid));
        root.left = buildBalancedBST(left, mid - 1);
        root.right = buildBalancedBST(mid + 1, right);

        return root;
    }
}
