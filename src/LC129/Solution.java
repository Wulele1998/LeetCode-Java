package LC129;

import library.TreeNode;
/**
 * LC 129. Sum Root to Leaf Numbers
 */
public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // N: the number of nodes
        // time: O(N)
        // space: O(N)
        if (root == null) {
            return 0;
        }
        getNumber(root, 0);

        return sum;
    }

    private void getNumber(TreeNode root, int num) {
        num = 10 * num + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        if (root.left != null) {
            getNumber(root.left, num);
        }
        if (root.right != null) {
            getNumber(root.right, num);
        }
    }
}
