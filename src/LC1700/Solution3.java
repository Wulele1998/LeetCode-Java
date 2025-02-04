package LC1700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1700. Number of Students Unable to Eat Lunch
 */
public class Solution3 {
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
        int missedCount = 0;
        while (!queue.isEmpty() && top < n && missedCount < queue.size()) {
            if (queue.peek() == sandwiches[top]) {
                top++;
                queue.poll();
                missedCount = 0;
            } else {
                queue.add(queue.poll());
                missedCount++;
            }
        }

        return queue.size();
    }
}
