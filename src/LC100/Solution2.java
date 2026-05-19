package LC100;

import java.util.Queue;
import java.util.LinkedList;

import library.TreeNode;

/**
 * LC 100. Same Tree
 */
public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q)  {
        // iteration
        // time: O(N)
        // space: O(N)
        if (!check(p, q))
            return false;
        
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            p = queueP.poll();
            q = queueQ.poll();
            
             // in Java Deque cannot accept null, so be sure to make the null check
            if (p != null && q != null) {
               
                if (!check(p.left, q.left))
                    return false;
                queueP.offer(p.left);
                queueQ.offer(q.left);

                if (!check(p.right, q.right))
                    return false;
                queueP.offer(p.right);
                queueQ.offer(q.right);
            }
        }

        return true;
    }

    /**
     * check the two tree node is equal
     * @param p tree node p
     * @param q tree node q
     * @return whether p equals q
     */
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val;
    }
}
