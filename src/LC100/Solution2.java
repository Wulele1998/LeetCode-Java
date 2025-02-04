package LC100;

import java.util.Deque;
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
        
        Deque<TreeNode> dequeP = new LinkedList<>();
        Deque<TreeNode> dequeQ = new LinkedList<>();
        dequeP.addLast(p);
        dequeQ.addLast(q);

        while (!dequeP.isEmpty() && !dequeQ.isEmpty()) {
            p = dequeP.pollFirst();
            q = dequeQ.pollFirst();
            
             // in Java Deque cannot accept null, so be sure to make the null check
            if (p != null && q != null) {
               
                if (!check(p.left, q.left))
                    return false;
                dequeP.addLast(p.left);
                dequeQ.addLast(q.left);

                if (!check(p.right, q.right))
                    return false;
                dequeP.addLast(p.right);
                dequeQ.addLast(q.right);
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
