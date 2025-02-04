package LC1462;

import java.util.*;

/**
 * LC 1462. Course Schedule IV
 */
public class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // N: the number of courses
        // Q: the number of queries
        // time: O(Q * N ^ 2)
        // space: O(N ^ 2)
        List<Boolean> res = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int[] query : queries) {
            // BFS search to get the result
            res.add(findPre(numCourses, query[0], query[1], map));
        }

        return res;
    }

    private boolean findPre(int n, int start, int target, HashMap<Integer, HashSet<Integer>> map) {
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int pre : map.get(current)) {
                if (pre == target) {
                    return true;
                }
                if (!visited[pre]) {
                    queue.add(pre);
                    visited[pre] = true;
                }
            }
        }

        return false;
    }
}
