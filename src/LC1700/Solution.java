package LC1700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1700. Number of Students Unable to Eat Lunch
 */
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // brute force simulation
        // N: the length of `students`
        // time: O(N ^ 2)
        // space: O(N)
        int n = students.length;

        Queue<Integer> queue = new LinkedList<>();
        int top = 0; // the index of top at sandwiches stack
        
        for (int student : students) {
            queue.add(student);
        }

        boolean flag = true;
        while (top < n && flag) {
            int num = queue.size();
            flag = false;
            for (int i = 0; i < num; i++) {
                if (!queue.isEmpty() && sandwiches[top] == queue.peek()) {
                    top++;
                    queue.poll();
                    flag = true;
                } else {
                    queue.add(queue.poll());
                }
            }
        }

        return n - top;
    }       
}
