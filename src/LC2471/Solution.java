package LC2471;

import library.TreeNode;

import java.util.*;

/**
 * LC 2471. Minimum Number of Operations to Sort a Binary Tree by Level
 */
public class Solution {
    public int minimumOperations(TreeNode root) {
        int res = 0;
        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int[] values = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                values[i] = cur.val;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }

            // calculate the number of swaps
            res += getSwaps(values);
        }

        return res;
    }

    private int getSwaps(int[] values) {
        int[] copy = new int[values.length];
        int swap = 0;
        copy = values.clone();

        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(values[i], i);
        }
        for (int i = 0; i < values.length; i++) {
            if (copy[i] != values[i]) {
                swap++;
            }

            // swap the value
            int index = map.get(copy[i]);
            values[index] =  values[i];
            map.put(values[i], index);
        }

        return swap;
    }
}
