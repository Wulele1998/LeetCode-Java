package LC2583;

import library.TreeNode;

import java.util.*;

public class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            long sum = 0L;
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sum += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            list.add(sum);
        }

        Collections.sort(list);

        if (list.size() < k) {
            return -1;
        }

        return list.get(list.size() - k);
    }
}
