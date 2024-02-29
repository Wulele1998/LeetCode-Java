package LC1609;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import library.TreeNode;

/**
 * LC 1609. Even Odd Tree
 */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        // BFS
        // N: the number of node in the tree
        // time: O(N)
        // space: O(N)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if ((level & 1) == (cur.val & 1)) {
                    return false;
                }
                if (!nums.isEmpty()) {
                    if ((level & 1) == 1 && nums.get(nums.size() - 1) <= cur.val) {
                        return false;
                    }
                    if ((level & 1) == 0 && nums.get(nums.size() - 1) >= cur.val) {
                        return false;
                    }
                }
                
                nums.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            level++;
        }
        return true;
    }
}
