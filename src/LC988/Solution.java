package LC988;

import library.TreeNode;

/**
 * LC 988. Smallest String Starting From Leaf
 */
public class Solution {
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        // DFS
        // N: the number of the node
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        DFS(root, "");

        return res;
    }

    private void DFS(TreeNode node, String s) {
        if (node == null) {
            return;
        }
        s = (char) (node.val + 'a') + s;
        if (node.left == null && node.right == null) {
            if (res.isEmpty() || res.compareTo(s) > 0) {
                res = s;
            }
        }

        if (node.left != null) {
            DFS(node.left, s);   
        }
        if (node.right != null) {
            DFS(node.right, s);
        }
    }
}
